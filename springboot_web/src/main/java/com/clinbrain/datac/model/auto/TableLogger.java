package com.clinbrain.datac.model.auto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

public class TableLogger implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String loggerFile;

    private Integer tableId;

    private String sourceBatch;

    private String targetBatch;

    private Date startDate;

    private Date endDate;

    private Date createDate;

    private Integer status;

    @Transient
    private TableConfig tableConfig;

    private static final long serialVersionUID = 1L;

    public TableLogger(Integer id, String loggerFile, Integer tableId, String sourceBatch, String targetBatch, Date startDate, Date endDate, Date createDate, Integer status) {
        this.id = id;
        this.loggerFile = loggerFile;
        this.tableId = tableId;
        this.sourceBatch = sourceBatch;
        this.targetBatch = targetBatch;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createDate = createDate;
        this.status = status;
    }

    public TableLogger() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoggerFile() {
        return loggerFile;
    }

    public void setLoggerFile(String loggerFile) {
        this.loggerFile = loggerFile == null ? null : loggerFile.trim();
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getSourceBatch() {
        return sourceBatch;
    }

    public void setSourceBatch(String sourceBatch) {
        this.sourceBatch = sourceBatch == null ? null : sourceBatch.trim();
    }

    public String getTargetBatch() {
        return targetBatch;
    }

    public void setTargetBatch(String targetBatch) {
        this.targetBatch = targetBatch == null ? null : targetBatch.trim();
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public TableConfig getTableConfig() {
        return tableConfig;
    }

    public void setTableConfig(TableConfig tableConfig) {
        this.tableConfig = tableConfig;
    }
}