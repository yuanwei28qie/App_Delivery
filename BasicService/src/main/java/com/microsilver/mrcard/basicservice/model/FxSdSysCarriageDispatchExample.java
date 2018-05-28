package com.microsilver.mrcard.basicservice.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FxSdSysCarriageDispatchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FxSdSysCarriageDispatchExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNull() {
            addCriterion("area_code is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("area_code is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(Integer value) {
            addCriterion("area_code =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(Integer value) {
            addCriterion("area_code <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(Integer value) {
            addCriterion("area_code >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_code >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(Integer value) {
            addCriterion("area_code <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(Integer value) {
            addCriterion("area_code <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<Integer> values) {
            addCriterion("area_code in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<Integer> values) {
            addCriterion("area_code not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(Integer value1, Integer value2) {
            addCriterion("area_code between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("area_code not between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andBasePriceIsNull() {
            addCriterion("base_price is null");
            return (Criteria) this;
        }

        public Criteria andBasePriceIsNotNull() {
            addCriterion("base_price is not null");
            return (Criteria) this;
        }

        public Criteria andBasePriceEqualTo(BigDecimal value) {
            addCriterion("base_price =", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceNotEqualTo(BigDecimal value) {
            addCriterion("base_price <>", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceGreaterThan(BigDecimal value) {
            addCriterion("base_price >", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("base_price >=", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceLessThan(BigDecimal value) {
            addCriterion("base_price <", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("base_price <=", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceIn(List<BigDecimal> values) {
            addCriterion("base_price in", values, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceNotIn(List<BigDecimal> values) {
            addCriterion("base_price not in", values, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("base_price between", value1, value2, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("base_price not between", value1, value2, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBaseMileageIsNull() {
            addCriterion("base_mileage is null");
            return (Criteria) this;
        }

        public Criteria andBaseMileageIsNotNull() {
            addCriterion("base_mileage is not null");
            return (Criteria) this;
        }

        public Criteria andBaseMileageEqualTo(Byte value) {
            addCriterion("base_mileage =", value, "baseMileage");
            return (Criteria) this;
        }

        public Criteria andBaseMileageNotEqualTo(Byte value) {
            addCriterion("base_mileage <>", value, "baseMileage");
            return (Criteria) this;
        }

        public Criteria andBaseMileageGreaterThan(Byte value) {
            addCriterion("base_mileage >", value, "baseMileage");
            return (Criteria) this;
        }

        public Criteria andBaseMileageGreaterThanOrEqualTo(Byte value) {
            addCriterion("base_mileage >=", value, "baseMileage");
            return (Criteria) this;
        }

        public Criteria andBaseMileageLessThan(Byte value) {
            addCriterion("base_mileage <", value, "baseMileage");
            return (Criteria) this;
        }

        public Criteria andBaseMileageLessThanOrEqualTo(Byte value) {
            addCriterion("base_mileage <=", value, "baseMileage");
            return (Criteria) this;
        }

        public Criteria andBaseMileageIn(List<Byte> values) {
            addCriterion("base_mileage in", values, "baseMileage");
            return (Criteria) this;
        }

        public Criteria andBaseMileageNotIn(List<Byte> values) {
            addCriterion("base_mileage not in", values, "baseMileage");
            return (Criteria) this;
        }

        public Criteria andBaseMileageBetween(Byte value1, Byte value2) {
            addCriterion("base_mileage between", value1, value2, "baseMileage");
            return (Criteria) this;
        }

        public Criteria andBaseMileageNotBetween(Byte value1, Byte value2) {
            addCriterion("base_mileage not between", value1, value2, "baseMileage");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Integer value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Integer value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Integer value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Integer value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Integer value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Integer> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Integer> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Integer value1, Integer value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Integer value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Integer value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Integer value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Integer value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Integer value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Integer> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Integer> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Integer value1, Integer value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andNightMarkupIsNull() {
            addCriterion("night_markup is null");
            return (Criteria) this;
        }

        public Criteria andNightMarkupIsNotNull() {
            addCriterion("night_markup is not null");
            return (Criteria) this;
        }

        public Criteria andNightMarkupEqualTo(BigDecimal value) {
            addCriterion("night_markup =", value, "nightMarkup");
            return (Criteria) this;
        }

        public Criteria andNightMarkupNotEqualTo(BigDecimal value) {
            addCriterion("night_markup <>", value, "nightMarkup");
            return (Criteria) this;
        }

        public Criteria andNightMarkupGreaterThan(BigDecimal value) {
            addCriterion("night_markup >", value, "nightMarkup");
            return (Criteria) this;
        }

        public Criteria andNightMarkupGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("night_markup >=", value, "nightMarkup");
            return (Criteria) this;
        }

        public Criteria andNightMarkupLessThan(BigDecimal value) {
            addCriterion("night_markup <", value, "nightMarkup");
            return (Criteria) this;
        }

        public Criteria andNightMarkupLessThanOrEqualTo(BigDecimal value) {
            addCriterion("night_markup <=", value, "nightMarkup");
            return (Criteria) this;
        }

        public Criteria andNightMarkupIn(List<BigDecimal> values) {
            addCriterion("night_markup in", values, "nightMarkup");
            return (Criteria) this;
        }

        public Criteria andNightMarkupNotIn(List<BigDecimal> values) {
            addCriterion("night_markup not in", values, "nightMarkup");
            return (Criteria) this;
        }

        public Criteria andNightMarkupBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("night_markup between", value1, value2, "nightMarkup");
            return (Criteria) this;
        }

        public Criteria andNightMarkupNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("night_markup not between", value1, value2, "nightMarkup");
            return (Criteria) this;
        }

        public Criteria andMileageMarkupIsNull() {
            addCriterion("mileage_markup is null");
            return (Criteria) this;
        }

        public Criteria andMileageMarkupIsNotNull() {
            addCriterion("mileage_markup is not null");
            return (Criteria) this;
        }

        public Criteria andMileageMarkupEqualTo(BigDecimal value) {
            addCriterion("mileage_markup =", value, "mileageMarkup");
            return (Criteria) this;
        }

        public Criteria andMileageMarkupNotEqualTo(BigDecimal value) {
            addCriterion("mileage_markup <>", value, "mileageMarkup");
            return (Criteria) this;
        }

        public Criteria andMileageMarkupGreaterThan(BigDecimal value) {
            addCriterion("mileage_markup >", value, "mileageMarkup");
            return (Criteria) this;
        }

        public Criteria andMileageMarkupGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mileage_markup >=", value, "mileageMarkup");
            return (Criteria) this;
        }

        public Criteria andMileageMarkupLessThan(BigDecimal value) {
            addCriterion("mileage_markup <", value, "mileageMarkup");
            return (Criteria) this;
        }

        public Criteria andMileageMarkupLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mileage_markup <=", value, "mileageMarkup");
            return (Criteria) this;
        }

        public Criteria andMileageMarkupIn(List<BigDecimal> values) {
            addCriterion("mileage_markup in", values, "mileageMarkup");
            return (Criteria) this;
        }

        public Criteria andMileageMarkupNotIn(List<BigDecimal> values) {
            addCriterion("mileage_markup not in", values, "mileageMarkup");
            return (Criteria) this;
        }

        public Criteria andMileageMarkupBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mileage_markup between", value1, value2, "mileageMarkup");
            return (Criteria) this;
        }

        public Criteria andMileageMarkupNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mileage_markup not between", value1, value2, "mileageMarkup");
            return (Criteria) this;
        }

        public Criteria andSpecialMarkupIsNull() {
            addCriterion("special_markup is null");
            return (Criteria) this;
        }

        public Criteria andSpecialMarkupIsNotNull() {
            addCriterion("special_markup is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialMarkupEqualTo(BigDecimal value) {
            addCriterion("special_markup =", value, "specialMarkup");
            return (Criteria) this;
        }

        public Criteria andSpecialMarkupNotEqualTo(BigDecimal value) {
            addCriterion("special_markup <>", value, "specialMarkup");
            return (Criteria) this;
        }

        public Criteria andSpecialMarkupGreaterThan(BigDecimal value) {
            addCriterion("special_markup >", value, "specialMarkup");
            return (Criteria) this;
        }

        public Criteria andSpecialMarkupGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("special_markup >=", value, "specialMarkup");
            return (Criteria) this;
        }

        public Criteria andSpecialMarkupLessThan(BigDecimal value) {
            addCriterion("special_markup <", value, "specialMarkup");
            return (Criteria) this;
        }

        public Criteria andSpecialMarkupLessThanOrEqualTo(BigDecimal value) {
            addCriterion("special_markup <=", value, "specialMarkup");
            return (Criteria) this;
        }

        public Criteria andSpecialMarkupIn(List<BigDecimal> values) {
            addCriterion("special_markup in", values, "specialMarkup");
            return (Criteria) this;
        }

        public Criteria andSpecialMarkupNotIn(List<BigDecimal> values) {
            addCriterion("special_markup not in", values, "specialMarkup");
            return (Criteria) this;
        }

        public Criteria andSpecialMarkupBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("special_markup between", value1, value2, "specialMarkup");
            return (Criteria) this;
        }

        public Criteria andSpecialMarkupNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("special_markup not between", value1, value2, "specialMarkup");
            return (Criteria) this;
        }

        public Criteria andWeightMarkupIsNull() {
            addCriterion("weight_markup is null");
            return (Criteria) this;
        }

        public Criteria andWeightMarkupIsNotNull() {
            addCriterion("weight_markup is not null");
            return (Criteria) this;
        }

        public Criteria andWeightMarkupEqualTo(BigDecimal value) {
            addCriterion("weight_markup =", value, "weightMarkup");
            return (Criteria) this;
        }

        public Criteria andWeightMarkupNotEqualTo(BigDecimal value) {
            addCriterion("weight_markup <>", value, "weightMarkup");
            return (Criteria) this;
        }

        public Criteria andWeightMarkupGreaterThan(BigDecimal value) {
            addCriterion("weight_markup >", value, "weightMarkup");
            return (Criteria) this;
        }

        public Criteria andWeightMarkupGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight_markup >=", value, "weightMarkup");
            return (Criteria) this;
        }

        public Criteria andWeightMarkupLessThan(BigDecimal value) {
            addCriterion("weight_markup <", value, "weightMarkup");
            return (Criteria) this;
        }

        public Criteria andWeightMarkupLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight_markup <=", value, "weightMarkup");
            return (Criteria) this;
        }

        public Criteria andWeightMarkupIn(List<BigDecimal> values) {
            addCriterion("weight_markup in", values, "weightMarkup");
            return (Criteria) this;
        }

        public Criteria andWeightMarkupNotIn(List<BigDecimal> values) {
            addCriterion("weight_markup not in", values, "weightMarkup");
            return (Criteria) this;
        }

        public Criteria andWeightMarkupBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight_markup between", value1, value2, "weightMarkup");
            return (Criteria) this;
        }

        public Criteria andWeightMarkupNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight_markup not between", value1, value2, "weightMarkup");
            return (Criteria) this;
        }

        public Criteria andInitialWeightIsNull() {
            addCriterion("initial_weight is null");
            return (Criteria) this;
        }

        public Criteria andInitialWeightIsNotNull() {
            addCriterion("initial_weight is not null");
            return (Criteria) this;
        }

        public Criteria andInitialWeightEqualTo(Integer value) {
            addCriterion("initial_weight =", value, "initialWeight");
            return (Criteria) this;
        }

        public Criteria andInitialWeightNotEqualTo(Integer value) {
            addCriterion("initial_weight <>", value, "initialWeight");
            return (Criteria) this;
        }

        public Criteria andInitialWeightGreaterThan(Integer value) {
            addCriterion("initial_weight >", value, "initialWeight");
            return (Criteria) this;
        }

        public Criteria andInitialWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("initial_weight >=", value, "initialWeight");
            return (Criteria) this;
        }

        public Criteria andInitialWeightLessThan(Integer value) {
            addCriterion("initial_weight <", value, "initialWeight");
            return (Criteria) this;
        }

        public Criteria andInitialWeightLessThanOrEqualTo(Integer value) {
            addCriterion("initial_weight <=", value, "initialWeight");
            return (Criteria) this;
        }

        public Criteria andInitialWeightIn(List<Integer> values) {
            addCriterion("initial_weight in", values, "initialWeight");
            return (Criteria) this;
        }

        public Criteria andInitialWeightNotIn(List<Integer> values) {
            addCriterion("initial_weight not in", values, "initialWeight");
            return (Criteria) this;
        }

        public Criteria andInitialWeightBetween(Integer value1, Integer value2) {
            addCriterion("initial_weight between", value1, value2, "initialWeight");
            return (Criteria) this;
        }

        public Criteria andInitialWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("initial_weight not between", value1, value2, "initialWeight");
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