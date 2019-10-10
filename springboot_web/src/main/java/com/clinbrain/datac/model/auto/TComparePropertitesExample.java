package com.clinbrain.datac.model.auto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TComparePropertitesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TComparePropertitesExample() {
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

        public Criteria andPropertitesNameIsNull() {
            addCriterion("propertites_name is null");
            return (Criteria) this;
        }

        public Criteria andPropertitesNameIsNotNull() {
            addCriterion("propertites_name is not null");
            return (Criteria) this;
        }

        public Criteria andPropertitesNameEqualTo(String value) {
            addCriterion("propertites_name =", value, "propertitesName");
            return (Criteria) this;
        }

        public Criteria andPropertitesNameNotEqualTo(String value) {
            addCriterion("propertites_name <>", value, "propertitesName");
            return (Criteria) this;
        }

        public Criteria andPropertitesNameGreaterThan(String value) {
            addCriterion("propertites_name >", value, "propertitesName");
            return (Criteria) this;
        }

        public Criteria andPropertitesNameGreaterThanOrEqualTo(String value) {
            addCriterion("propertites_name >=", value, "propertitesName");
            return (Criteria) this;
        }

        public Criteria andPropertitesNameLessThan(String value) {
            addCriterion("propertites_name <", value, "propertitesName");
            return (Criteria) this;
        }

        public Criteria andPropertitesNameLessThanOrEqualTo(String value) {
            addCriterion("propertites_name <=", value, "propertitesName");
            return (Criteria) this;
        }

        public Criteria andPropertitesNameLike(String value) {
            addCriterion("propertites_name like", value, "propertitesName");
            return (Criteria) this;
        }

        public Criteria andPropertitesNameNotLike(String value) {
            addCriterion("propertites_name not like", value, "propertitesName");
            return (Criteria) this;
        }

        public Criteria andPropertitesNameIn(List<String> values) {
            addCriterion("propertites_name in", values, "propertitesName");
            return (Criteria) this;
        }

        public Criteria andPropertitesNameNotIn(List<String> values) {
            addCriterion("propertites_name not in", values, "propertitesName");
            return (Criteria) this;
        }

        public Criteria andPropertitesNameBetween(String value1, String value2) {
            addCriterion("propertites_name between", value1, value2, "propertitesName");
            return (Criteria) this;
        }

        public Criteria andPropertitesNameNotBetween(String value1, String value2) {
            addCriterion("propertites_name not between", value1, value2, "propertitesName");
            return (Criteria) this;
        }

        public Criteria andPropertitesCronIsNull() {
            addCriterion("propertites_cron is null");
            return (Criteria) this;
        }

        public Criteria andPropertitesCronIsNotNull() {
            addCriterion("propertites_cron is not null");
            return (Criteria) this;
        }

        public Criteria andPropertitesCronEqualTo(String value) {
            addCriterion("propertites_cron =", value, "propertitesCron");
            return (Criteria) this;
        }

        public Criteria andPropertitesCronNotEqualTo(String value) {
            addCriterion("propertites_cron <>", value, "propertitesCron");
            return (Criteria) this;
        }

        public Criteria andPropertitesCronGreaterThan(String value) {
            addCriterion("propertites_cron >", value, "propertitesCron");
            return (Criteria) this;
        }

        public Criteria andPropertitesCronGreaterThanOrEqualTo(String value) {
            addCriterion("propertites_cron >=", value, "propertitesCron");
            return (Criteria) this;
        }

        public Criteria andPropertitesCronLessThan(String value) {
            addCriterion("propertites_cron <", value, "propertitesCron");
            return (Criteria) this;
        }

        public Criteria andPropertitesCronLessThanOrEqualTo(String value) {
            addCriterion("propertites_cron <=", value, "propertitesCron");
            return (Criteria) this;
        }

        public Criteria andPropertitesCronLike(String value) {
            addCriterion("propertites_cron like", value, "propertitesCron");
            return (Criteria) this;
        }

        public Criteria andPropertitesCronNotLike(String value) {
            addCriterion("propertites_cron not like", value, "propertitesCron");
            return (Criteria) this;
        }

        public Criteria andPropertitesCronIn(List<String> values) {
            addCriterion("propertites_cron in", values, "propertitesCron");
            return (Criteria) this;
        }

        public Criteria andPropertitesCronNotIn(List<String> values) {
            addCriterion("propertites_cron not in", values, "propertitesCron");
            return (Criteria) this;
        }

        public Criteria andPropertitesCronBetween(String value1, String value2) {
            addCriterion("propertites_cron between", value1, value2, "propertitesCron");
            return (Criteria) this;
        }

        public Criteria andPropertitesCronNotBetween(String value1, String value2) {
            addCriterion("propertites_cron not between", value1, value2, "propertitesCron");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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