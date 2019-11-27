package com.clinbrain.datac.common.schema;

import com.clinbrain.datac.util.DateUtils;
import com.clinbrain.datac.util.StringUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.directory.api.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.*;
import java.util.stream.Collectors;

public class Table implements Comparable<Table> {

    private static final Logger LOG = LoggerFactory.getLogger(Table.class);
    private String name = null;
    private String schema = null;
    private List<Column> columns = new ArrayList<>();
    private List<Column> pkColumns = new ArrayList<>();
    private Map<String, Class<Object>> columnTypes = new HashMap<>();

    private List<String> excludeColumns = Lists.newArrayList("isdeleted", "lastupdatedttm", "rowkey");

    private String queryCount;

    private String query; // count id

    private String queryAll;

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String s) {
        schema = s;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public List<Column> getPkColumns() {
        return pkColumns;
    }

    public void setPkColumns(List<Column> pkColumns) {
        this.pkColumns = pkColumns;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQueryCount() {
        return queryCount;
    }

    public void setQueryCount(String queryCount) {
        this.queryCount = queryCount;
    }

    public void addColumn(Column column) throws SchemaException {
        if (column == null) {
            throw new SchemaException("Column is null!");
        }
        String columnName = column.getName();
        if (!containsColumn(columnName)) {
            columns.add(column);
        }

    }

    public Table(String tableName, String customSql, String timeColumn, DataSource ds) throws Exception {
        LOG.info("准备读取["+tableName+"] 元数据...");
        this.name = tableName;
        ResultSet rs = null;
        Connection conn = null;
        TableInfo tableInfo = null;
        try {
            LOG.info("是否使用自定义sql："+StringUtils.isNotEmpty(StringUtils.trim(customSql)));
            if (StringUtils.isNotEmpty(StringUtils.trim(customSql))) {
                QueryRunner r = new QueryRunner(ds);
                String tempSql = StringUtils.messageFormat(customSql, DateUtils.dateTimeNow("yyyy-MM-dd"),
                        DateUtils.dateTimeNow("yyyy-MM-dd")) + " AND 1 = 0 ";
                r.query(tempSql, rs1 -> {
                    final ResultSetMetaData rsMetaData = rs1.getMetaData();
                    int columnCount = rsMetaData.getColumnCount();
                    pkColumns.clear();
                    columns.clear();
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = rsMetaData.getColumnName(i);
                        int columnType = rsMetaData.getColumnType(i);
                        Column column = new Column(columnName, columnType, "VARCHAR", "", true);
                        pkColumns.add(column);
                        columns.add(column);
                    }
                    return columns;
                });
                query = queryAll = queryCount = customSql;
                LOG.info("使用自定义sql定义查询："+customSql);
            } else {
                conn = ds.getConnection();
                DBObjectNameEscaper escaper =
                        new DBObjectNameEscaper(conn.getMetaData().getIdentifierQuoteString());
                LOG.info("数据库关键字转义符："+escaper.escapeObjectName("key"));
                DatabaseMetaData metaData = conn.getMetaData();
                if (tableName.contains(".")) {
                    schema = StringUtils.substringBefore(tableName, ".");
                }
                LOG.info("数据库schema："+schema);
                Preconditions.checkNotNull(schema, "数据库Schema为空，初始化表失败！");
                tableInfo = TableInfo.init(metaData, tableName);
                LOG.info("数据库表信息{}", tableInfo);
                Preconditions.checkNotNull(tableInfo.name, "查找数据库表[" + tableName + "]元数据为空，初始化表失败！");
                LOG.info("准备读取数据表列，主键...");
                rs = metaData.getColumns(tableInfo.catalog, tableInfo.schema, tableInfo.name, null);
                final ResultSet pkRs = metaData.getPrimaryKeys(tableInfo.catalog, tableInfo.schema, tableInfo.name);
                List<String> pkList = new Vector<>();
                while (pkRs.next()) {
                    pkList.add(pkRs.getString("COLUMN_NAME"));
                }

                while (rs.next()) {
                    String columnName = rs.getString("COLUMN_NAME");
                    int columnType = rs.getInt("DATA_TYPE");
                    String columnDataTypeName = rs.getString("TYPE_NAME");
                    String columnComment = StringUtils.trim(rs.getString("REMARKS"));
                    if (columnType != Types.OTHER) {
                        columnTypes.put(columnName.toLowerCase(), typeValueOf(columnType));
                    }
                    if ("pk".equalsIgnoreCase(columnComment.trim())) {
                        pkList.add(columnName);
                    }

                    addColumn(new Column(columnName, columnType, columnDataTypeName, columnComment,
                            pkList.contains(columnName)));
                }

                //            Preconditions.checkArgument(!pkList.isEmpty(), "表[" + name + "] 没有找到主键，初始化表失败！");
                pkColumns = columns.stream().filter(Column::isPrimaryKey).collect(Collectors.toList());
                if (pkColumns.isEmpty()) {
                    LOG.warn("表[" + name + "] 没有找到主键，不能正常初始化表信息，使用第一个列作为查询条件！");
                    pkColumns = columns.stream().limit(1).collect(Collectors.toList());
                }

                boolean hasTimeColumn = StringUtils.isNotBlank(timeColumn);
                if (hasTimeColumn) {
                    excludeColumns.add("p_" + timeColumn);
                }
                LOG.info("去掉不比对的字段信息:{}", StringUtils.join(excludeColumns,","));
                // 拼接查询sql ,包括 查询总数，查询主键，查询所有列
                StringBuilder sql = new StringBuilder("SELECT ");
                sql.append(pkColumns.stream().filter(c -> !excludeColumns.contains(c.getName()))
                        .map(c -> escaper.escapeObjectName(c.getName()))
                        .collect(Collectors.joining(",")));
                if (hasTimeColumn) {
                    LOG.info("查询添加时间列..." + timeColumn);
                    sql.append(",").append(timeColumn);
                }
                String fromTable = getFromTableName(escaper, tableInfo.catalog, tableInfo.schema, tableInfo.name);
                sql.append(" FROM ").append(fromTable).append(" WHERE 1 = 1");


                //---------------------------------------------------------------

                StringBuilder sqlCount = new StringBuilder("SELECT ");
                sqlCount.append(" COUNT(").append(pkColumns.stream().findFirst().filter(c -> !excludeColumns.contains(c.getName()))
                        .map(c -> escaper.escapeObjectName(c.getName())).orElse("1")).append(") AS acount");

                sqlCount.append(" FROM ").append(fromTable).append(" WHERE 1 = 1");

                //---------------------------------------------------------------

                StringBuilder queryAllBuffer = new StringBuilder("SELECT ");
                queryAllBuffer.append(columns.stream().filter(c -> !excludeColumns.contains(c.getName()))
                        .map(c -> escaper.escapeObjectName(c.getName()))
                        .collect(Collectors.joining(",")));
                queryAllBuffer.append(" FROM ").append(fromTable).append(" WHERE 1 = 1 ");

                if (columns.stream().anyMatch(c -> "isdeleted".equalsIgnoreCase(c.getName()))) {
                    sql.append(" AND isdeleted = '0'");
                    sqlCount.append(" AND isdeleted = '0'");
                    queryAllBuffer.append(" AND isdeleted = '0'");
                }

                query = sql.toString();
                queryCount = sqlCount.toString();
                queryAll = queryAllBuffer.toString();

                pkColumns = pkColumns.stream().filter(c -> !excludeColumns.contains(c.getName())).collect(Collectors.toList());
                columns = columns.stream().filter(c -> !excludeColumns.contains(c.getName())).collect(Collectors.toList());

            }
        } catch (Exception e) {
            String extMsg = e.getMessage();
            if (e instanceof SQLException) {
                extMsg = "\nSQL error message: " + e.getMessage();
            }
            LOG.info("处理表["+tableName+"]信息出错", e);
            throw new RuntimeException(extMsg);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if(conn != null) {
                conn.close();
            }
        }

        LOG.info("查询主键: " + query);
        LOG.info("查询所有: " + queryAll);
        LOG.info("初始化表 <" + name + "> 结构完成.");
    }

    public String getQueryAll() {
        return queryAll;
    }

    public void setQueryAll(String queryAll) {
        this.queryAll = queryAll;
    }

    /**
     * Returns list of columns.
     *
     * @return list of columns
     */
    public List<Column> getColumns() {
        return columns;
    }

    /**
     * @see Comparable#compareTo(Object)
     */
    public int compareTo(Table t) {
        return getName().compareTo(t.getName());
    }


    public String getFromTableName(DBObjectNameEscaper escaper, String catalog, String schema, String name) {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotEmpty(catalog)) {
            sb.append(escaper.escapeObjectName(catalog)).append(".");
        }
        if (StringUtils.isNotEmpty(schema)) {
            sb.append(escaper.escapeObjectName(schema)).append(".");
        }
        if (StringUtils.isNotEmpty(name)) {
            sb.append(escaper.escapeObjectName(name));
        }
        return sb.toString();
    }

    /**
     * Removes column from table.
     *
     * @param column column to remove
     */
    public void removeColumn(Column column) {
        for (int i = 0; i < columns.size(); i++) {
            Column c = columns.get(i);
            if (c == column) {
                columns.remove(i);
                break;
            }
        }
    }

    public boolean containsColumn(String name) {
        for (int i = 0; i < columns.size(); i++) {
            Column column = columns.get(i);
            if (name.equals(column.getName())) {
                return true;
            }
        }
        return false;
    }

    public Column findColumn(String name) {
        Column c = null;
        for (int i = 0; i < columns.size(); i++) {
            c = columns.get(i);
            if (c.getName().equals(name)) {
                return c;
            }
            c = null;
        }
        return c;
    }

    /**
     * Returns the name of this table, minus any schema prefix if one exists.
     *
     * @return the table name minus schema prefix.
     */
    public String getUnqualifiedName() {
        String result = name;
        if (name.indexOf(".") != -1) {
            result = name.substring(name.lastIndexOf(".") + 1);
        }
        return result;
    }

    /**
     * Returns a boolean indicating whether or not the specified type is a
     * binary type.
     *
     * @param type the SQL type from java.sql.Types.
     * @return true if the specified type is binary; false otherwise.
     */
    private boolean isBinary(int type) {
        if (type == Types.BINARY || type == Types.BLOB || type == Types.LONGVARBINARY || type == Types.VARBINARY) {
            return true;
        } else {
            return false;
        }
    }

    public Map<String, Class<Object>> getColumnTypes() {
        return columnTypes;
    }

    public void setColumnTypes(
            Map<String, Class<Object>> columnTypes) {
        this.columnTypes = columnTypes;
    }

    private Class typeValueOf(int jdbcType) {
        switch (jdbcType) {

            case Types.CHAR:
            case Types.NCHAR:
            case Types.VARCHAR:
            case Types.LONGVARCHAR:
            case Types.NVARCHAR:
            case Types.LONGNVARCHAR:
            case Types.CLOB:
            case Types.NCLOB:
                return String.class;

            case Types.SMALLINT:
            case Types.TINYINT:
            case Types.INTEGER:
            case Types.BIGINT:
                return Long.class;

            case Types.NUMERIC:
            case Types.DECIMAL:
            case Types.FLOAT:
            case Types.REAL:
            case Types.DOUBLE:
                return Double.class;

            case Types.TIME:
                return Date.class;

            case Types.DATE:
                return Long.class;

            case Types.TIMESTAMP:
                return Timestamp.class;

            case Types.BINARY:
            case Types.VARBINARY:
            case Types.BLOB:
            case Types.LONGVARBINARY:
                return Byte.TYPE;

            case Types.BOOLEAN:
            case Types.BIT:
                return Boolean.class;

            default:
                return String.class;
        }
    }

    public final static class TableInfo {
        private String catalog;
        private String schema;
        private String name;
        private String type;
        private String remarks;

        public TableInfo() {
        }

        private TableInfo(String catalog, String schema, String name, String type, String remarks) {
            this.catalog = catalog;
            this.schema = schema;
            this.name = name;
            this.type = type;
            this.remarks = remarks;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        }

        /**
         * 初始化读取表结构信息
         * @param metaData
         * @param tableName
         * @return
         */
        public static TableInfo init(DatabaseMetaData metaData, String tableName) {
            String tempCatalog = null, tempSchema = null, tempName = null;
            if (tableName.contains(".")) {
                tempSchema = StringUtils.substringBefore(tableName, ".");
                tempName = StringUtils.substringAfter(tableName, ".");
                if (tempName.contains(".")) {
                    tempCatalog = tempSchema;
                    tempSchema = StringUtils.substringBefore(tempName, ".");
                    tempName = StringUtils.substringAfter(tempName, ".");
                }
            }
            String catalogStr = null;
            String schemaStr = null;
            String nameStr = null;
            String typeStr = null;
            String remarksStr = null;
            LOG.info("---准备读取数据库表信息----");
            try {
                ResultSet rs = metaData.getTables(tempCatalog, tempSchema, tempName, new String[]{"TABLE"});
                if (!rs.next()) {
                    LOG.info("---catalog:"+ tempCatalog +" 和 scheme:" +tempSchema+" 和 tableName:"+tableName+" 转成大写后再次尝试获取----");
                    rs = metaData.getTables(Strings.toUpperCase(tempCatalog), Strings.toUpperCase(tempSchema), Strings.toUpperCase(tempName), new String[]{"TABLE"});
                    if (!rs.next()) {
                        throw new RuntimeException("无法获取表[" + tableName + "]信息，请确认表是否存在？");
                    }
                }

                do {
                    String tableN = rs.getString("TABLE_NAME");
                    if (!tableN.equalsIgnoreCase(tempName)) continue;
                    catalogStr = rs.getString("TABLE_CAT");
                    schemaStr = rs.getString("TABLE_SCHEM");
                    nameStr = tableN;
                    typeStr = rs.getString("TABLE_TYPE");
                    remarksStr = rs.getString("REMARKS");
                    break;
                } while ((rs.next()));

            } catch (Exception e) {
                LOG.error("获取表[" + tableName + "]信息出错", e);
            }
            return new TableInfo(catalogStr, schemaStr, nameStr, typeStr, remarksStr);
        }
    }

}
