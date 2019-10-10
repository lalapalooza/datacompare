package com.clinbrain.datac.model.auto;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

public class TableConfig implements Serializable {
    private Integer id;

    private String taskName;

    private String sourceCode;

    private String sourceTable;

    private String sourceSql;

    private String targetCode;

    private String targetTable;

    private String targetSql;

    private Date startDate;

    private Date endDate;

    private String runType;

    private String jobType;

    private String onlyCount;

    private Integer range;

    private Integer enable;

    private Integer endCheck;

    @Transient
    private TConnection sourceConfig;

    @Transient
    private TConnection targetConfig;

    @Transient
    private String partitionColumn;

    private static final long serialVersionUID = 1L;

    public TableConfig(Integer id,String taskName,String sourceCode, String sourceTable, String sourceSql,
                       String targetCode, String targetTable, String targetSql, Date startDate, Date endDate,
                       String runType, String jobType, String onlyCount, Integer range, Integer endCheck, Integer enable) {
        this.id = id;
        this.taskName = taskName;
        this.sourceCode = sourceCode;
        this.sourceTable = sourceTable;
        this.sourceSql = sourceSql;
        this.targetCode = targetCode;
        this.targetTable = targetTable;
        this.targetSql = targetSql;
        this.startDate = startDate;
        this.endDate = endDate;
        this.runType = runType;
        this.jobType = jobType;
        this.onlyCount = onlyCount;
        this.range = range;
        this.endCheck = endCheck;
        this.enable = enable;
    }

    public TableConfig() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode == null ? null : sourceCode.trim();
    }

    public String getSourceTable() {
        return sourceTable;
    }

    public void setSourceTable(String sourceTable) {
        this.sourceTable = sourceTable == null ? null : sourceTable.trim();
    }

    public String getSourceSql() {
        return sourceSql;
    }

    public void setSourceSql(String sourceSql) {
        this.sourceSql = sourceSql == null ? null : sourceSql.trim();
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode == null ? null : targetCode.trim();
    }

    public String getTargetTable() {
        return targetTable;
    }

    public void setTargetTable(String targetTable) {
        this.targetTable = targetTable == null ? null : targetTable.trim();
    }

    public String getTargetSql() {
        return targetSql;
    }

    public void setTargetSql(String targetSql) {
        this.targetSql = targetSql == null ? null : targetSql.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRunType() {
        return runType;
    }

    public void setRunType(String runType) {
        this.runType = runType == null ? null : runType.trim();
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType == null ? null : jobType.trim();
    }

    public String getOnlyCount() {
        return onlyCount;
    }

    public void setOnlyCount(String onlyCount) {
        this.onlyCount = onlyCount == null ? null : onlyCount.trim();
    }

    public TConnection getSourceConfig() {
        return sourceConfig;
    }

    public void setSourceConfig(TConnection sourceConfig) {
        this.sourceConfig = sourceConfig;
    }

    public TConnection getTargetConfig() {
        return targetConfig;
    }

    public void setTargetConfig(TConnection targetConfig) {
        this.targetConfig = targetConfig;
    }

    public String getPartitionColumn() {
        return partitionColumn;
    }

    public void setPartitionColumn(String partitionColumn) {
        this.partitionColumn = partitionColumn;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getEndCheck() {
        return endCheck;
    }

    public void setEndCheck(Integer endCheck) {
        this.endCheck = endCheck;
    }
}