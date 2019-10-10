package com.clinbrain.datac.compare;

import com.clinbrain.datac.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;

import static com.clinbrain.datac.util.DateUtils.YYYY_MM_DD_HH_MM_SS;

/**
 * Created by Liaopan on 2019/7/17.
 */
public class ResultSetUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ResultSetUtil.class);

    public static Object getValue(ResultSet rs, int i, int columnType) {
        Object returnObject = null;
        try {
            switch (columnType) {
                case Types.CHAR:
                case Types.NCHAR:
                case Types.VARCHAR:
                case Types.LONGVARCHAR:
                case Types.NVARCHAR:
                case Types.LONGNVARCHAR:
                    returnObject = rs.getString(i);
                    break;

                case Types.CLOB:
                case Types.NCLOB:
                    returnObject = rs.getString(i);
                    break;

                case Types.SMALLINT:
                case Types.TINYINT:
                case Types.INTEGER:
                case Types.BIGINT:
                    returnObject = rs.getString(i);
                    break;

                case Types.NUMERIC:
                case Types.DECIMAL:
                case Types.FLOAT:
                case Types.REAL:
                case Types.DOUBLE:
                    returnObject = rs.getString(i);
                    break;

                case Types.TIME:
                    returnObject = rs.getString(i);
                    break;

                // for mysql bug, see http://bugs.mysql.com/bug.php?id=35115
                case Types.DATE:
                    if (rs.getMetaData().getColumnTypeName(i).equalsIgnoreCase(
                            "year")) {
                        returnObject = rs.getInt(i);
                    } else {
                        returnObject = rs.getString(i);
                    }
                    break;

                case Types.TIMESTAMP:
                    String tempData = null;
                    if(rs.getString(i) != null) {
                        Timestamp timestamp = rs.getTimestamp(i);
                        tempData = DateUtils.format(timestamp,YYYY_MM_DD_HH_MM_SS);
                    }
                    returnObject = tempData;
                    break;

                case Types.BINARY:
                case Types.VARBINARY:
                case Types.BLOB:
                case Types.LONGVARBINARY:
                    returnObject = rs.getBytes(i);
                    break;

                // warn: bit(1) -> Types.BIT 可使用BoolColumn
                // warn: bit(>1) -> Types.VARBINARY 可使用BytesColumn
                case Types.BOOLEAN:
                case Types.BIT:
                    returnObject = rs.getString(i);
                    break;

                case Types.NULL:
                    String stringData = null;
                    if (rs.getObject(i) != null) {
                        stringData = rs.getObject(i).toString();
                    }
                    returnObject = stringData;
                    break;

                default:
                    // warn:not support INTERVAL etc: Types.JAVA_OBJECT
                    returnObject = rs.getString(i);
            }
        } catch (Exception e) {
            LOG.error("获取数据出错");
        }
        return returnObject;
    }
}
