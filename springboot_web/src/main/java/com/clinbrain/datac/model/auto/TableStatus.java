package com.clinbrain.datac.model.auto;

import com.clinbrain.datac.common.domain.BaseObject;

import java.util.Date;

/**
 * VIEW
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-09-18 17:25:59
 */
public class TableStatus extends BaseObject {


		
	/**
	 * 
	 */
        	private Integer tableId;
		
	/**
	 * 
	 */
        	private String taskName;
		
	/**
	 * 源数据源
	 */
        	private String sourceCode;
		
	/**
	 * 
	 */
        	private String sourceTable;
		
	/**
	 * 
	 */
        	private String sourceSql;
		
	/**
	 * 目标数据源
	 */
        	private String targetCode;
		
	/**
	 * 
	 */
        	private String targetTable;
		
	/**
	 * 
	 */
        	private String targetSql;
		
	/**
	 * 增量 / 全量 0:增量，有时间列会增加时间列条件:2:全量，1：区间
	 */
        	private String runType;
		
	/**
	 * 任务类型， oralce->hive, hive->gp
	 */
        	private String jobType;
		
	/**
	 * 只统计数据量/ 比对列值 1：只要count值 2:需要比对列值
	 */
        	private String onlyCount;
		
	/**
	 * 统计的时间范围，用当前时间减去这个值的时间作为开始时间
	 */
        	private Integer range;
		
	/**
	 * 结束时间的间隔
	 */
        	private Integer endCheck;
		
	/**
	 * 是否可用
	 */
        	private Integer enable;
		
	/**
	 * 
	 */
        	private Integer id;
		
	/**
	 * 
	 */
        	private String loggerFile;
		
	/**
	 * 
	 */
        	private String sourceData;
		
	/**
	 * 
	 */
        	private String targetData;
		
	/**
	 * 
	 */
        	private String sourceBatch;
		
	/**
	 * 
	 */
        	private String targetBatch;
		
	/**
	 * 
	 */
        	private Date startDate;
		
	/**
	 * 
	 */
        	private Date endDate;
		
	/**
	 * 
	 */
        	private Date createDate;
		
	/**
	 * 状态字段： 0  成功， -1 失败
	 */
        	private Integer status;
		
	/**
	 * 其他信息
	 */
        	private String message;
	
	
		
		public Integer getTableId () {
	        return tableId;
	    }
	
	    public void setTableId (Integer tableId) {
	        this.tableId = tableId;
	    }
	 
				
		public String getTaskName() {
	        return taskName;
	    }
	
	    public void setTaskName(String taskName){
	        this.taskName = taskName == null ? null : taskName.trim();
	    }
			
				
		public String getSourceCode() {
	        return sourceCode;
	    }
	
	    public void setSourceCode(String sourceCode){
	        this.sourceCode = sourceCode == null ? null : sourceCode.trim();
	    }
			
				
		public String getSourceTable() {
	        return sourceTable;
	    }
	
	    public void setSourceTable(String sourceTable){
	        this.sourceTable = sourceTable == null ? null : sourceTable.trim();
	    }
			
				
		public String getSourceSql() {
	        return sourceSql;
	    }
	
	    public void setSourceSql(String sourceSql){
	        this.sourceSql = sourceSql == null ? null : sourceSql.trim();
	    }
			
				
		public String getTargetCode() {
	        return targetCode;
	    }
	
	    public void setTargetCode(String targetCode){
	        this.targetCode = targetCode == null ? null : targetCode.trim();
	    }
			
				
		public String getTargetTable() {
	        return targetTable;
	    }
	
	    public void setTargetTable(String targetTable){
	        this.targetTable = targetTable == null ? null : targetTable.trim();
	    }
			
				
		public String getTargetSql() {
	        return targetSql;
	    }
	
	    public void setTargetSql(String targetSql){
	        this.targetSql = targetSql == null ? null : targetSql.trim();
	    }
			
				
		public String getRunType() {
	        return runType;
	    }
	
	    public void setRunType(String runType){
	        this.runType = runType == null ? null : runType.trim();
	    }
			
				
		public String getJobType() {
	        return jobType;
	    }
	
	    public void setJobType(String jobType){
	        this.jobType = jobType == null ? null : jobType.trim();
	    }
			
				
		public String getOnlyCount() {
	        return onlyCount;
	    }
	
	    public void setOnlyCount(String onlyCount){
	        this.onlyCount = onlyCount == null ? null : onlyCount.trim();
	    }
			
			
		public Integer getRange () {
	        return range;
	    }
	
	    public void setRange (Integer range) {
	        this.range = range;
	    }
	 
			
		public Integer getEndCheck () {
	        return endCheck;
	    }
	
	    public void setEndCheck (Integer endCheck) {
	        this.endCheck = endCheck;
	    }
	 
			
		public Integer getEnable () {
	        return enable;
	    }
	
	    public void setEnable (Integer enable) {
	        this.enable = enable;
	    }
	 
			
		public Integer getId () {
	        return id;
	    }
	
	    public void setId (Integer id) {
	        this.id = id;
	    }
	 
				
		public String getLoggerFile() {
	        return loggerFile;
	    }
	
	    public void setLoggerFile(String loggerFile){
	        this.loggerFile = loggerFile == null ? null : loggerFile.trim();
	    }
			
				
		public String getSourceData() {
	        return sourceData;
	    }
	
	    public void setSourceData(String sourceData){
	        this.sourceData = sourceData == null ? null : sourceData.trim();
	    }
			
				
		public String getTargetData() {
	        return targetData;
	    }
	
	    public void setTargetData(String targetData){
	        this.targetData = targetData == null ? null : targetData.trim();
	    }
			
				
		public String getSourceBatch() {
	        return sourceBatch;
	    }
	
	    public void setSourceBatch(String sourceBatch){
	        this.sourceBatch = sourceBatch == null ? null : sourceBatch.trim();
	    }
			
				
		public String getTargetBatch() {
	        return targetBatch;
	    }
	
	    public void setTargetBatch(String targetBatch){
	        this.targetBatch = targetBatch == null ? null : targetBatch.trim();
	    }
			
			
		public Date getStartDate () {
	        return startDate;
	    }
	
	    public void setStartDate (Date startDate) {
	        this.startDate = startDate;
	    }
	 
			
		public Date getEndDate () {
	        return endDate;
	    }
	
	    public void setEndDate (Date endDate) {
	        this.endDate = endDate;
	    }
	 
			
		public Date getCreateDate () {
	        return createDate;
	    }
	
	    public void setCreateDate (Date createDate) {
	        this.createDate = createDate;
	    }
	 
			
		public Integer getStatus () {
	        return status;
	    }
	
	    public void setStatus (Integer status) {
	        this.status = status;
	    }
	 
				
		public String getMessage() {
	        return message;
	    }
	
	    public void setMessage(String message){
	        this.message = message == null ? null : message.trim();
	    }
			
			
}