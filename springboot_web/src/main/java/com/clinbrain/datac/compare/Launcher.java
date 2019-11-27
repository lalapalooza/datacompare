package com.clinbrain.datac.compare;

import com.clinbrain.datac.model.auto.TableConfig;
import com.clinbrain.datac.util.SpringContextUtils;
import com.clinbrain.datac.model.custom.EtlHistablePartitionsConfiguration;
import com.clinbrain.datac.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by Liaopan on 2019/7/4.
 */
public class Launcher {

    private static final Logger LOG = LoggerFactory.getLogger(Launcher.class);
    /**
     * 任务运行的并行个数
     */
    private static final ThreadPoolTaskExecutor taskPools = SpringContextUtils.getBean("taskComparePool");

    /**
     * 任务table
     */
    private List<TableConfig> tables;

    private List<EtlHistablePartitionsConfiguration> epConfig;

    public void initialize(int poolSize, List<TableConfig> tables) {
        this.tables = tables;
    }

    public void setHisTablePartitionConfig(List<EtlHistablePartitionsConfiguration> list) {
        this.epConfig = list;
    }

    public TableConfig doConfigTable(TableConfig table) {
        String sourceTable = table.getSourceTable();
        if(StringUtils.isNotEmpty(sourceTable)) {
            String tableName = "";
            String schema = "";
            if (sourceTable.contains(".")) {
                tableName = StringUtils.substringAfter(sourceTable, ".");
                schema = StringUtils.substringBefore(sourceTable, ".");
            }
            final String schemaFinal = schema;
            final String tableNameFinal = tableName;
            String timeColumn = epConfig.stream().filter(ep -> schemaFinal.equalsIgnoreCase(ep.getHisDbName())
                    && tableNameFinal.equalsIgnoreCase(ep.getHisTbName())).findFirst()
                    .map(EtlHistablePartitionsConfiguration::getHisTbPartitionColumnName).orElse("");
            table.setPartitionColumn(timeColumn);
        }
        // 增加全量/增量/区间的判断
        /**
         * 默认有时间列的情况
         * 增量： 开始时间是 当前时间-(range), 结束时间 =  （当前时间） （单位：天）
         * 全量： 开始时间 = 1900-01-01 (默认写死) 结束时间 = （当前时间-1） （单位：天）
         * 区间： 根据设置的时间来
         */
        LocalDate localDate = LocalDate.now();
        if (JobConstants.RunType.ALL.getCode().toString().equalsIgnoreCase(table.getRunType())) {
            localDate = LocalDate.of(1900, 1, 1);
            table.setStartDate(Date.from(localDate.atStartOfDay().atZone(ZoneId.of("Z")).toInstant()));
            table.setEndDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        } else if (JobConstants.RunType.INCR.getCode().toString().equalsIgnoreCase(table.getRunType())) {
            int range = Optional.ofNullable(table.getRange()).orElse(3);
            int endCheck = Optional.ofNullable(table.getEndCheck()).orElse(0);
            table.setStartDate(Date.from(localDate.minusDays(range)
                    .atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            table.setEndDate(Date.from(localDate.atStartOfDay().minusDays(endCheck).atZone(ZoneId.systemDefault()).toInstant()));
        }
        return table;
    }

    public void doTheTask() {
        LOG.debug("共加载表个数：" + tables.size() + ",开始时间：" + LocalDateTime.now());
        for (TableConfig table : tables) {
            doConfigTable(table);
            taskPools.submit(new CompareTask(table));
        }
    }
}
