package com.microsilver.mrcard.basicservice.model;

import java.util.ArrayList;
import java.util.List;

public class FxSdUserAgentinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FxSdUserAgentinfoExample() {
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

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andSeatnumberIsNull() {
            addCriterion("seatnumber is null");
            return (Criteria) this;
        }

        public Criteria andSeatnumberIsNotNull() {
            addCriterion("seatnumber is not null");
            return (Criteria) this;
        }

        public Criteria andSeatnumberEqualTo(String value) {
            addCriterion("seatnumber =", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberNotEqualTo(String value) {
            addCriterion("seatnumber <>", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberGreaterThan(String value) {
            addCriterion("seatnumber >", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberGreaterThanOrEqualTo(String value) {
            addCriterion("seatnumber >=", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberLessThan(String value) {
            addCriterion("seatnumber <", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberLessThanOrEqualTo(String value) {
            addCriterion("seatnumber <=", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberLike(String value) {
            addCriterion("seatnumber like", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberNotLike(String value) {
            addCriterion("seatnumber not like", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberIn(List<String> values) {
            addCriterion("seatnumber in", values, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberNotIn(List<String> values) {
            addCriterion("seatnumber not in", values, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberBetween(String value1, String value2) {
            addCriterion("seatnumber between", value1, value2, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberNotBetween(String value1, String value2) {
            addCriterion("seatnumber not between", value1, value2, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realname is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realname is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realname =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realname <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realname not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realname not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameIsNull() {
            addCriterion("enterprisename is null");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameIsNotNull() {
            addCriterion("enterprisename is not null");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameEqualTo(String value) {
            addCriterion("enterprisename =", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameNotEqualTo(String value) {
            addCriterion("enterprisename <>", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameGreaterThan(String value) {
            addCriterion("enterprisename >", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameGreaterThanOrEqualTo(String value) {
            addCriterion("enterprisename >=", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameLessThan(String value) {
            addCriterion("enterprisename <", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameLessThanOrEqualTo(String value) {
            addCriterion("enterprisename <=", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameLike(String value) {
            addCriterion("enterprisename like", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameNotLike(String value) {
            addCriterion("enterprisename not like", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameIn(List<String> values) {
            addCriterion("enterprisename in", values, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameNotIn(List<String> values) {
            addCriterion("enterprisename not in", values, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameBetween(String value1, String value2) {
            addCriterion("enterprisename between", value1, value2, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameNotBetween(String value1, String value2) {
            addCriterion("enterprisename not between", value1, value2, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoIsNull() {
            addCriterion("identity_card_no is null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoIsNotNull() {
            addCriterion("identity_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoEqualTo(String value) {
            addCriterion("identity_card_no =", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoNotEqualTo(String value) {
            addCriterion("identity_card_no <>", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoGreaterThan(String value) {
            addCriterion("identity_card_no >", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("identity_card_no >=", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoLessThan(String value) {
            addCriterion("identity_card_no <", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoLessThanOrEqualTo(String value) {
            addCriterion("identity_card_no <=", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoLike(String value) {
            addCriterion("identity_card_no like", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoNotLike(String value) {
            addCriterion("identity_card_no not like", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoIn(List<String> values) {
            addCriterion("identity_card_no in", values, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoNotIn(List<String> values) {
            addCriterion("identity_card_no not in", values, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoBetween(String value1, String value2) {
            addCriterion("identity_card_no between", value1, value2, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoNotBetween(String value1, String value2) {
            addCriterion("identity_card_no not between", value1, value2, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontIsNull() {
            addCriterion("identity_card_front is null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontIsNotNull() {
            addCriterion("identity_card_front is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontEqualTo(String value) {
            addCriterion("identity_card_front =", value, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontNotEqualTo(String value) {
            addCriterion("identity_card_front <>", value, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontGreaterThan(String value) {
            addCriterion("identity_card_front >", value, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontGreaterThanOrEqualTo(String value) {
            addCriterion("identity_card_front >=", value, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontLessThan(String value) {
            addCriterion("identity_card_front <", value, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontLessThanOrEqualTo(String value) {
            addCriterion("identity_card_front <=", value, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontLike(String value) {
            addCriterion("identity_card_front like", value, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontNotLike(String value) {
            addCriterion("identity_card_front not like", value, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontIn(List<String> values) {
            addCriterion("identity_card_front in", values, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontNotIn(List<String> values) {
            addCriterion("identity_card_front not in", values, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontBetween(String value1, String value2) {
            addCriterion("identity_card_front between", value1, value2, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardFrontNotBetween(String value1, String value2) {
            addCriterion("identity_card_front not between", value1, value2, "identityCardFront");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackIsNull() {
            addCriterion("identity_card_back is null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackIsNotNull() {
            addCriterion("identity_card_back is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackEqualTo(String value) {
            addCriterion("identity_card_back =", value, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackNotEqualTo(String value) {
            addCriterion("identity_card_back <>", value, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackGreaterThan(String value) {
            addCriterion("identity_card_back >", value, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackGreaterThanOrEqualTo(String value) {
            addCriterion("identity_card_back >=", value, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackLessThan(String value) {
            addCriterion("identity_card_back <", value, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackLessThanOrEqualTo(String value) {
            addCriterion("identity_card_back <=", value, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackLike(String value) {
            addCriterion("identity_card_back like", value, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackNotLike(String value) {
            addCriterion("identity_card_back not like", value, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackIn(List<String> values) {
            addCriterion("identity_card_back in", values, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackNotIn(List<String> values) {
            addCriterion("identity_card_back not in", values, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackBetween(String value1, String value2) {
            addCriterion("identity_card_back between", value1, value2, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBackNotBetween(String value1, String value2) {
            addCriterion("identity_card_back not between", value1, value2, "identityCardBack");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupIsNull() {
            addCriterion("identity_card_group is null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupIsNotNull() {
            addCriterion("identity_card_group is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupEqualTo(String value) {
            addCriterion("identity_card_group =", value, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupNotEqualTo(String value) {
            addCriterion("identity_card_group <>", value, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupGreaterThan(String value) {
            addCriterion("identity_card_group >", value, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupGreaterThanOrEqualTo(String value) {
            addCriterion("identity_card_group >=", value, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupLessThan(String value) {
            addCriterion("identity_card_group <", value, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupLessThanOrEqualTo(String value) {
            addCriterion("identity_card_group <=", value, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupLike(String value) {
            addCriterion("identity_card_group like", value, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupNotLike(String value) {
            addCriterion("identity_card_group not like", value, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupIn(List<String> values) {
            addCriterion("identity_card_group in", values, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupNotIn(List<String> values) {
            addCriterion("identity_card_group not in", values, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupBetween(String value1, String value2) {
            addCriterion("identity_card_group between", value1, value2, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGroupNotBetween(String value1, String value2) {
            addCriterion("identity_card_group not between", value1, value2, "identityCardGroup");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
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

        public Criteria andCreateTimeEqualTo(Integer value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Integer value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Integer value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Integer value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Integer> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Integer> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Integer value1, Integer value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCountyIsNull() {
            addCriterion("county is null");
            return (Criteria) this;
        }

        public Criteria andCountyIsNotNull() {
            addCriterion("county is not null");
            return (Criteria) this;
        }

        public Criteria andCountyEqualTo(Integer value) {
            addCriterion("county =", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotEqualTo(Integer value) {
            addCriterion("county <>", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThan(Integer value) {
            addCriterion("county >", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThanOrEqualTo(Integer value) {
            addCriterion("county >=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThan(Integer value) {
            addCriterion("county <", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThanOrEqualTo(Integer value) {
            addCriterion("county <=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyIn(List<Integer> values) {
            addCriterion("county in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotIn(List<Integer> values) {
            addCriterion("county not in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyBetween(Integer value1, Integer value2) {
            addCriterion("county between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotBetween(Integer value1, Integer value2) {
            addCriterion("county not between", value1, value2, "county");
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