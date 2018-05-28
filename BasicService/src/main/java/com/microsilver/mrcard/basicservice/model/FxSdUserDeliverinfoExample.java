package com.microsilver.mrcard.basicservice.model;

import java.util.ArrayList;
import java.util.List;

public class FxSdUserDeliverinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FxSdUserDeliverinfoExample() {
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

        public Criteria andPwdIsNull() {
            addCriterion("pwd is null");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("pwd =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("pwd <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("pwd >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pwd >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("pwd <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("pwd <=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLike(String value) {
            addCriterion("pwd like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("pwd not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdIn(List<String> values) {
            addCriterion("pwd in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("pwd not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("pwd between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("pwd not between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andSaltIsNull() {
            addCriterion("salt is null");
            return (Criteria) this;
        }

        public Criteria andSaltIsNotNull() {
            addCriterion("salt is not null");
            return (Criteria) this;
        }

        public Criteria andSaltEqualTo(String value) {
            addCriterion("salt =", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotEqualTo(String value) {
            addCriterion("salt <>", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThan(String value) {
            addCriterion("salt >", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThanOrEqualTo(String value) {
            addCriterion("salt >=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThan(String value) {
            addCriterion("salt <", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThanOrEqualTo(String value) {
            addCriterion("salt <=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLike(String value) {
            addCriterion("salt like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotLike(String value) {
            addCriterion("salt not like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltIn(List<String> values) {
            addCriterion("salt in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotIn(List<String> values) {
            addCriterion("salt not in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltBetween(String value1, String value2) {
            addCriterion("salt between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotBetween(String value1, String value2) {
            addCriterion("salt not between", value1, value2, "salt");
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

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Short value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Short value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Short value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Short value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Short value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Short value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Short> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Short> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Short value1, Short value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Short value1, Short value2) {
            addCriterion("gender not between", value1, value2, "gender");
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

        public Criteria andAlipayAccountIsNull() {
            addCriterion("alipay_account is null");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountIsNotNull() {
            addCriterion("alipay_account is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountEqualTo(String value) {
            addCriterion("alipay_account =", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountNotEqualTo(String value) {
            addCriterion("alipay_account <>", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountGreaterThan(String value) {
            addCriterion("alipay_account >", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_account >=", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountLessThan(String value) {
            addCriterion("alipay_account <", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountLessThanOrEqualTo(String value) {
            addCriterion("alipay_account <=", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountLike(String value) {
            addCriterion("alipay_account like", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountNotLike(String value) {
            addCriterion("alipay_account not like", value, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountIn(List<String> values) {
            addCriterion("alipay_account in", values, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountNotIn(List<String> values) {
            addCriterion("alipay_account not in", values, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountBetween(String value1, String value2) {
            addCriterion("alipay_account between", value1, value2, "alipayAccount");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountNotBetween(String value1, String value2) {
            addCriterion("alipay_account not between", value1, value2, "alipayAccount");
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

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(Short value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(Short value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(Short value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(Short value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(Short value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<Short> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<Short> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(Short value1, Short value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(Short value1, Short value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(Integer value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(Integer value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(Integer value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(Integer value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(Integer value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(Integer value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<Integer> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<Integer> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(Integer value1, Integer value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(Integer value1, Integer value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(Integer value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(Integer value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(Integer value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(Integer value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(Integer value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(Integer value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<Integer> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<Integer> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(Integer value1, Integer value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(Integer value1, Integer value2) {
            addCriterion("city not between", value1, value2, "city");
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

        public Criteria andOtherphonenoIsNull() {
            addCriterion("otherphoneno is null");
            return (Criteria) this;
        }

        public Criteria andOtherphonenoIsNotNull() {
            addCriterion("otherphoneno is not null");
            return (Criteria) this;
        }

        public Criteria andOtherphonenoEqualTo(String value) {
            addCriterion("otherphoneno =", value, "otherphoneno");
            return (Criteria) this;
        }

        public Criteria andOtherphonenoNotEqualTo(String value) {
            addCriterion("otherphoneno <>", value, "otherphoneno");
            return (Criteria) this;
        }

        public Criteria andOtherphonenoGreaterThan(String value) {
            addCriterion("otherphoneno >", value, "otherphoneno");
            return (Criteria) this;
        }

        public Criteria andOtherphonenoGreaterThanOrEqualTo(String value) {
            addCriterion("otherphoneno >=", value, "otherphoneno");
            return (Criteria) this;
        }

        public Criteria andOtherphonenoLessThan(String value) {
            addCriterion("otherphoneno <", value, "otherphoneno");
            return (Criteria) this;
        }

        public Criteria andOtherphonenoLessThanOrEqualTo(String value) {
            addCriterion("otherphoneno <=", value, "otherphoneno");
            return (Criteria) this;
        }

        public Criteria andOtherphonenoLike(String value) {
            addCriterion("otherphoneno like", value, "otherphoneno");
            return (Criteria) this;
        }

        public Criteria andOtherphonenoNotLike(String value) {
            addCriterion("otherphoneno not like", value, "otherphoneno");
            return (Criteria) this;
        }

        public Criteria andOtherphonenoIn(List<String> values) {
            addCriterion("otherphoneno in", values, "otherphoneno");
            return (Criteria) this;
        }

        public Criteria andOtherphonenoNotIn(List<String> values) {
            addCriterion("otherphoneno not in", values, "otherphoneno");
            return (Criteria) this;
        }

        public Criteria andOtherphonenoBetween(String value1, String value2) {
            addCriterion("otherphoneno between", value1, value2, "otherphoneno");
            return (Criteria) this;
        }

        public Criteria andOtherphonenoNotBetween(String value1, String value2) {
            addCriterion("otherphoneno not between", value1, value2, "otherphoneno");
            return (Criteria) this;
        }

        public Criteria andOccupationIsNull() {
            addCriterion("occupation is null");
            return (Criteria) this;
        }

        public Criteria andOccupationIsNotNull() {
            addCriterion("occupation is not null");
            return (Criteria) this;
        }

        public Criteria andOccupationEqualTo(String value) {
            addCriterion("occupation =", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotEqualTo(String value) {
            addCriterion("occupation <>", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationGreaterThan(String value) {
            addCriterion("occupation >", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationGreaterThanOrEqualTo(String value) {
            addCriterion("occupation >=", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationLessThan(String value) {
            addCriterion("occupation <", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationLessThanOrEqualTo(String value) {
            addCriterion("occupation <=", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationLike(String value) {
            addCriterion("occupation like", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotLike(String value) {
            addCriterion("occupation not like", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationIn(List<String> values) {
            addCriterion("occupation in", values, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotIn(List<String> values) {
            addCriterion("occupation not in", values, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationBetween(String value1, String value2) {
            addCriterion("occupation between", value1, value2, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotBetween(String value1, String value2) {
            addCriterion("occupation not between", value1, value2, "occupation");
            return (Criteria) this;
        }

        public Criteria andIdentifierIsNull() {
            addCriterion("identifier is null");
            return (Criteria) this;
        }

        public Criteria andIdentifierIsNotNull() {
            addCriterion("identifier is not null");
            return (Criteria) this;
        }

        public Criteria andIdentifierEqualTo(String value) {
            addCriterion("identifier =", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotEqualTo(String value) {
            addCriterion("identifier <>", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierGreaterThan(String value) {
            addCriterion("identifier >", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierGreaterThanOrEqualTo(String value) {
            addCriterion("identifier >=", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierLessThan(String value) {
            addCriterion("identifier <", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierLessThanOrEqualTo(String value) {
            addCriterion("identifier <=", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierLike(String value) {
            addCriterion("identifier like", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotLike(String value) {
            addCriterion("identifier not like", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierIn(List<String> values) {
            addCriterion("identifier in", values, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotIn(List<String> values) {
            addCriterion("identifier not in", values, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierBetween(String value1, String value2) {
            addCriterion("identifier between", value1, value2, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotBetween(String value1, String value2) {
            addCriterion("identifier not between", value1, value2, "identifier");
            return (Criteria) this;
        }

        public Criteria andRefereeIsNull() {
            addCriterion("referee is null");
            return (Criteria) this;
        }

        public Criteria andRefereeIsNotNull() {
            addCriterion("referee is not null");
            return (Criteria) this;
        }

        public Criteria andRefereeEqualTo(Long value) {
            addCriterion("referee =", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotEqualTo(Long value) {
            addCriterion("referee <>", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeGreaterThan(Long value) {
            addCriterion("referee >", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeGreaterThanOrEqualTo(Long value) {
            addCriterion("referee >=", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLessThan(Long value) {
            addCriterion("referee <", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLessThanOrEqualTo(Long value) {
            addCriterion("referee <=", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeIn(List<Long> values) {
            addCriterion("referee in", values, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotIn(List<Long> values) {
            addCriterion("referee not in", values, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeBetween(Long value1, Long value2) {
            addCriterion("referee between", value1, value2, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotBetween(Long value1, Long value2) {
            addCriterion("referee not between", value1, value2, "referee");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIsNull() {
            addCriterion("finance_id is null");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIsNotNull() {
            addCriterion("finance_id is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceIdEqualTo(Long value) {
            addCriterion("finance_id =", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotEqualTo(Long value) {
            addCriterion("finance_id <>", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdGreaterThan(Long value) {
            addCriterion("finance_id >", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("finance_id >=", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLessThan(Long value) {
            addCriterion("finance_id <", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLessThanOrEqualTo(Long value) {
            addCriterion("finance_id <=", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIn(List<Long> values) {
            addCriterion("finance_id in", values, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotIn(List<Long> values) {
            addCriterion("finance_id not in", values, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdBetween(Long value1, Long value2) {
            addCriterion("finance_id between", value1, value2, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotBetween(Long value1, Long value2) {
            addCriterion("finance_id not between", value1, value2, "financeId");
            return (Criteria) this;
        }

        public Criteria andImTokenIsNull() {
            addCriterion("im_token is null");
            return (Criteria) this;
        }

        public Criteria andImTokenIsNotNull() {
            addCriterion("im_token is not null");
            return (Criteria) this;
        }

        public Criteria andImTokenEqualTo(String value) {
            addCriterion("im_token =", value, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenNotEqualTo(String value) {
            addCriterion("im_token <>", value, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenGreaterThan(String value) {
            addCriterion("im_token >", value, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenGreaterThanOrEqualTo(String value) {
            addCriterion("im_token >=", value, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenLessThan(String value) {
            addCriterion("im_token <", value, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenLessThanOrEqualTo(String value) {
            addCriterion("im_token <=", value, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenLike(String value) {
            addCriterion("im_token like", value, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenNotLike(String value) {
            addCriterion("im_token not like", value, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenIn(List<String> values) {
            addCriterion("im_token in", values, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenNotIn(List<String> values) {
            addCriterion("im_token not in", values, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenBetween(String value1, String value2) {
            addCriterion("im_token between", value1, value2, "imToken");
            return (Criteria) this;
        }

        public Criteria andImTokenNotBetween(String value1, String value2) {
            addCriterion("im_token not between", value1, value2, "imToken");
            return (Criteria) this;
        }

        public Criteria andImAccoutIsNull() {
            addCriterion("im_accout is null");
            return (Criteria) this;
        }

        public Criteria andImAccoutIsNotNull() {
            addCriterion("im_accout is not null");
            return (Criteria) this;
        }

        public Criteria andImAccoutEqualTo(String value) {
            addCriterion("im_accout =", value, "imAccout");
            return (Criteria) this;
        }

        public Criteria andImAccoutNotEqualTo(String value) {
            addCriterion("im_accout <>", value, "imAccout");
            return (Criteria) this;
        }

        public Criteria andImAccoutGreaterThan(String value) {
            addCriterion("im_accout >", value, "imAccout");
            return (Criteria) this;
        }

        public Criteria andImAccoutGreaterThanOrEqualTo(String value) {
            addCriterion("im_accout >=", value, "imAccout");
            return (Criteria) this;
        }

        public Criteria andImAccoutLessThan(String value) {
            addCriterion("im_accout <", value, "imAccout");
            return (Criteria) this;
        }

        public Criteria andImAccoutLessThanOrEqualTo(String value) {
            addCriterion("im_accout <=", value, "imAccout");
            return (Criteria) this;
        }

        public Criteria andImAccoutLike(String value) {
            addCriterion("im_accout like", value, "imAccout");
            return (Criteria) this;
        }

        public Criteria andImAccoutNotLike(String value) {
            addCriterion("im_accout not like", value, "imAccout");
            return (Criteria) this;
        }

        public Criteria andImAccoutIn(List<String> values) {
            addCriterion("im_accout in", values, "imAccout");
            return (Criteria) this;
        }

        public Criteria andImAccoutNotIn(List<String> values) {
            addCriterion("im_accout not in", values, "imAccout");
            return (Criteria) this;
        }

        public Criteria andImAccoutBetween(String value1, String value2) {
            addCriterion("im_accout between", value1, value2, "imAccout");
            return (Criteria) this;
        }

        public Criteria andImAccoutNotBetween(String value1, String value2) {
            addCriterion("im_accout not between", value1, value2, "imAccout");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNull() {
            addCriterion("agent_id is null");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNotNull() {
            addCriterion("agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgentIdEqualTo(Long value) {
            addCriterion("agent_id =", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotEqualTo(Long value) {
            addCriterion("agent_id <>", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThan(Long value) {
            addCriterion("agent_id >", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("agent_id >=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThan(Long value) {
            addCriterion("agent_id <", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThanOrEqualTo(Long value) {
            addCriterion("agent_id <=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIn(List<Long> values) {
            addCriterion("agent_id in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotIn(List<Long> values) {
            addCriterion("agent_id not in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdBetween(Long value1, Long value2) {
            addCriterion("agent_id between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotBetween(Long value1, Long value2) {
            addCriterion("agent_id not between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andStatesIsNull() {
            addCriterion("states is null");
            return (Criteria) this;
        }

        public Criteria andStatesIsNotNull() {
            addCriterion("states is not null");
            return (Criteria) this;
        }

        public Criteria andStatesEqualTo(Byte value) {
            addCriterion("states =", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotEqualTo(Byte value) {
            addCriterion("states <>", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesGreaterThan(Byte value) {
            addCriterion("states >", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesGreaterThanOrEqualTo(Byte value) {
            addCriterion("states >=", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesLessThan(Byte value) {
            addCriterion("states <", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesLessThanOrEqualTo(Byte value) {
            addCriterion("states <=", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesIn(List<Byte> values) {
            addCriterion("states in", values, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotIn(List<Byte> values) {
            addCriterion("states not in", values, "states");
            return (Criteria) this;
        }

        public Criteria andStatesBetween(Byte value1, Byte value2) {
            addCriterion("states between", value1, value2, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotBetween(Byte value1, Byte value2) {
            addCriterion("states not between", value1, value2, "states");
            return (Criteria) this;
        }

        public Criteria andServiceScoreIsNull() {
            addCriterion("service_score is null");
            return (Criteria) this;
        }

        public Criteria andServiceScoreIsNotNull() {
            addCriterion("service_score is not null");
            return (Criteria) this;
        }

        public Criteria andServiceScoreEqualTo(Double value) {
            addCriterion("service_score =", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreNotEqualTo(Double value) {
            addCriterion("service_score <>", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreGreaterThan(Double value) {
            addCriterion("service_score >", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("service_score >=", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreLessThan(Double value) {
            addCriterion("service_score <", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreLessThanOrEqualTo(Double value) {
            addCriterion("service_score <=", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreIn(List<Double> values) {
            addCriterion("service_score in", values, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreNotIn(List<Double> values) {
            addCriterion("service_score not in", values, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreBetween(Double value1, Double value2) {
            addCriterion("service_score between", value1, value2, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreNotBetween(Double value1, Double value2) {
            addCriterion("service_score not between", value1, value2, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andLevelSocreIsNull() {
            addCriterion("level_socre is null");
            return (Criteria) this;
        }

        public Criteria andLevelSocreIsNotNull() {
            addCriterion("level_socre is not null");
            return (Criteria) this;
        }

        public Criteria andLevelSocreEqualTo(Double value) {
            addCriterion("level_socre =", value, "levelSocre");
            return (Criteria) this;
        }

        public Criteria andLevelSocreNotEqualTo(Double value) {
            addCriterion("level_socre <>", value, "levelSocre");
            return (Criteria) this;
        }

        public Criteria andLevelSocreGreaterThan(Double value) {
            addCriterion("level_socre >", value, "levelSocre");
            return (Criteria) this;
        }

        public Criteria andLevelSocreGreaterThanOrEqualTo(Double value) {
            addCriterion("level_socre >=", value, "levelSocre");
            return (Criteria) this;
        }

        public Criteria andLevelSocreLessThan(Double value) {
            addCriterion("level_socre <", value, "levelSocre");
            return (Criteria) this;
        }

        public Criteria andLevelSocreLessThanOrEqualTo(Double value) {
            addCriterion("level_socre <=", value, "levelSocre");
            return (Criteria) this;
        }

        public Criteria andLevelSocreIn(List<Double> values) {
            addCriterion("level_socre in", values, "levelSocre");
            return (Criteria) this;
        }

        public Criteria andLevelSocreNotIn(List<Double> values) {
            addCriterion("level_socre not in", values, "levelSocre");
            return (Criteria) this;
        }

        public Criteria andLevelSocreBetween(Double value1, Double value2) {
            addCriterion("level_socre between", value1, value2, "levelSocre");
            return (Criteria) this;
        }

        public Criteria andLevelSocreNotBetween(Double value1, Double value2) {
            addCriterion("level_socre not between", value1, value2, "levelSocre");
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