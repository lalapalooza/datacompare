package com.clinbrain.datac.model.auto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-07-29 13:47:58
 */
public class TableConfigExample {

    protected String orderByClause;

    protected Integer jobType;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TableConfigExample() {
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

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
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

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
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
        
        		
        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }
        
        		
        public Criteria andSourceCodeIsNull() {
            addCriterion("source_code is null");
            return (Criteria) this;
        }

        public Criteria andSourceCodeIsNotNull() {
            addCriterion("source_code is not null");
            return (Criteria) this;
        }

        public Criteria andSourceCodeEqualTo(String value) {
            addCriterion("source_code =", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeNotEqualTo(String value) {
            addCriterion("source_code <>", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeGreaterThan(String value) {
            addCriterion("source_code >", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("source_code >=", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeLessThan(String value) {
            addCriterion("source_code <", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeLessThanOrEqualTo(String value) {
            addCriterion("source_code <=", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeLike(String value) {
            addCriterion("source_code like", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeNotLike(String value) {
            addCriterion("source_code not like", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeIn(List<String> values) {
            addCriterion("source_code in", values, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeNotIn(List<String> values) {
            addCriterion("source_code not in", values, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeBetween(String value1, String value2) {
            addCriterion("source_code between", value1, value2, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeNotBetween(String value1, String value2) {
            addCriterion("source_code not between", value1, value2, "sourceCode");
            return (Criteria) this;
        }
        
        		
        public Criteria andSourceTableIsNull() {
            addCriterion("source_table is null");
            return (Criteria) this;
        }

        public Criteria andSourceTableIsNotNull() {
            addCriterion("source_table is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTableEqualTo(String value) {
            addCriterion("source_table =", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableNotEqualTo(String value) {
            addCriterion("source_table <>", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableGreaterThan(String value) {
            addCriterion("source_table >", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableGreaterThanOrEqualTo(String value) {
            addCriterion("source_table >=", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableLessThan(String value) {
            addCriterion("source_table <", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableLessThanOrEqualTo(String value) {
            addCriterion("source_table <=", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableLike(String value) {
            addCriterion("source_table like", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableNotLike(String value) {
            addCriterion("source_table not like", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableIn(List<String> values) {
            addCriterion("source_table in", values, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableNotIn(List<String> values) {
            addCriterion("source_table not in", values, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableBetween(String value1, String value2) {
            addCriterion("source_table between", value1, value2, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableNotBetween(String value1, String value2) {
            addCriterion("source_table not between", value1, value2, "sourceTable");
            return (Criteria) this;
        }
        
        		
        public Criteria andSourceSqlIsNull() {
            addCriterion("source_sql is null");
            return (Criteria) this;
        }

        public Criteria andSourceSqlIsNotNull() {
            addCriterion("source_sql is not null");
            return (Criteria) this;
        }

        public Criteria andSourceSqlEqualTo(String value) {
            addCriterion("source_sql =", value, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlNotEqualTo(String value) {
            addCriterion("source_sql <>", value, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlGreaterThan(String value) {
            addCriterion("source_sql >", value, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlGreaterThanOrEqualTo(String value) {
            addCriterion("source_sql >=", value, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlLessThan(String value) {
            addCriterion("source_sql <", value, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlLessThanOrEqualTo(String value) {
            addCriterion("source_sql <=", value, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlLike(String value) {
            addCriterion("source_sql like", value, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlNotLike(String value) {
            addCriterion("source_sql not like", value, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlIn(List<String> values) {
            addCriterion("source_sql in", values, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlNotIn(List<String> values) {
            addCriterion("source_sql not in", values, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlBetween(String value1, String value2) {
            addCriterion("source_sql between", value1, value2, "sourceSql");
            return (Criteria) this;
        }

        public Criteria andSourceSqlNotBetween(String value1, String value2) {
            addCriterion("source_sql not between", value1, value2, "sourceSql");
            return (Criteria) this;
        }
        
        		
        public Criteria andTargetCodeIsNull() {
            addCriterion("target_code is null");
            return (Criteria) this;
        }

        public Criteria andTargetCodeIsNotNull() {
            addCriterion("target_code is not null");
            return (Criteria) this;
        }

        public Criteria andTargetCodeEqualTo(String value) {
            addCriterion("target_code =", value, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeNotEqualTo(String value) {
            addCriterion("target_code <>", value, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeGreaterThan(String value) {
            addCriterion("target_code >", value, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeGreaterThanOrEqualTo(String value) {
            addCriterion("target_code >=", value, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeLessThan(String value) {
            addCriterion("target_code <", value, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeLessThanOrEqualTo(String value) {
            addCriterion("target_code <=", value, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeLike(String value) {
            addCriterion("target_code like", value, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeNotLike(String value) {
            addCriterion("target_code not like", value, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeIn(List<String> values) {
            addCriterion("target_code in", values, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeNotIn(List<String> values) {
            addCriterion("target_code not in", values, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeBetween(String value1, String value2) {
            addCriterion("target_code between", value1, value2, "targetCode");
            return (Criteria) this;
        }

        public Criteria andTargetCodeNotBetween(String value1, String value2) {
            addCriterion("target_code not between", value1, value2, "targetCode");
            return (Criteria) this;
        }
        
        		
        public Criteria andTargetTableIsNull() {
            addCriterion("target_table is null");
            return (Criteria) this;
        }

        public Criteria andTargetTableIsNotNull() {
            addCriterion("target_table is not null");
            return (Criteria) this;
        }

        public Criteria andTargetTableEqualTo(String value) {
            addCriterion("target_table =", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableNotEqualTo(String value) {
            addCriterion("target_table <>", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableGreaterThan(String value) {
            addCriterion("target_table >", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableGreaterThanOrEqualTo(String value) {
            addCriterion("target_table >=", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableLessThan(String value) {
            addCriterion("target_table <", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableLessThanOrEqualTo(String value) {
            addCriterion("target_table <=", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableLike(String value) {
            addCriterion("target_table like", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableNotLike(String value) {
            addCriterion("target_table not like", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableIn(List<String> values) {
            addCriterion("target_table in", values, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableNotIn(List<String> values) {
            addCriterion("target_table not in", values, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableBetween(String value1, String value2) {
            addCriterion("target_table between", value1, value2, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableNotBetween(String value1, String value2) {
            addCriterion("target_table not between", value1, value2, "targetTable");
            return (Criteria) this;
        }
        
        		
        public Criteria andTargetSqlIsNull() {
            addCriterion("target_sql is null");
            return (Criteria) this;
        }

        public Criteria andTargetSqlIsNotNull() {
            addCriterion("target_sql is not null");
            return (Criteria) this;
        }

        public Criteria andTargetSqlEqualTo(String value) {
            addCriterion("target_sql =", value, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlNotEqualTo(String value) {
            addCriterion("target_sql <>", value, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlGreaterThan(String value) {
            addCriterion("target_sql >", value, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlGreaterThanOrEqualTo(String value) {
            addCriterion("target_sql >=", value, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlLessThan(String value) {
            addCriterion("target_sql <", value, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlLessThanOrEqualTo(String value) {
            addCriterion("target_sql <=", value, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlLike(String value) {
            addCriterion("target_sql like", value, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlNotLike(String value) {
            addCriterion("target_sql not like", value, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlIn(List<String> values) {
            addCriterion("target_sql in", values, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlNotIn(List<String> values) {
            addCriterion("target_sql not in", values, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlBetween(String value1, String value2) {
            addCriterion("target_sql between", value1, value2, "targetSql");
            return (Criteria) this;
        }

        public Criteria andTargetSqlNotBetween(String value1, String value2) {
            addCriterion("target_sql not between", value1, value2, "targetSql");
            return (Criteria) this;
        }
        
        		
        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLike(Date value) {
            addCriterion("start_date like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotLike(Date value) {
            addCriterion("start_date not like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }
        
        		
        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLike(Date value) {
            addCriterion("end_date like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotLike(Date value) {
            addCriterion("end_date not like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }
        
        		
        public Criteria andRunTypeIsNull() {
            addCriterion("run_type is null");
            return (Criteria) this;
        }

        public Criteria andRunTypeIsNotNull() {
            addCriterion("run_type is not null");
            return (Criteria) this;
        }

        public Criteria andRunTypeEqualTo(String value) {
            addCriterion("run_type =", value, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeNotEqualTo(String value) {
            addCriterion("run_type <>", value, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeGreaterThan(String value) {
            addCriterion("run_type >", value, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeGreaterThanOrEqualTo(String value) {
            addCriterion("run_type >=", value, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeLessThan(String value) {
            addCriterion("run_type <", value, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeLessThanOrEqualTo(String value) {
            addCriterion("run_type <=", value, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeLike(String value) {
            addCriterion("run_type like", value, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeNotLike(String value) {
            addCriterion("run_type not like", value, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeIn(List<String> values) {
            addCriterion("run_type in", values, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeNotIn(List<String> values) {
            addCriterion("run_type not in", values, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeBetween(String value1, String value2) {
            addCriterion("run_type between", value1, value2, "runType");
            return (Criteria) this;
        }

        public Criteria andRunTypeNotBetween(String value1, String value2) {
            addCriterion("run_type not between", value1, value2, "runType");
            return (Criteria) this;
        }
        
        		
        public Criteria andJobTypeIsNull() {
            addCriterion("job_type is null");
            return (Criteria) this;
        }

        public Criteria andJobTypeIsNotNull() {
            addCriterion("job_type is not null");
            return (Criteria) this;
        }

        public Criteria andJobTypeEqualTo(String value) {
            addCriterion("job_type =", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotEqualTo(String value) {
            addCriterion("job_type <>", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThan(String value) {
            addCriterion("job_type >", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThanOrEqualTo(String value) {
            addCriterion("job_type >=", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThan(String value) {
            addCriterion("job_type <", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThanOrEqualTo(String value) {
            addCriterion("job_type <=", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLike(String value) {
            addCriterion("job_type like", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotLike(String value) {
            addCriterion("job_type not like", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeIn(List<String> values) {
            addCriterion("job_type in", values, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotIn(List<String> values) {
            addCriterion("job_type not in", values, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeBetween(String value1, String value2) {
            addCriterion("job_type between", value1, value2, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotBetween(String value1, String value2) {
            addCriterion("job_type not between", value1, value2, "jobType");
            return (Criteria) this;
        }
        
        		
        public Criteria andOnlyCountIsNull() {
            addCriterion("only_count is null");
            return (Criteria) this;
        }

        public Criteria andOnlyCountIsNotNull() {
            addCriterion("only_count is not null");
            return (Criteria) this;
        }

        public Criteria andOnlyCountEqualTo(String value) {
            addCriterion("only_count =", value, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountNotEqualTo(String value) {
            addCriterion("only_count <>", value, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountGreaterThan(String value) {
            addCriterion("only_count >", value, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountGreaterThanOrEqualTo(String value) {
            addCriterion("only_count >=", value, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountLessThan(String value) {
            addCriterion("only_count <", value, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountLessThanOrEqualTo(String value) {
            addCriterion("only_count <=", value, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountLike(String value) {
            addCriterion("only_count like", value, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountNotLike(String value) {
            addCriterion("only_count not like", value, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountIn(List<String> values) {
            addCriterion("only_count in", values, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountNotIn(List<String> values) {
            addCriterion("only_count not in", values, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountBetween(String value1, String value2) {
            addCriterion("only_count between", value1, value2, "onlyCount");
            return (Criteria) this;
        }

        public Criteria andOnlyCountNotBetween(String value1, String value2) {
            addCriterion("only_count not between", value1, value2, "onlyCount");
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

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
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

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}