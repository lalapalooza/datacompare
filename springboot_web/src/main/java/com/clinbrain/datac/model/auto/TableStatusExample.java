package com.clinbrain.datac.model.auto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * VIEW
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-09-18 17:25:59
 */
public class TableStatusExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TableStatusExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }
				
        public Criteria andTableIdIsNull() {
            addCriterion("tableId is null");
            return (Criteria) this;
        }

        public Criteria andTableIdIsNotNull() {
            addCriterion("tableId is not null");
            return (Criteria) this;
        }

        public Criteria andTableIdEqualTo(Integer value) {
            addCriterion("tableId =", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotEqualTo(Integer value) {
            addCriterion("tableId <>", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdGreaterThan(Integer value) {
            addCriterion("tableId >", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tableId >=", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdLessThan(Integer value) {
            addCriterion("tableId <", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdLessThanOrEqualTo(Integer value) {
            addCriterion("tableId <=", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdLike(Integer value) {
            addCriterion("tableId like", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotLike(Integer value) {
            addCriterion("tableId not like", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdIn(List<Integer> values) {
            addCriterion("tableId in", values, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotIn(List<Integer> values) {
            addCriterion("tableId not in", values, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdBetween(Integer value1, Integer value2) {
            addCriterion("tableId between", value1, value2, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tableId not between", value1, value2, "tableId");
            return (Criteria) this;
        }
        
        		
        public Criteria andTaskNameIsNull() {
            addCriterion("taskName is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("taskName is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("taskName =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("taskName <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("taskName >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("taskName >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("taskName <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("taskName <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("taskName like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("taskName not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("taskName in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("taskName not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("taskName between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("taskName not between", value1, value2, "taskName");
            return (Criteria) this;
        }
        
        		
        public Criteria andSourceCodeIsNull() {
            addCriterion("sourceCode is null");
            return (Criteria) this;
        }

        public Criteria andSourceCodeIsNotNull() {
            addCriterion("sourceCode is not null");
            return (Criteria) this;
        }

        public Criteria andSourceCodeEqualTo(String value) {
            addCriterion("sourceCode =", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeNotEqualTo(String value) {
            addCriterion("sourceCode <>", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeGreaterThan(String value) {
            addCriterion("sourceCode >", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sourceCode >=", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeLessThan(String value) {
            addCriterion("sourceCode <", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeLessThanOrEqualTo(String value) {
            addCriterion("sourceCode <=", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeLike(String value) {
            addCriterion("sourceCode like", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeNotLike(String value) {
            addCriterion("sourceCode not like", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeIn(List<String> values) {
            addCriterion("sourceCode in", values, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeNotIn(List<String> values) {
            addCriterion("sourceCode not in", values, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeBetween(String value1, String value2) {
            addCriterion("sourceCode between", value1, value2, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeNotBetween(String value1, String value2) {
            addCriterion("sourceCode not between", value1, value2, "sourceCode");
            return (Criteria) this;
        }
        
        		
        public Criteria andSourceTableIsNull() {
            addCriterion("sourceTable is null");
            return (Criteria) this;
        }

        public Criteria andSourceTableIsNotNull() {
            addCriterion("sourceTable is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTableEqualTo(String value) {
            addCriterion("sourceTable =", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableNotEqualTo(String value) {
            addCriterion("sourceTable <>", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableGreaterThan(String value) {
            addCriterion("sourceTable >", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableGreaterThanOrEqualTo(String value) {
            addCriterion("sourceTable >=", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableLessThan(String value) {
            addCriterion("sourceTable <", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableLessThanOrEqualTo(String value) {
            addCriterion("sourceTable <=", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableLike(String value) {
            addCriterion("sourceTable like", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableNotLike(String value) {
            addCriterion("sourceTable not like", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableIn(List<String> values) {
            addCriterion("sourceTable in", values, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableNotIn(List<String> values) {
            addCriterion("sourceTable not in", values, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableBetween(String value1, String value2) {
            addCriterion("sourceTable between", value1, value2, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableNotBetween(String value1, String value2) {
            addCriterion("sourceTable not between", value1, value2, "sourceTable");
            return (Criteria) this;
        }
        
        		
        public Criteria andSourceSqlIsNull() {
            addCriterion("sourceSql is null");
            return (Criteria) this;
        }

        public Criteria andSourceSqlIsNotNull() {
            addCriterion("sourceSql is not null");
            return (Criteria) this;
        }

        public Criteria andSourceSqlEqualTo(String value) {
            addCriterion("sourceSql =", value, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlNotEqualTo(String value) {
            addCriterion("sourceSql <>", value, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlGreaterThan(String value) {
            addCriterion("sourceSql >", value, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlGreaterThanOrEqualTo(String value) {
            addCriterion("sourceSql >=", value, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlLessThan(String value) {
            addCriterion("sourceSql <", value, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlLessThanOrEqualTo(String value) {
            addCriterion("sourceSql <=", value, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlLike(String value) {
            addCriterion("sourceSql like", value, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlNotLike(String value) {
            addCriterion("sourceSql not like", value, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlIn(List<String> values) {
            addCriterion("sourceSql in", values, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlNotIn(List<String> values) {
            addCriterion("sourceSql not in", values, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlBetween(String value1, String value2) {
            addCriterion("sourceSql between", value1, value2, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlNotBetween(String value1, String value2) {
            addCriterion("sourceSql not between", value1, value2, "sourceSql");
            return (Criteria) this;
        }
        
        		
        public Criteria andTargetCodeIsNull() {
            addCriterion("targetCode is null");
            return (Criteria) this;
        }

        public Criteria andTargetCodeIsNotNull() {
            addCriterion("targetCode is not null");
            return (Criteria) this;
        }

        public Criteria andTargetCodeEqualTo(String value) {
            addCriterion("targetCode =", value, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeNotEqualTo(String value) {
            addCriterion("targetCode <>", value, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeGreaterThan(String value) {
            addCriterion("targetCode >", value, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeGreaterThanOrEqualTo(String value) {
            addCriterion("targetCode >=", value, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeLessThan(String value) {
            addCriterion("targetCode <", value, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeLessThanOrEqualTo(String value) {
            addCriterion("targetCode <=", value, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeLike(String value) {
            addCriterion("targetCode like", value, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeNotLike(String value) {
            addCriterion("targetCode not like", value, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeIn(List<String> values) {
            addCriterion("targetCode in", values, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeNotIn(List<String> values) {
            addCriterion("targetCode not in", values, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeBetween(String value1, String value2) {
            addCriterion("targetCode between", value1, value2, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeNotBetween(String value1, String value2) {
            addCriterion("targetCode not between", value1, value2, "targetCode");
            return (Criteria) this;
        }
        
        		
        public Criteria andTargetTableIsNull() {
            addCriterion("targetTable is null");
            return (Criteria) this;
        }

        public Criteria andTargetTableIsNotNull() {
            addCriterion("targetTable is not null");
            return (Criteria) this;
        }

        public Criteria andTargetTableEqualTo(String value) {
            addCriterion("targetTable =", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableNotEqualTo(String value) {
            addCriterion("targetTable <>", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableGreaterThan(String value) {
            addCriterion("targetTable >", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableGreaterThanOrEqualTo(String value) {
            addCriterion("targetTable >=", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableLessThan(String value) {
            addCriterion("targetTable <", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableLessThanOrEqualTo(String value) {
            addCriterion("targetTable <=", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableLike(String value) {
            addCriterion("targetTable like", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableNotLike(String value) {
            addCriterion("targetTable not like", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableIn(List<String> values) {
            addCriterion("targetTable in", values, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableNotIn(List<String> values) {
            addCriterion("targetTable not in", values, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableBetween(String value1, String value2) {
            addCriterion("targetTable between", value1, value2, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableNotBetween(String value1, String value2) {
            addCriterion("targetTable not between", value1, value2, "targetTable");
            return (Criteria) this;
        }
        
        		
        public Criteria andTargetSqlIsNull() {
            addCriterion("targetSql is null");
            return (Criteria) this;
        }

        public Criteria andTargetSqlIsNotNull() {
            addCriterion("targetSql is not null");
            return (Criteria) this;
        }

        public Criteria andTargetSqlEqualTo(String value) {
            addCriterion("targetSql =", value, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlNotEqualTo(String value) {
            addCriterion("targetSql <>", value, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlGreaterThan(String value) {
            addCriterion("targetSql >", value, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlGreaterThanOrEqualTo(String value) {
            addCriterion("targetSql >=", value, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlLessThan(String value) {
            addCriterion("targetSql <", value, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlLessThanOrEqualTo(String value) {
            addCriterion("targetSql <=", value, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlLike(String value) {
            addCriterion("targetSql like", value, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlNotLike(String value) {
            addCriterion("targetSql not like", value, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlIn(List<String> values) {
            addCriterion("targetSql in", values, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlNotIn(List<String> values) {
            addCriterion("targetSql not in", values, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlBetween(String value1, String value2) {
            addCriterion("targetSql between", value1, value2, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlNotBetween(String value1, String value2) {
            addCriterion("targetSql not between", value1, value2, "targetSql");
            return (Criteria) this;
        }
        
        		
        public Criteria andRunTypeIsNull() {
            addCriterion("runType is null");
            return (Criteria) this;
        }

        public Criteria andRunTypeIsNotNull() {
            addCriterion("runType is not null");
            return (Criteria) this;
        }

        public Criteria andRunTypeEqualTo(String value) {
            addCriterion("runType =", value, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeNotEqualTo(String value) {
            addCriterion("runType <>", value, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeGreaterThan(String value) {
            addCriterion("runType >", value, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeGreaterThanOrEqualTo(String value) {
            addCriterion("runType >=", value, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeLessThan(String value) {
            addCriterion("runType <", value, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeLessThanOrEqualTo(String value) {
            addCriterion("runType <=", value, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeLike(String value) {
            addCriterion("runType like", value, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeNotLike(String value) {
            addCriterion("runType not like", value, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeIn(List<String> values) {
            addCriterion("runType in", values, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeNotIn(List<String> values) {
            addCriterion("runType not in", values, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeBetween(String value1, String value2) {
            addCriterion("runType between", value1, value2, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeNotBetween(String value1, String value2) {
            addCriterion("runType not between", value1, value2, "runType");
            return (Criteria) this;
        }
        
        		
        public Criteria andJobTypeIsNull() {
            addCriterion("jobType is null");
            return (Criteria) this;
        }

        public Criteria andJobTypeIsNotNull() {
            addCriterion("jobType is not null");
            return (Criteria) this;
        }

        public Criteria andJobTypeEqualTo(String value) {
            addCriterion("jobType =", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotEqualTo(String value) {
            addCriterion("jobType <>", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThan(String value) {
            addCriterion("jobType >", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThanOrEqualTo(String value) {
            addCriterion("jobType >=", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThan(String value) {
            addCriterion("jobType <", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThanOrEqualTo(String value) {
            addCriterion("jobType <=", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLike(String value) {
            addCriterion("jobType like", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotLike(String value) {
            addCriterion("jobType not like", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeIn(List<String> values) {
            addCriterion("jobType in", values, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotIn(List<String> values) {
            addCriterion("jobType not in", values, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeBetween(String value1, String value2) {
            addCriterion("jobType between", value1, value2, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotBetween(String value1, String value2) {
            addCriterion("jobType not between", value1, value2, "jobType");
            return (Criteria) this;
        }
        
        		
        public Criteria andOnlyCountIsNull() {
            addCriterion("onlyCount is null");
            return (Criteria) this;
        }

        public Criteria andOnlyCountIsNotNull() {
            addCriterion("onlyCount is not null");
            return (Criteria) this;
        }

        public Criteria andOnlyCountEqualTo(String value) {
            addCriterion("onlyCount =", value, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountNotEqualTo(String value) {
            addCriterion("onlyCount <>", value, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountGreaterThan(String value) {
            addCriterion("onlyCount >", value, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountGreaterThanOrEqualTo(String value) {
            addCriterion("onlyCount >=", value, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountLessThan(String value) {
            addCriterion("onlyCount <", value, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountLessThanOrEqualTo(String value) {
            addCriterion("onlyCount <=", value, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountLike(String value) {
            addCriterion("onlyCount like", value, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountNotLike(String value) {
            addCriterion("onlyCount not like", value, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountIn(List<String> values) {
            addCriterion("onlyCount in", values, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountNotIn(List<String> values) {
            addCriterion("onlyCount not in", values, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountBetween(String value1, String value2) {
            addCriterion("onlyCount between", value1, value2, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountNotBetween(String value1, String value2) {
            addCriterion("onlyCount not between", value1, value2, "onlyCount");
            return (Criteria) this;
        }
        
        		
        public Criteria andRangeIsNull() {
            addCriterion("range is null");
            return (Criteria) this;
        }

        public Criteria andRangeIsNotNull() {
            addCriterion("range is not null");
            return (Criteria) this;
        }

        public Criteria andRangeEqualTo(Integer value) {
            addCriterion("range =", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeNotEqualTo(Integer value) {
            addCriterion("range <>", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeGreaterThan(Integer value) {
            addCriterion("range >", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("range >=", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeLessThan(Integer value) {
            addCriterion("range <", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeLessThanOrEqualTo(Integer value) {
            addCriterion("range <=", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeLike(Integer value) {
            addCriterion("range like", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeNotLike(Integer value) {
            addCriterion("range not like", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeIn(List<Integer> values) {
            addCriterion("range in", values, "range");
            return (Criteria) this;
        }

        public Criteria andRangeNotIn(List<Integer> values) {
            addCriterion("range not in", values, "range");
            return (Criteria) this;
        }

        public Criteria andRangeBetween(Integer value1, Integer value2) {
            addCriterion("range between", value1, value2, "range");
            return (Criteria) this;
        }

        public Criteria andRangeNotBetween(Integer value1, Integer value2) {
            addCriterion("range not between", value1, value2, "range");
            return (Criteria) this;
        }
        
        		
        public Criteria andEndCheckIsNull() {
            addCriterion("endCheck is null");
            return (Criteria) this;
        }

        public Criteria andEndCheckIsNotNull() {
            addCriterion("endCheck is not null");
            return (Criteria) this;
        }

        public Criteria andEndCheckEqualTo(Integer value) {
            addCriterion("endCheck =", value, "endCheck");
            return (Criteria) this;
        }

        public Criteria andEndCheckNotEqualTo(Integer value) {
            addCriterion("endCheck <>", value, "endCheck");
            return (Criteria) this;
        }

        public Criteria andEndCheckGreaterThan(Integer value) {
            addCriterion("endCheck >", value, "endCheck");
            return (Criteria) this;
        }

        public Criteria andEndCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("endCheck >=", value, "endCheck");
            return (Criteria) this;
        }

        public Criteria andEndCheckLessThan(Integer value) {
            addCriterion("endCheck <", value, "endCheck");
            return (Criteria) this;
        }

        public Criteria andEndCheckLessThanOrEqualTo(Integer value) {
            addCriterion("endCheck <=", value, "endCheck");
            return (Criteria) this;
        }

        public Criteria andEndCheckLike(Integer value) {
            addCriterion("endCheck like", value, "endCheck");
            return (Criteria) this;
        }

        public Criteria andEndCheckNotLike(Integer value) {
            addCriterion("endCheck not like", value, "endCheck");
            return (Criteria) this;
        }

        public Criteria andEndCheckIn(List<Integer> values) {
            addCriterion("endCheck in", values, "endCheck");
            return (Criteria) this;
        }

        public Criteria andEndCheckNotIn(List<Integer> values) {
            addCriterion("endCheck not in", values, "endCheck");
            return (Criteria) this;
        }

        public Criteria andEndCheckBetween(Integer value1, Integer value2) {
            addCriterion("endCheck between", value1, value2, "endCheck");
            return (Criteria) this;
        }

        public Criteria andEndCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("endCheck not between", value1, value2, "endCheck");
            return (Criteria) this;
        }
        
        		
        public Criteria andEnableIsNull() {
            addCriterion("enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Integer value) {
            addCriterion("enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Integer value) {
            addCriterion("enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Integer value) {
            addCriterion("enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Integer value) {
            addCriterion("enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Integer value) {
            addCriterion("enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLike(Integer value) {
            addCriterion("enable like", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotLike(Integer value) {
            addCriterion("enable not like", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Integer> values) {
            addCriterion("enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Integer> values) {
            addCriterion("enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Integer value1, Integer value2) {
            addCriterion("enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("enable not between", value1, value2, "enable");
            return (Criteria) this;
        }
        
        		
        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(Integer value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(Integer value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        
        		
        public Criteria andLoggerFileIsNull() {
            addCriterion("loggerFile is null");
            return (Criteria) this;
        }

        public Criteria andLoggerFileIsNotNull() {
            addCriterion("loggerFile is not null");
            return (Criteria) this;
        }

        public Criteria andLoggerFileEqualTo(String value) {
            addCriterion("loggerFile =", value, "loggerFile");
            return (Criteria) this;
        }

        public Criteria andLoggerFileNotEqualTo(String value) {
            addCriterion("loggerFile <>", value, "loggerFile");
            return (Criteria) this;
        }

        public Criteria andLoggerFileGreaterThan(String value) {
            addCriterion("loggerFile >", value, "loggerFile");
            return (Criteria) this;
        }

        public Criteria andLoggerFileGreaterThanOrEqualTo(String value) {
            addCriterion("loggerFile >=", value, "loggerFile");
            return (Criteria) this;
        }

        public Criteria andLoggerFileLessThan(String value) {
            addCriterion("loggerFile <", value, "loggerFile");
            return (Criteria) this;
        }

        public Criteria andLoggerFileLessThanOrEqualTo(String value) {
            addCriterion("loggerFile <=", value, "loggerFile");
            return (Criteria) this;
        }

        public Criteria andLoggerFileLike(String value) {
            addCriterion("loggerFile like", value, "loggerFile");
            return (Criteria) this;
        }

        public Criteria andLoggerFileNotLike(String value) {
            addCriterion("loggerFile not like", value, "loggerFile");
            return (Criteria) this;
        }

        public Criteria andLoggerFileIn(List<String> values) {
            addCriterion("loggerFile in", values, "loggerFile");
            return (Criteria) this;
        }

        public Criteria andLoggerFileNotIn(List<String> values) {
            addCriterion("loggerFile not in", values, "loggerFile");
            return (Criteria) this;
        }

        public Criteria andLoggerFileBetween(String value1, String value2) {
            addCriterion("loggerFile between", value1, value2, "loggerFile");
            return (Criteria) this;
        }

        public Criteria andLoggerFileNotBetween(String value1, String value2) {
            addCriterion("loggerFile not between", value1, value2, "loggerFile");
            return (Criteria) this;
        }
        
        		
        public Criteria andSourceDataIsNull() {
            addCriterion("sourceData is null");
            return (Criteria) this;
        }

        public Criteria andSourceDataIsNotNull() {
            addCriterion("sourceData is not null");
            return (Criteria) this;
        }

        public Criteria andSourceDataEqualTo(String value) {
            addCriterion("sourceData =", value, "sourceData");
            return (Criteria) this;
        }

        public Criteria andSourceDataNotEqualTo(String value) {
            addCriterion("sourceData <>", value, "sourceData");
            return (Criteria) this;
        }

        public Criteria andSourceDataGreaterThan(String value) {
            addCriterion("sourceData >", value, "sourceData");
            return (Criteria) this;
        }

        public Criteria andSourceDataGreaterThanOrEqualTo(String value) {
            addCriterion("sourceData >=", value, "sourceData");
            return (Criteria) this;
        }

        public Criteria andSourceDataLessThan(String value) {
            addCriterion("sourceData <", value, "sourceData");
            return (Criteria) this;
        }

        public Criteria andSourceDataLessThanOrEqualTo(String value) {
            addCriterion("sourceData <=", value, "sourceData");
            return (Criteria) this;
        }

        public Criteria andSourceDataLike(String value) {
            addCriterion("sourceData like", value, "sourceData");
            return (Criteria) this;
        }

        public Criteria andSourceDataNotLike(String value) {
            addCriterion("sourceData not like", value, "sourceData");
            return (Criteria) this;
        }

        public Criteria andSourceDataIn(List<String> values) {
            addCriterion("sourceData in", values, "sourceData");
            return (Criteria) this;
        }

        public Criteria andSourceDataNotIn(List<String> values) {
            addCriterion("sourceData not in", values, "sourceData");
            return (Criteria) this;
        }

        public Criteria andSourceDataBetween(String value1, String value2) {
            addCriterion("sourceData between", value1, value2, "sourceData");
            return (Criteria) this;
        }

        public Criteria andSourceDataNotBetween(String value1, String value2) {
            addCriterion("sourceData not between", value1, value2, "sourceData");
            return (Criteria) this;
        }
        
        		
        public Criteria andTargetDataIsNull() {
            addCriterion("targetData is null");
            return (Criteria) this;
        }

        public Criteria andTargetDataIsNotNull() {
            addCriterion("targetData is not null");
            return (Criteria) this;
        }

        public Criteria andTargetDataEqualTo(String value) {
            addCriterion("targetData =", value, "targetData");
            return (Criteria) this;
        }

        public Criteria andTargetDataNotEqualTo(String value) {
            addCriterion("targetData <>", value, "targetData");
            return (Criteria) this;
        }

        public Criteria andTargetDataGreaterThan(String value) {
            addCriterion("targetData >", value, "targetData");
            return (Criteria) this;
        }

        public Criteria andTargetDataGreaterThanOrEqualTo(String value) {
            addCriterion("targetData >=", value, "targetData");
            return (Criteria) this;
        }

        public Criteria andTargetDataLessThan(String value) {
            addCriterion("targetData <", value, "targetData");
            return (Criteria) this;
        }

        public Criteria andTargetDataLessThanOrEqualTo(String value) {
            addCriterion("targetData <=", value, "targetData");
            return (Criteria) this;
        }

        public Criteria andTargetDataLike(String value) {
            addCriterion("targetData like", value, "targetData");
            return (Criteria) this;
        }

        public Criteria andTargetDataNotLike(String value) {
            addCriterion("targetData not like", value, "targetData");
            return (Criteria) this;
        }

        public Criteria andTargetDataIn(List<String> values) {
            addCriterion("targetData in", values, "targetData");
            return (Criteria) this;
        }

        public Criteria andTargetDataNotIn(List<String> values) {
            addCriterion("targetData not in", values, "targetData");
            return (Criteria) this;
        }

        public Criteria andTargetDataBetween(String value1, String value2) {
            addCriterion("targetData between", value1, value2, "targetData");
            return (Criteria) this;
        }

        public Criteria andTargetDataNotBetween(String value1, String value2) {
            addCriterion("targetData not between", value1, value2, "targetData");
            return (Criteria) this;
        }
        
        		
        public Criteria andSourceBatchIsNull() {
            addCriterion("sourceBatch is null");
            return (Criteria) this;
        }

        public Criteria andSourceBatchIsNotNull() {
            addCriterion("sourceBatch is not null");
            return (Criteria) this;
        }

        public Criteria andSourceBatchEqualTo(String value) {
            addCriterion("sourceBatch =", value, "sourceBatch");
            return (Criteria) this;
        }

        public Criteria andSourceBatchNotEqualTo(String value) {
            addCriterion("sourceBatch <>", value, "sourceBatch");
            return (Criteria) this;
        }

        public Criteria andSourceBatchGreaterThan(String value) {
            addCriterion("sourceBatch >", value, "sourceBatch");
            return (Criteria) this;
        }

        public Criteria andSourceBatchGreaterThanOrEqualTo(String value) {
            addCriterion("sourceBatch >=", value, "sourceBatch");
            return (Criteria) this;
        }

        public Criteria andSourceBatchLessThan(String value) {
            addCriterion("sourceBatch <", value, "sourceBatch");
            return (Criteria) this;
        }

        public Criteria andSourceBatchLessThanOrEqualTo(String value) {
            addCriterion("sourceBatch <=", value, "sourceBatch");
            return (Criteria) this;
        }

        public Criteria andSourceBatchLike(String value) {
            addCriterion("sourceBatch like", value, "sourceBatch");
            return (Criteria) this;
        }

        public Criteria andSourceBatchNotLike(String value) {
            addCriterion("sourceBatch not like", value, "sourceBatch");
            return (Criteria) this;
        }

        public Criteria andSourceBatchIn(List<String> values) {
            addCriterion("sourceBatch in", values, "sourceBatch");
            return (Criteria) this;
        }

        public Criteria andSourceBatchNotIn(List<String> values) {
            addCriterion("sourceBatch not in", values, "sourceBatch");
            return (Criteria) this;
        }

        public Criteria andSourceBatchBetween(String value1, String value2) {
            addCriterion("sourceBatch between", value1, value2, "sourceBatch");
            return (Criteria) this;
        }

        public Criteria andSourceBatchNotBetween(String value1, String value2) {
            addCriterion("sourceBatch not between", value1, value2, "sourceBatch");
            return (Criteria) this;
        }
        
        		
        public Criteria andTargetBatchIsNull() {
            addCriterion("targetBatch is null");
            return (Criteria) this;
        }

        public Criteria andTargetBatchIsNotNull() {
            addCriterion("targetBatch is not null");
            return (Criteria) this;
        }

        public Criteria andTargetBatchEqualTo(String value) {
            addCriterion("targetBatch =", value, "targetBatch");
            return (Criteria) this;
        }

        public Criteria andTargetBatchNotEqualTo(String value) {
            addCriterion("targetBatch <>", value, "targetBatch");
            return (Criteria) this;
        }

        public Criteria andTargetBatchGreaterThan(String value) {
            addCriterion("targetBatch >", value, "targetBatch");
            return (Criteria) this;
        }

        public Criteria andTargetBatchGreaterThanOrEqualTo(String value) {
            addCriterion("targetBatch >=", value, "targetBatch");
            return (Criteria) this;
        }

        public Criteria andTargetBatchLessThan(String value) {
            addCriterion("targetBatch <", value, "targetBatch");
            return (Criteria) this;
        }

        public Criteria andTargetBatchLessThanOrEqualTo(String value) {
            addCriterion("targetBatch <=", value, "targetBatch");
            return (Criteria) this;
        }

        public Criteria andTargetBatchLike(String value) {
            addCriterion("targetBatch like", value, "targetBatch");
            return (Criteria) this;
        }

        public Criteria andTargetBatchNotLike(String value) {
            addCriterion("targetBatch not like", value, "targetBatch");
            return (Criteria) this;
        }

        public Criteria andTargetBatchIn(List<String> values) {
            addCriterion("targetBatch in", values, "targetBatch");
            return (Criteria) this;
        }

        public Criteria andTargetBatchNotIn(List<String> values) {
            addCriterion("targetBatch not in", values, "targetBatch");
            return (Criteria) this;
        }

        public Criteria andTargetBatchBetween(String value1, String value2) {
            addCriterion("targetBatch between", value1, value2, "targetBatch");
            return (Criteria) this;
        }

        public Criteria andTargetBatchNotBetween(String value1, String value2) {
            addCriterion("targetBatch not between", value1, value2, "targetBatch");
            return (Criteria) this;
        }
        
        		
        public Criteria andStartDateIsNull() {
            addCriterion("startDate is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("startDate is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("startDate =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("startDate <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("startDate >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("startDate >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("startDate <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("startDate <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLike(Date value) {
            addCriterion("startDate like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotLike(Date value) {
            addCriterion("startDate not like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("startDate in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("startDate not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("startDate between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("startDate not between", value1, value2, "startDate");
            return (Criteria) this;
        }
        
        		
        public Criteria andEndDateIsNull() {
            addCriterion("endDate is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("endDate is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("endDate =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("endDate <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("endDate >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("endDate >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("endDate <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("endDate <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLike(Date value) {
            addCriterion("endDate like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotLike(Date value) {
            addCriterion("endDate not like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("endDate in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("endDate not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("endDate between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("endDate not between", value1, value2, "endDate");
            return (Criteria) this;
        }
        
        		
        public Criteria andCreateDateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("createDate =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("createDate <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("createDate >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("createDate >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("createDate <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("createDate <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLike(Date value) {
            addCriterion("createDate like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotLike(Date value) {
            addCriterion("createDate not like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("createDate in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("createDate not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("createDate between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("createDate not between", value1, value2, "createDate");
            return (Criteria) this;
        }
        
        		
        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(Integer value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(Integer value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
        
        		
        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }
        
                
       
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        public Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        public Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        public Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        public Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        public Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}