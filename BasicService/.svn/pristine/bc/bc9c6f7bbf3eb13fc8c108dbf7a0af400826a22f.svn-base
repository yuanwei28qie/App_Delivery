package com.microsilver.mrcard.basicservice.model;

import java.util.ArrayList;
import java.util.List;

public class FxCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FxCategoryExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andListRowIsNull() {
            addCriterion("list_row is null");
            return (Criteria) this;
        }

        public Criteria andListRowIsNotNull() {
            addCriterion("list_row is not null");
            return (Criteria) this;
        }

        public Criteria andListRowEqualTo(Byte value) {
            addCriterion("list_row =", value, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowNotEqualTo(Byte value) {
            addCriterion("list_row <>", value, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowGreaterThan(Byte value) {
            addCriterion("list_row >", value, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowGreaterThanOrEqualTo(Byte value) {
            addCriterion("list_row >=", value, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowLessThan(Byte value) {
            addCriterion("list_row <", value, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowLessThanOrEqualTo(Byte value) {
            addCriterion("list_row <=", value, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowIn(List<Byte> values) {
            addCriterion("list_row in", values, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowNotIn(List<Byte> values) {
            addCriterion("list_row not in", values, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowBetween(Byte value1, Byte value2) {
            addCriterion("list_row between", value1, value2, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowNotBetween(Byte value1, Byte value2) {
            addCriterion("list_row not between", value1, value2, "listRow");
            return (Criteria) this;
        }

        public Criteria andMetaTitleIsNull() {
            addCriterion("meta_title is null");
            return (Criteria) this;
        }

        public Criteria andMetaTitleIsNotNull() {
            addCriterion("meta_title is not null");
            return (Criteria) this;
        }

        public Criteria andMetaTitleEqualTo(String value) {
            addCriterion("meta_title =", value, "metaTitle");
            return (Criteria) this;
        }

        public Criteria andMetaTitleNotEqualTo(String value) {
            addCriterion("meta_title <>", value, "metaTitle");
            return (Criteria) this;
        }

        public Criteria andMetaTitleGreaterThan(String value) {
            addCriterion("meta_title >", value, "metaTitle");
            return (Criteria) this;
        }

        public Criteria andMetaTitleGreaterThanOrEqualTo(String value) {
            addCriterion("meta_title >=", value, "metaTitle");
            return (Criteria) this;
        }

        public Criteria andMetaTitleLessThan(String value) {
            addCriterion("meta_title <", value, "metaTitle");
            return (Criteria) this;
        }

        public Criteria andMetaTitleLessThanOrEqualTo(String value) {
            addCriterion("meta_title <=", value, "metaTitle");
            return (Criteria) this;
        }

        public Criteria andMetaTitleLike(String value) {
            addCriterion("meta_title like", value, "metaTitle");
            return (Criteria) this;
        }

        public Criteria andMetaTitleNotLike(String value) {
            addCriterion("meta_title not like", value, "metaTitle");
            return (Criteria) this;
        }

        public Criteria andMetaTitleIn(List<String> values) {
            addCriterion("meta_title in", values, "metaTitle");
            return (Criteria) this;
        }

        public Criteria andMetaTitleNotIn(List<String> values) {
            addCriterion("meta_title not in", values, "metaTitle");
            return (Criteria) this;
        }

        public Criteria andMetaTitleBetween(String value1, String value2) {
            addCriterion("meta_title between", value1, value2, "metaTitle");
            return (Criteria) this;
        }

        public Criteria andMetaTitleNotBetween(String value1, String value2) {
            addCriterion("meta_title not between", value1, value2, "metaTitle");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("keywords is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("keywords is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("keywords =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("keywords <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("keywords >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("keywords >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("keywords <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("keywords <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("keywords like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("keywords not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("keywords in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("keywords not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("keywords between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("keywords not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andTemplateIndexIsNull() {
            addCriterion("template_index is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIndexIsNotNull() {
            addCriterion("template_index is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIndexEqualTo(String value) {
            addCriterion("template_index =", value, "templateIndex");
            return (Criteria) this;
        }

        public Criteria andTemplateIndexNotEqualTo(String value) {
            addCriterion("template_index <>", value, "templateIndex");
            return (Criteria) this;
        }

        public Criteria andTemplateIndexGreaterThan(String value) {
            addCriterion("template_index >", value, "templateIndex");
            return (Criteria) this;
        }

        public Criteria andTemplateIndexGreaterThanOrEqualTo(String value) {
            addCriterion("template_index >=", value, "templateIndex");
            return (Criteria) this;
        }

        public Criteria andTemplateIndexLessThan(String value) {
            addCriterion("template_index <", value, "templateIndex");
            return (Criteria) this;
        }

        public Criteria andTemplateIndexLessThanOrEqualTo(String value) {
            addCriterion("template_index <=", value, "templateIndex");
            return (Criteria) this;
        }

        public Criteria andTemplateIndexLike(String value) {
            addCriterion("template_index like", value, "templateIndex");
            return (Criteria) this;
        }

        public Criteria andTemplateIndexNotLike(String value) {
            addCriterion("template_index not like", value, "templateIndex");
            return (Criteria) this;
        }

        public Criteria andTemplateIndexIn(List<String> values) {
            addCriterion("template_index in", values, "templateIndex");
            return (Criteria) this;
        }

        public Criteria andTemplateIndexNotIn(List<String> values) {
            addCriterion("template_index not in", values, "templateIndex");
            return (Criteria) this;
        }

        public Criteria andTemplateIndexBetween(String value1, String value2) {
            addCriterion("template_index between", value1, value2, "templateIndex");
            return (Criteria) this;
        }

        public Criteria andTemplateIndexNotBetween(String value1, String value2) {
            addCriterion("template_index not between", value1, value2, "templateIndex");
            return (Criteria) this;
        }

        public Criteria andTemplateListsIsNull() {
            addCriterion("template_lists is null");
            return (Criteria) this;
        }

        public Criteria andTemplateListsIsNotNull() {
            addCriterion("template_lists is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateListsEqualTo(String value) {
            addCriterion("template_lists =", value, "templateLists");
            return (Criteria) this;
        }

        public Criteria andTemplateListsNotEqualTo(String value) {
            addCriterion("template_lists <>", value, "templateLists");
            return (Criteria) this;
        }

        public Criteria andTemplateListsGreaterThan(String value) {
            addCriterion("template_lists >", value, "templateLists");
            return (Criteria) this;
        }

        public Criteria andTemplateListsGreaterThanOrEqualTo(String value) {
            addCriterion("template_lists >=", value, "templateLists");
            return (Criteria) this;
        }

        public Criteria andTemplateListsLessThan(String value) {
            addCriterion("template_lists <", value, "templateLists");
            return (Criteria) this;
        }

        public Criteria andTemplateListsLessThanOrEqualTo(String value) {
            addCriterion("template_lists <=", value, "templateLists");
            return (Criteria) this;
        }

        public Criteria andTemplateListsLike(String value) {
            addCriterion("template_lists like", value, "templateLists");
            return (Criteria) this;
        }

        public Criteria andTemplateListsNotLike(String value) {
            addCriterion("template_lists not like", value, "templateLists");
            return (Criteria) this;
        }

        public Criteria andTemplateListsIn(List<String> values) {
            addCriterion("template_lists in", values, "templateLists");
            return (Criteria) this;
        }

        public Criteria andTemplateListsNotIn(List<String> values) {
            addCriterion("template_lists not in", values, "templateLists");
            return (Criteria) this;
        }

        public Criteria andTemplateListsBetween(String value1, String value2) {
            addCriterion("template_lists between", value1, value2, "templateLists");
            return (Criteria) this;
        }

        public Criteria andTemplateListsNotBetween(String value1, String value2) {
            addCriterion("template_lists not between", value1, value2, "templateLists");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailIsNull() {
            addCriterion("template_detail is null");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailIsNotNull() {
            addCriterion("template_detail is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailEqualTo(String value) {
            addCriterion("template_detail =", value, "templateDetail");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailNotEqualTo(String value) {
            addCriterion("template_detail <>", value, "templateDetail");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailGreaterThan(String value) {
            addCriterion("template_detail >", value, "templateDetail");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailGreaterThanOrEqualTo(String value) {
            addCriterion("template_detail >=", value, "templateDetail");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailLessThan(String value) {
            addCriterion("template_detail <", value, "templateDetail");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailLessThanOrEqualTo(String value) {
            addCriterion("template_detail <=", value, "templateDetail");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailLike(String value) {
            addCriterion("template_detail like", value, "templateDetail");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailNotLike(String value) {
            addCriterion("template_detail not like", value, "templateDetail");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailIn(List<String> values) {
            addCriterion("template_detail in", values, "templateDetail");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailNotIn(List<String> values) {
            addCriterion("template_detail not in", values, "templateDetail");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailBetween(String value1, String value2) {
            addCriterion("template_detail between", value1, value2, "templateDetail");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailNotBetween(String value1, String value2) {
            addCriterion("template_detail not between", value1, value2, "templateDetail");
            return (Criteria) this;
        }

        public Criteria andTemplateEditIsNull() {
            addCriterion("template_edit is null");
            return (Criteria) this;
        }

        public Criteria andTemplateEditIsNotNull() {
            addCriterion("template_edit is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateEditEqualTo(String value) {
            addCriterion("template_edit =", value, "templateEdit");
            return (Criteria) this;
        }

        public Criteria andTemplateEditNotEqualTo(String value) {
            addCriterion("template_edit <>", value, "templateEdit");
            return (Criteria) this;
        }

        public Criteria andTemplateEditGreaterThan(String value) {
            addCriterion("template_edit >", value, "templateEdit");
            return (Criteria) this;
        }

        public Criteria andTemplateEditGreaterThanOrEqualTo(String value) {
            addCriterion("template_edit >=", value, "templateEdit");
            return (Criteria) this;
        }

        public Criteria andTemplateEditLessThan(String value) {
            addCriterion("template_edit <", value, "templateEdit");
            return (Criteria) this;
        }

        public Criteria andTemplateEditLessThanOrEqualTo(String value) {
            addCriterion("template_edit <=", value, "templateEdit");
            return (Criteria) this;
        }

        public Criteria andTemplateEditLike(String value) {
            addCriterion("template_edit like", value, "templateEdit");
            return (Criteria) this;
        }

        public Criteria andTemplateEditNotLike(String value) {
            addCriterion("template_edit not like", value, "templateEdit");
            return (Criteria) this;
        }

        public Criteria andTemplateEditIn(List<String> values) {
            addCriterion("template_edit in", values, "templateEdit");
            return (Criteria) this;
        }

        public Criteria andTemplateEditNotIn(List<String> values) {
            addCriterion("template_edit not in", values, "templateEdit");
            return (Criteria) this;
        }

        public Criteria andTemplateEditBetween(String value1, String value2) {
            addCriterion("template_edit between", value1, value2, "templateEdit");
            return (Criteria) this;
        }

        public Criteria andTemplateEditNotBetween(String value1, String value2) {
            addCriterion("template_edit not between", value1, value2, "templateEdit");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLinkIdIsNull() {
            addCriterion("link_id is null");
            return (Criteria) this;
        }

        public Criteria andLinkIdIsNotNull() {
            addCriterion("link_id is not null");
            return (Criteria) this;
        }

        public Criteria andLinkIdEqualTo(Integer value) {
            addCriterion("link_id =", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotEqualTo(Integer value) {
            addCriterion("link_id <>", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdGreaterThan(Integer value) {
            addCriterion("link_id >", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("link_id >=", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdLessThan(Integer value) {
            addCriterion("link_id <", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdLessThanOrEqualTo(Integer value) {
            addCriterion("link_id <=", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdIn(List<Integer> values) {
            addCriterion("link_id in", values, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotIn(List<Integer> values) {
            addCriterion("link_id not in", values, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdBetween(Integer value1, Integer value2) {
            addCriterion("link_id between", value1, value2, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("link_id not between", value1, value2, "linkId");
            return (Criteria) this;
        }

        public Criteria andAllowPublishIsNull() {
            addCriterion("allow_publish is null");
            return (Criteria) this;
        }

        public Criteria andAllowPublishIsNotNull() {
            addCriterion("allow_publish is not null");
            return (Criteria) this;
        }

        public Criteria andAllowPublishEqualTo(Byte value) {
            addCriterion("allow_publish =", value, "allowPublish");
            return (Criteria) this;
        }

        public Criteria andAllowPublishNotEqualTo(Byte value) {
            addCriterion("allow_publish <>", value, "allowPublish");
            return (Criteria) this;
        }

        public Criteria andAllowPublishGreaterThan(Byte value) {
            addCriterion("allow_publish >", value, "allowPublish");
            return (Criteria) this;
        }

        public Criteria andAllowPublishGreaterThanOrEqualTo(Byte value) {
            addCriterion("allow_publish >=", value, "allowPublish");
            return (Criteria) this;
        }

        public Criteria andAllowPublishLessThan(Byte value) {
            addCriterion("allow_publish <", value, "allowPublish");
            return (Criteria) this;
        }

        public Criteria andAllowPublishLessThanOrEqualTo(Byte value) {
            addCriterion("allow_publish <=", value, "allowPublish");
            return (Criteria) this;
        }

        public Criteria andAllowPublishIn(List<Byte> values) {
            addCriterion("allow_publish in", values, "allowPublish");
            return (Criteria) this;
        }

        public Criteria andAllowPublishNotIn(List<Byte> values) {
            addCriterion("allow_publish not in", values, "allowPublish");
            return (Criteria) this;
        }

        public Criteria andAllowPublishBetween(Byte value1, Byte value2) {
            addCriterion("allow_publish between", value1, value2, "allowPublish");
            return (Criteria) this;
        }

        public Criteria andAllowPublishNotBetween(Byte value1, Byte value2) {
            addCriterion("allow_publish not between", value1, value2, "allowPublish");
            return (Criteria) this;
        }

        public Criteria andDisplayIsNull() {
            addCriterion("display is null");
            return (Criteria) this;
        }

        public Criteria andDisplayIsNotNull() {
            addCriterion("display is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayEqualTo(Byte value) {
            addCriterion("display =", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotEqualTo(Byte value) {
            addCriterion("display <>", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayGreaterThan(Byte value) {
            addCriterion("display >", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayGreaterThanOrEqualTo(Byte value) {
            addCriterion("display >=", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayLessThan(Byte value) {
            addCriterion("display <", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayLessThanOrEqualTo(Byte value) {
            addCriterion("display <=", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayIn(List<Byte> values) {
            addCriterion("display in", values, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotIn(List<Byte> values) {
            addCriterion("display not in", values, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayBetween(Byte value1, Byte value2) {
            addCriterion("display between", value1, value2, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotBetween(Byte value1, Byte value2) {
            addCriterion("display not between", value1, value2, "display");
            return (Criteria) this;
        }

        public Criteria andReplyIsNull() {
            addCriterion("reply is null");
            return (Criteria) this;
        }

        public Criteria andReplyIsNotNull() {
            addCriterion("reply is not null");
            return (Criteria) this;
        }

        public Criteria andReplyEqualTo(Byte value) {
            addCriterion("reply =", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotEqualTo(Byte value) {
            addCriterion("reply <>", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyGreaterThan(Byte value) {
            addCriterion("reply >", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyGreaterThanOrEqualTo(Byte value) {
            addCriterion("reply >=", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyLessThan(Byte value) {
            addCriterion("reply <", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyLessThanOrEqualTo(Byte value) {
            addCriterion("reply <=", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyIn(List<Byte> values) {
            addCriterion("reply in", values, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotIn(List<Byte> values) {
            addCriterion("reply not in", values, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyBetween(Byte value1, Byte value2) {
            addCriterion("reply between", value1, value2, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotBetween(Byte value1, Byte value2) {
            addCriterion("reply not between", value1, value2, "reply");
            return (Criteria) this;
        }

        public Criteria andCheckIsNull() {
            addCriterion("check is null");
            return (Criteria) this;
        }

        public Criteria andCheckIsNotNull() {
            addCriterion("check is not null");
            return (Criteria) this;
        }

        public Criteria andCheckEqualTo(Byte value) {
            addCriterion("check =", value, "check");
            return (Criteria) this;
        }

        public Criteria andCheckNotEqualTo(Byte value) {
            addCriterion("check <>", value, "check");
            return (Criteria) this;
        }

        public Criteria andCheckGreaterThan(Byte value) {
            addCriterion("check >", value, "check");
            return (Criteria) this;
        }

        public Criteria andCheckGreaterThanOrEqualTo(Byte value) {
            addCriterion("check >=", value, "check");
            return (Criteria) this;
        }

        public Criteria andCheckLessThan(Byte value) {
            addCriterion("check <", value, "check");
            return (Criteria) this;
        }

        public Criteria andCheckLessThanOrEqualTo(Byte value) {
            addCriterion("check <=", value, "check");
            return (Criteria) this;
        }

        public Criteria andCheckIn(List<Byte> values) {
            addCriterion("check in", values, "check");
            return (Criteria) this;
        }

        public Criteria andCheckNotIn(List<Byte> values) {
            addCriterion("check not in", values, "check");
            return (Criteria) this;
        }

        public Criteria andCheckBetween(Byte value1, Byte value2) {
            addCriterion("check between", value1, value2, "check");
            return (Criteria) this;
        }

        public Criteria andCheckNotBetween(Byte value1, Byte value2) {
            addCriterion("check not between", value1, value2, "check");
            return (Criteria) this;
        }

        public Criteria andReplyModelIsNull() {
            addCriterion("reply_model is null");
            return (Criteria) this;
        }

        public Criteria andReplyModelIsNotNull() {
            addCriterion("reply_model is not null");
            return (Criteria) this;
        }

        public Criteria andReplyModelEqualTo(String value) {
            addCriterion("reply_model =", value, "replyModel");
            return (Criteria) this;
        }

        public Criteria andReplyModelNotEqualTo(String value) {
            addCriterion("reply_model <>", value, "replyModel");
            return (Criteria) this;
        }

        public Criteria andReplyModelGreaterThan(String value) {
            addCriterion("reply_model >", value, "replyModel");
            return (Criteria) this;
        }

        public Criteria andReplyModelGreaterThanOrEqualTo(String value) {
            addCriterion("reply_model >=", value, "replyModel");
            return (Criteria) this;
        }

        public Criteria andReplyModelLessThan(String value) {
            addCriterion("reply_model <", value, "replyModel");
            return (Criteria) this;
        }

        public Criteria andReplyModelLessThanOrEqualTo(String value) {
            addCriterion("reply_model <=", value, "replyModel");
            return (Criteria) this;
        }

        public Criteria andReplyModelLike(String value) {
            addCriterion("reply_model like", value, "replyModel");
            return (Criteria) this;
        }

        public Criteria andReplyModelNotLike(String value) {
            addCriterion("reply_model not like", value, "replyModel");
            return (Criteria) this;
        }

        public Criteria andReplyModelIn(List<String> values) {
            addCriterion("reply_model in", values, "replyModel");
            return (Criteria) this;
        }

        public Criteria andReplyModelNotIn(List<String> values) {
            addCriterion("reply_model not in", values, "replyModel");
            return (Criteria) this;
        }

        public Criteria andReplyModelBetween(String value1, String value2) {
            addCriterion("reply_model between", value1, value2, "replyModel");
            return (Criteria) this;
        }

        public Criteria andReplyModelNotBetween(String value1, String value2) {
            addCriterion("reply_model not between", value1, value2, "replyModel");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Integer value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Integer value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Integer value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Integer value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Integer> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Integer> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Integer value1, Integer value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(Integer value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(Integer value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(Integer value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(Integer value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(Integer value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(Integer value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<Integer> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<Integer> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(Integer value1, Integer value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(Integer value1, Integer value2) {
            addCriterion("icon not between", value1, value2, "icon");
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