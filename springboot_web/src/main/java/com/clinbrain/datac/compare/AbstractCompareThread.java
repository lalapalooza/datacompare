package com.clinbrain.datac.compare;

import cn.hutool.core.util.StrUtil;
import com.clinbrain.datac.common.schema.Column;
import com.clinbrain.datac.common.schema.Table;
import com.clinbrain.datac.compare.define.CompareResult;
import com.clinbrain.datac.model.auto.TConnection;
import com.clinbrain.datac.model.auto.TableConfig;
import com.clinbrain.datac.model.auto.TableLoggerWithBLOBs;
import com.clinbrain.datac.service.TableLoggerService;
import com.clinbrain.datac.util.DataSourceManager;
import com.clinbrain.datac.util.DateUtils;
import com.clinbrain.datac.util.SpringContextUtils;
import com.clinbrain.datac.util.StringUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Liaopan on 2019/7/24.
 */
public abstract class AbstractCompareThread implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(CompareTask.class);

    protected TConnection source;
    protected TConnection target;

    protected DataSource sourceDataSource;
    protected DataSource targetDataSource;

    protected static final Gson GSON = new Gson();
    protected TableConfig table;

    List<Column> sourceFieldList;
    List<Column> targetFieldList;

    protected Table sourceTable;
    protected Table targetTable;

    private String mdcValue;

    protected TableLoggerWithBLOBs tableLoggerWithBLOBs;

    private static final TableLoggerService loggerService = SpringContextUtils.getBean("tableLoggerService");


    private static final String LOG_PATH
            = SpringContextUtils.getApplicationContext().getEnvironment().getProperty("log.path");

    public AbstractCompareThread(TableConfig tableConfig) {
        this.table = tableConfig;
        this.mdcValue = table.getTargetTable() + "_" + UUID.randomUUID().toString();
    }

    public AbstractCompareThread(TableConfig tableConfig, String MDCValue) {
        this.table = tableConfig;
        this.mdcValue = MDCValue;
    }

    private void initialize() throws Exception {
        LOG.info("#######初始化： 源和目标数据信息##########");
        source = table.getSourceConfig();
        target = table.getTargetConfig();
        Preconditions.checkNotNull(source, "确认源连接信息是否存在？");
        Preconditions.checkNotNull(target, "确认目标连接源是否存在？");

        // mysql 获取元数据需要连接字符串带数据库
        if (source.getUrl().startsWith("jdbc:mysql")) {
            source.setUrl(source.getUrl() + "/" + StringUtils.substringBefore(table.getSourceTable(), "."));
        }
        if (target.getUrl().startsWith("jdbc:mysql")) {
            target.setUrl(target.getUrl() + "/" + StringUtils.substringBefore(table.getTargetTable(), "."));
        }

        sourceDataSource = DataSourceManager.getInstance(source.getDriver(), source.getUrl(),
                source.getUser(), source.getPassword());
        Preconditions.checkNotNull(sourceDataSource, "创建源连接池失败"+source.getUrl());
        LOG.info("------初始化源：（创建连接）成功-------");

        targetDataSource = DataSourceManager.getInstance(target.getDriver(), target.getUrl(),
                target.getUser(), target.getPassword());
        Preconditions.checkNotNull(targetDataSource, "创建目标连接池失败"+target.getUrl());
        LOG.info("------初始化目标：（创建连接）成功-----");

        LOG.info("$===== 处理 源表（" +table.getSourceTable()+"） ===开始===$");
        sourceTable = new Table(table.getSourceTable(), table.getSourceSql(), table.getPartitionColumn(),
                sourceDataSource);
        sourceFieldList = sourceTable.getColumns();
        LOG.info("$===== 处理 源 ===完成===$");
        LOG.info("$===== 处理 目标（" +table.getTargetTable()+"） ===开始===$");
        targetTable = new Table(table.getTargetTable(), table.getTargetSql(), table.getPartitionColumn(),
                targetDataSource);
        targetFieldList = targetTable.getColumns();
        LOG.info("$===== 处理 目标 ===完成====$");

        StringBuilder sourceQuery = new StringBuilder(sourceTable.getQuery());
        StringBuilder sourceQueryAll = new StringBuilder(sourceTable.getQueryAll());
        StringBuilder sourceQueryCount = new StringBuilder(sourceTable.getQueryCount());

        StringBuilder targetQuery = new StringBuilder(targetTable.getQuery());
        StringBuilder targetQueryAll = new StringBuilder(targetTable.getQueryAll());
        StringBuilder targetQueryCount = new StringBuilder(targetTable.getQueryCount());

        String patitionColumnName = table.getPartitionColumn();
        if (StringUtils.isNotEmpty(patitionColumnName)) {
            LOG.info("添加时间查询参数：" + patitionColumnName);
            StringBuilder condition = new StringBuilder(" AND ( ").append(patitionColumnName).append(" >= ")
                    .append("{1}").append(" AND ").append(patitionColumnName).append(" < {2}) ");
            sourceQuery.append(StringUtils.messageFormat(condition.toString()
                    , StringUtils.messageFormat(getSourceDateTemplate(), DateUtils.format(table.getStartDate(), "yyyy-MM-dd")),
                    StringUtils.messageFormat(getSourceDateTemplate(), DateUtils.format(table.getEndDate(), "yyyy-MM-dd"))));
            sourceQueryAll.append(StringUtils.messageFormat(condition.toString()
                    , StringUtils.messageFormat(getSourceDateTemplate(), DateUtils.format(table.getStartDate(), "yyyy-MM-dd")),
                    StringUtils.messageFormat(getSourceDateTemplate(), DateUtils.format(table.getEndDate(), "yyyy-MM-dd"))));
            sourceQueryCount.append(StringUtils.messageFormat(condition.toString()
                    , StringUtils.messageFormat(getSourceDateTemplate(), DateUtils.format(table.getStartDate(), "yyyy-MM-dd")),
                    StringUtils.messageFormat(getSourceDateTemplate(), DateUtils.format(table.getEndDate(), "yyyy-MM-dd"))));

            targetQuery.append(StringUtils.messageFormat(condition.toString()
                    , StringUtils.messageFormat(getTargetDateTemplate(), DateUtils.format(table.getStartDate(), "yyyy-MM-dd")),
                    StringUtils.messageFormat(getTargetDateTemplate(), DateUtils.format(table.getEndDate(), "yyyy-MM-dd"))));
            targetQueryAll.append(StringUtils.messageFormat(condition.toString()
                    , StringUtils.messageFormat(getTargetDateTemplate(), DateUtils.format(table.getStartDate(), "yyyy-MM-dd")),
                    StringUtils.messageFormat(getTargetDateTemplate(), DateUtils.format(table.getEndDate(), "yyyy-MM-dd"))));
            targetQueryCount.append(StringUtils.messageFormat(condition.toString()
                    , StringUtils.messageFormat(getTargetDateTemplate(), DateUtils.format(table.getStartDate(), "yyyy-MM-dd")),
                    StringUtils.messageFormat(getTargetDateTemplate(), DateUtils.format(table.getEndDate(), "yyyy-MM-dd"))));
            sourceTable.setQuery(sourceQuery.toString());
            targetTable.setQuery(targetQuery.toString());
            sourceTable.setQueryAll(sourceQueryAll.toString());
            targetTable.setQueryAll(targetQueryAll.toString());
            sourceTable.setQueryCount(sourceQueryCount.toString());
            targetTable.setQueryCount(targetQueryCount.toString());
        }

        // 处理查询主键和时间的sql: 如果有配置sql， 直接使用配置的替换掉时间； 如果没有，还是使用上面的query
        if (StringUtils.isNotEmpty(table.getSourceSql())) {
            String tempSql = StringUtils.messageFormat(table.getSourceSql(),
                    DateUtils.format(table.getStartDate(), "yyyy-MM-dd"),
                    DateUtils.format(table.getEndDate(), "yyyy-MM-dd"));
            sourceTable.setQuery(tempSql);
            sourceTable.setQueryAll(tempSql);
            sourceTable.setQueryCount(tempSql);
        }
        if (StringUtils.isNotEmpty(table.getTargetSql())) {
            String tempSql = StringUtils.messageFormat(table.getTargetSql(),
                    DateUtils.format(table.getStartDate(), "yyyy-MM-dd"),
                    DateUtils.format(table.getEndDate(), "yyyy-MM-dd"));
            targetTable.setQuery(tempSql);
            targetTable.setQueryAll(tempSql);
            targetTable.setQueryCount(tempSql);
        }

        LOG.info("#######初始化成功#######");
    }

    protected abstract CompareResult taskRun(String sourceQuery, String targetQuery, Class<? extends BaseCompare> compareClass) throws Exception;

    @Override
    public void run() {
        MDC.put("logFileName", mdcValue);
        CompareResult result = null;
        String errMsg = null;
        try {
            LOG.info("====start (" + table.getTargetTable() + ")====");
            initSaveLogger();
            initialize();
            // 计算表结构是否一致
            Pair<Boolean, CompareResult> resultPair = calcColumnsDiff();
            if(resultPair.getLeft()) {
                result = resultPair.getRight();
                if(!loggerService.getIgnore()) {
                    return ;
                }
                result = null;
            }
            Class<? extends BaseCompare> compareClass = CompareTaskFactory.getCompareTask(table.getOnlyCount());
            String sourceQuery = sourceTable.getQuery();
            String targetQuery = targetTable.getQuery();
            if (JobConstants.ExecStrategy.COUNT.getCode().equalsIgnoreCase(table.getOnlyCount())) {
                sourceQuery = sourceTable.getQueryCount();
                targetQuery = targetTable.getQueryCount();
            } else if (JobConstants.ExecStrategy.COUNT_DETAIL.getCode().equalsIgnoreCase(table.getOnlyCount())){
                sourceQuery = sourceTable.getQueryAll();
                targetQuery = targetTable.getQueryAll();
            }
            result = taskRun(sourceQuery, targetQuery, compareClass);
        } catch (Exception e) {
            LOG.error("任务执行失败", e);
            errMsg = ExceptionUtils.getFullStackTrace(e);
        } finally {
            postTaskRun(result, errMsg);
            MDC.remove("logFileName");
            if(result != null) {
                result.clear();
                result = null;
            }
        }
    }

    private Pair<Boolean,CompareResult> calcColumnsDiff() {
        final CompareResultMap.Builder builder = new CompareResultMap.Builder();
        /**
         *  判断源和目标的数据结构是否一致，主要是生成的类是否一致
         */
        Set<String> difference = Sets.newHashSet();
        if(null != sourceFieldList && null != targetFieldList) {
            Set<String> sourceFields = Sets.newHashSet(sourceFieldList.stream().map(c-> org.apache.commons.lang.StringUtils.lowerCase(c.getName())).collect(Collectors.toList()));
            Set<String> targetFields = Sets.newHashSet(targetFieldList.stream().map(c-> org.apache.commons.lang.StringUtils.lowerCase(c.getName())).collect(Collectors.toList()));

            difference = Sets.symmetricDifference(sourceFields, targetFields);
        }

        if(!difference.isEmpty()) {
            builder.left(Maps.newHashMap());
            builder.lMessage("比对表中有不一样的字段：" + org.apache.commons.lang.StringUtils.join(difference,","));
            builder.right(Maps.newHashMap());
            builder.rMessage("原表字段（"+sourceFieldList.size() + "）:"+
                    org.apache.commons.lang.StringUtils.join(sourceFieldList.stream().map(Column::getName).collect(Collectors.toList()),",")+"， " +
                    "目标表字段（" + targetFieldList.size() + "）：" +
                    org.apache.commons.lang.StringUtils.join(targetFieldList.stream().map(Column::getName).collect(Collectors.toList()),","));
            return new MutablePair<>(true,builder.builder());
        }
        return new MutablePair<>(false,null);
    }

    /**
     * 先保存日志记录，便于查询正在执行（status = 1）,日志路径
     */
    private void initSaveLogger() {
        String saveLogPath = LOG_PATH + DateFormatUtils.format(new Date(), "yyyy-MM-dd") + "/" + mdcValue + ".log";
        tableLoggerWithBLOBs = new TableLoggerWithBLOBs(null, saveLogPath, table.getId(),
                "-1", "-1", table.getStartDate(),
                table.getEndDate(), new Date(), 1, null, null, null);
        loggerService.insertSelective(tableLoggerWithBLOBs);
    }

    protected void postTaskRun(CompareResult result, String errMsg) {

        //先假设失败
        tableLoggerWithBLOBs.setMessage(errMsg);
        tableLoggerWithBLOBs.setStatus(-1);
        if (result != null) {
            int status = result.isSuccessed() ? 0 : -1;

            int lSize = status == 0 ? result.getLeftSize() : -1;
            int rSize = status == 0 ? result.getRightSize() : -1;
            String message = status == 0 ? null : result.getlMessage() + "\n|" + result.getrMessage();

            LOG.info("===> "+table.getSourceTable() + " / " + table.getTargetTable() + ", 数据比对完成：源：" + lSize + " 目标：" + rSize);
            String sourceData = null;
            String targetData = null;
            if(status > -1) {
                if(result.getType().equals(JobConstants.ExecStrategy.COUNT)) {
                    int leftDiffCount = result.getLeftSize() - result.getRightSize();
                    int rightDiffCount = result.getRightSize() - result.getLeftSize();
                    if(leftDiffCount != 0) {
                        sourceData = leftDiffCount + "|[]";
                    }
                    if(rightDiffCount != 0) {
                        targetData = rightDiffCount + "|[]";
                    }
                }else {
                    Pair<List, List> listPair = result.leftCompareRight();
                    List left = listPair.getLeft();
                    List right = listPair.getRight();

                    if (left.size() > 0) {
                        sourceData = left.size() + "|" + (left.size() > 20000 ? GSON.toJson(left.subList(0, 100)) : GSON.toJson(left));
                    }

                    if (right.size() > 0) {
                        targetData = right.size() + "|" + (right.size() > 20000 ? GSON.toJson(right.subList(0, 100)) : GSON.toJson(right));
                    }
                    LOG.info("===> "+table.getSourceTable() + " / " + table.getTargetTable() + ", 数据比对完成(差异)：源：" + left.size() + " 目标：" + right.size());
                }
            }

            tableLoggerWithBLOBs.setSourceBatch(String.valueOf(lSize));
            tableLoggerWithBLOBs.setTargetBatch(String.valueOf(rSize));
            tableLoggerWithBLOBs.setCreateDate(new Date());
            tableLoggerWithBLOBs.setStatus(status);
            tableLoggerWithBLOBs.setSourceData(sourceData);
            tableLoggerWithBLOBs.setTargetData(targetData);
            tableLoggerWithBLOBs.setMessage(message);
        }
        loggerService.updateByPrimaryKeySelective(tableLoggerWithBLOBs);
    }

    public String getSourceDateTemplate() {
        return getDateFunTemplate(source.getUrl());
    }

    public String getTargetDateTemplate() {
        return getDateFunTemplate(target.getUrl());
    }

    public String getDateFunTemplate(String rawUrl) {
        if (rawUrl == null) {
            return null;
        }

        if (rawUrl.startsWith("jdbc:derby:") || rawUrl.startsWith("jdbc:log4jdbc:derby:")) {
            return "";
        } else if (rawUrl.startsWith("jdbc:mysql:") || rawUrl.startsWith("jdbc:cobar:")
                || rawUrl.startsWith("jdbc:log4jdbc:mysql:")) {
            return "'{1}'";
        } else if (rawUrl.startsWith("jdbc:mariadb:")) {
            return "";
        } else if (rawUrl.startsWith("jdbc:oracle:") || rawUrl.startsWith("jdbc:log4jdbc:oracle:")) {
            return "to_date('{1}','yyyy-mm-dd')";
        } else if (rawUrl.startsWith("jdbc:microsoft:") || rawUrl.startsWith("jdbc:log4jdbc:microsoft:")) {
            return "CONVERT(date, '{1}', 23)";
        } else if (rawUrl.startsWith("jdbc:sqlserver:") || rawUrl.startsWith("jdbc:log4jdbc:sqlserver:")) {
            return "CONVERT(date, '{1}', 23)";
        } else if (rawUrl.startsWith("jdbc:sybase:Tds:") || rawUrl.startsWith("jdbc:log4jdbc:sybase:")) {
            return "";
        } else if (rawUrl.startsWith("jdbc:postgresql:") || rawUrl.startsWith("jdbc:log4jdbc:postgresql:")) {
            return "";
        } else if (rawUrl.startsWith("jdbc:edb:")) {
            return "";
        } else if (rawUrl.startsWith("jdbc:hsqldb:") || rawUrl.startsWith("jdbc:log4jdbc:hsqldb:")) {
            return "";
        } else if (rawUrl.startsWith("jdbc:odps:")) {
            return "";
        } else if (rawUrl.startsWith("jdbc:db2:")) {
            return "";
        } else if (rawUrl.startsWith("jdbc:sqlite:")) {
            return "";
        } else if (rawUrl.startsWith("jdbc:ingres:")) {
            return "ingres";
        } else if (rawUrl.startsWith("jdbc:h2:") || rawUrl.startsWith("jdbc:log4jdbc:h2:")) {
            return "";
        } else if (rawUrl.startsWith("jdbc:mckoi:")) {
            return "mckoi";
        } else if (rawUrl.startsWith("jdbc:cloudscape:")) {
            return "cloudscape";
        } else if (rawUrl.startsWith("jdbc:informix-sqli:") || rawUrl.startsWith("jdbc:log4jdbc:informix-sqli:")) {
            return "informix";
        } else if (rawUrl.startsWith("jdbc:timesten:")) {
            return "timesten";
        } else if (rawUrl.startsWith("jdbc:as400:")) {
            return "as400";
        } else if (rawUrl.startsWith("jdbc:sapdb:")) {
            return "sapdb";
        } else if (rawUrl.startsWith("jdbc:JSQLConnect:")) {
            return "JSQLConnect";
        } else if (rawUrl.startsWith("jdbc:JTurbo:")) {
            return "JTurbo";
        } else if (rawUrl.startsWith("jdbc:firebirdsql:")) {
            return "firebirdsql";
        } else if (rawUrl.startsWith("jdbc:interbase:")) {
            return "interbase";
        } else if (rawUrl.startsWith("jdbc:pointbase:")) {
            return "pointbase";
        } else if (rawUrl.startsWith("jdbc:edbc:")) {
            return "edbc";
        } else if (rawUrl.startsWith("jdbc:mimer:multi1:")) {
            return "mimer";
        } else if (rawUrl.startsWith("jdbc:dm:")) {
            return "";
        } else if (rawUrl.startsWith("jdbc:kingbase:")) {
            return "";
        } else if (rawUrl.startsWith("jdbc:gbase:")) {
            return "";
        } else if (rawUrl.startsWith("jdbc:xugu:")) {
            return "";
        } else if (rawUrl.startsWith("jdbc:log4jdbc:")) {
            return "";
        } else if (rawUrl.startsWith("jdbc:hive:")) {
            return "'{1}'";
        } else if (rawUrl.startsWith("jdbc:hive2:")) {
            return "'{1}'";
        } else if (rawUrl.startsWith("jdbc:phoenix:")) {
            return "'{1}'";
        } else if (rawUrl.startsWith("jdbc:elastic:")) {
            return "'{1}'";
        } else if (rawUrl.startsWith("jdbc:clickhouse:")) {
            return "'{1}'";
        } else {
            return "'{1}'";
        }
    }
}
