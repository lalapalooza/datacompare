package com.clinbrain.datac.model.auto;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

public class TableLoggerWithBLOBs extends TableLogger implements Serializable {

    private String message;

    private String sourceData;

    private String targetData;

    @Transient
    private TableConfig tableConfig;

    private static final long serialVersionUID = 1L;

    public TableLoggerWithBLOBs(Integer id, String loggerFile, Integer tableId, String sourceBatch, String targetBatch, Date startDate, Date endDate, Date createDate, Integer status, String message, String sourceData, String targetData) {
        super(id, loggerFile, tableId, sourceBatch, targetBatch, startDate, endDate, createDate, status);
        this.message = message;
        this.sourceData = sourceData;
        this.targetData = targetData;
    }

    public TableLoggerWithBLOBs() {
        super();
    }

    public String getSourceData() {
        return sourceData;
    }

    public void setSourceData(String sourceData) {
        this.sourceData = sourceData == null ? null : sourceData.trim();
    }

    public String getTargetData() {
        return targetData;
    }

    public void setTargetData(String targetData) {
        this.targetData = targetData == null ? null : targetData.trim();
    }

    public TableConfig getTableConfig() {
        return tableConfig;
    }

    public void setTableConfig(TableConfig tableConfig) {
        this.tableConfig = tableConfig;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}