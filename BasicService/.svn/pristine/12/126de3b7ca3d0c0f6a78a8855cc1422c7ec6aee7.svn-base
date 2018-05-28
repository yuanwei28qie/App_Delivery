package com.microsilver.mrcard.basicservice.model;

import java.util.ArrayList;
import java.util.List;

public class FxModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FxModelExample() {
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

        public Criteria andExtendIsNull() {
            addCriterion("extend is null");
            return (Criteria) this;
        }

        public Criteria andExtendIsNotNull() {
            addCriterion("extend is not null");
            return (Criteria) this;
        }

        public Criteria andExtendEqualTo(Integer value) {
            addCriterion("extend =", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotEqualTo(Integer value) {
            addCriterion("extend <>", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThan(Integer value) {
            addCriterion("extend >", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThanOrEqualTo(Integer value) {
            addCriterion("extend >=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThan(Integer value) {
            addCriterion("extend <", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThanOrEqualTo(Integer value) {
            addCriterion("extend <=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendIn(List<Integer> values) {
            addCriterion("extend in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotIn(List<Integer> values) {
            addCriterion("extend not in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendBetween(Integer value1, Integer value2) {
            addCriterion("extend between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotBetween(Integer value1, Integer value2) {
            addCriterion("extend not between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andRelationIsNull() {
            addCriterion("relation is null");
            return (Criteria) this;
        }

        public Criteria andRelationIsNotNull() {
            addCriterion("relation is not null");
            return (Criteria) this;
        }

        public Criteria andRelationEqualTo(String value) {
            addCriterion("relation =", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotEqualTo(String value) {
            addCriterion("relation <>", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThan(String value) {
            addCriterion("relation >", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThanOrEqualTo(String value) {
            addCriterion("relation >=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThan(String value) {
            addCriterion("relation <", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThanOrEqualTo(String value) {
            addCriterion("relation <=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLike(String value) {
            addCriterion("relation like", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotLike(String value) {
            addCriterion("relation not like", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationIn(List<String> values) {
            addCriterion("relation in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotIn(List<String> values) {
            addCriterion("relation not in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationBetween(String value1, String value2) {
            addCriterion("relation between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotBetween(String value1, String value2) {
            addCriterion("relation not between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andNeedPkIsNull() {
            addCriterion("need_pk is null");
            return (Criteria) this;
        }

        public Criteria andNeedPkIsNotNull() {
            addCriterion("need_pk is not null");
            return (Criteria) this;
        }

        public Criteria andNeedPkEqualTo(Boolean value) {
            addCriterion("need_pk =", value, "needPk");
            return (Criteria) this;
        }

        public Criteria andNeedPkNotEqualTo(Boolean value) {
            addCriterion("need_pk <>", value, "needPk");
            return (Criteria) this;
        }

        public Criteria andNeedPkGreaterThan(Boolean value) {
            addCriterion("need_pk >", value, "needPk");
            return (Criteria) this;
        }

        public Criteria andNeedPkGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_pk >=", value, "needPk");
            return (Criteria) this;
        }

        public Criteria andNeedPkLessThan(Boolean value) {
            addCriterion("need_pk <", value, "needPk");
            return (Criteria) this;
        }

        public Criteria andNeedPkLessThanOrEqualTo(Boolean value) {
            addCriterion("need_pk <=", value, "needPk");
            return (Criteria) this;
        }

        public Criteria andNeedPkIn(List<Boolean> values) {
            addCriterion("need_pk in", values, "needPk");
            return (Criteria) this;
        }

        public Criteria andNeedPkNotIn(List<Boolean> values) {
            addCriterion("need_pk not in", values, "needPk");
            return (Criteria) this;
        }

        public Criteria andNeedPkBetween(Boolean value1, Boolean value2) {
            addCriterion("need_pk between", value1, value2, "needPk");
            return (Criteria) this;
        }

        public Criteria andNeedPkNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_pk not between", value1, value2, "needPk");
            return (Criteria) this;
        }

        public Criteria andFieldGroupIsNull() {
            addCriterion("field_group is null");
            return (Criteria) this;
        }

        public Criteria andFieldGroupIsNotNull() {
            addCriterion("field_group is not null");
            return (Criteria) this;
        }

        public Criteria andFieldGroupEqualTo(String value) {
            addCriterion("field_group =", value, "fieldGroup");
            return (Criteria) this;
        }

        public Criteria andFieldGroupNotEqualTo(String value) {
            addCriterion("field_group <>", value, "fieldGroup");
            return (Criteria) this;
        }

        public Criteria andFieldGroupGreaterThan(String value) {
            addCriterion("field_group >", value, "fieldGroup");
            return (Criteria) this;
        }

        public Criteria andFieldGroupGreaterThanOrEqualTo(String value) {
            addCriterion("field_group >=", value, "fieldGroup");
            return (Criteria) this;
        }

        public Criteria andFieldGroupLessThan(String value) {
            addCriterion("field_group <", value, "fieldGroup");
            return (Criteria) this;
        }

        public Criteria andFieldGroupLessThanOrEqualTo(String value) {
            addCriterion("field_group <=", value, "fieldGroup");
            return (Criteria) this;
        }

        public Criteria andFieldGroupLike(String value) {
            addCriterion("field_group like", value, "fieldGroup");
            return (Criteria) this;
        }

        public Criteria andFieldGroupNotLike(String value) {
            addCriterion("field_group not like", value, "fieldGroup");
            return (Criteria) this;
        }

        public Criteria andFieldGroupIn(List<String> values) {
            addCriterion("field_group in", values, "fieldGroup");
            return (Criteria) this;
        }

        public Criteria andFieldGroupNotIn(List<String> values) {
            addCriterion("field_group not in", values, "fieldGroup");
            return (Criteria) this;
        }

        public Criteria andFieldGroupBetween(String value1, String value2) {
            addCriterion("field_group between", value1, value2, "fieldGroup");
            return (Criteria) this;
        }

        public Criteria andFieldGroupNotBetween(String value1, String value2) {
            addCriterion("field_group not between", value1, value2, "fieldGroup");
            return (Criteria) this;
        }

        public Criteria andTemplateListIsNull() {
            addCriterion("template_list is null");
            return (Criteria) this;
        }

        public Criteria andTemplateListIsNotNull() {
            addCriterion("template_list is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateListEqualTo(String value) {
            addCriterion("template_list =", value, "templateList");
            return (Criteria) this;
        }

        public Criteria andTemplateListNotEqualTo(String value) {
            addCriterion("template_list <>", value, "templateList");
            return (Criteria) this;
        }

        public Criteria andTemplateListGreaterThan(String value) {
            addCriterion("template_list >", value, "templateList");
            return (Criteria) this;
        }

        public Criteria andTemplateListGreaterThanOrEqualTo(String value) {
            addCriterion("template_list >=", value, "templateList");
            return (Criteria) this;
        }

        public Criteria andTemplateListLessThan(String value) {
            addCriterion("template_list <", value, "templateList");
            return (Criteria) this;
        }

        public Criteria andTemplateListLessThanOrEqualTo(String value) {
            addCriterion("template_list <=", value, "templateList");
            return (Criteria) this;
        }

        public Criteria andTemplateListLike(String value) {
            addCriterion("template_list like", value, "templateList");
            return (Criteria) this;
        }

        public Criteria andTemplateListNotLike(String value) {
            addCriterion("template_list not like", value, "templateList");
            return (Criteria) this;
        }

        public Criteria andTemplateListIn(List<String> values) {
            addCriterion("template_list in", values, "templateList");
            return (Criteria) this;
        }

        public Criteria andTemplateListNotIn(List<String> values) {
            addCriterion("template_list not in", values, "templateList");
            return (Criteria) this;
        }

        public Criteria andTemplateListBetween(String value1, String value2) {
            addCriterion("template_list between", value1, value2, "templateList");
            return (Criteria) this;
        }

        public Criteria andTemplateListNotBetween(String value1, String value2) {
            addCriterion("template_list not between", value1, value2, "templateList");
            return (Criteria) this;
        }

        public Criteria andTemplateAddIsNull() {
            addCriterion("template_add is null");
            return (Criteria) this;
        }

        public Criteria andTemplateAddIsNotNull() {
            addCriterion("template_add is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateAddEqualTo(String value) {
            addCriterion("template_add =", value, "templateAdd");
            return (Criteria) this;
        }

        public Criteria andTemplateAddNotEqualTo(String value) {
            addCriterion("template_add <>", value, "templateAdd");
            return (Criteria) this;
        }

        public Criteria andTemplateAddGreaterThan(String value) {
            addCriterion("template_add >", value, "templateAdd");
            return (Criteria) this;
        }

        public Criteria andTemplateAddGreaterThanOrEqualTo(String value) {
            addCriterion("template_add >=", value, "templateAdd");
            return (Criteria) this;
        }

        public Criteria andTemplateAddLessThan(String value) {
            addCriterion("template_add <", value, "templateAdd");
            return (Criteria) this;
        }

        public Criteria andTemplateAddLessThanOrEqualTo(String value) {
            addCriterion("template_add <=", value, "templateAdd");
            return (Criteria) this;
        }

        public Criteria andTemplateAddLike(String value) {
            addCriterion("template_add like", value, "templateAdd");
            return (Criteria) this;
        }

        public Criteria andTemplateAddNotLike(String value) {
            addCriterion("template_add not like", value, "templateAdd");
            return (Criteria) this;
        }

        public Criteria andTemplateAddIn(List<String> values) {
            addCriterion("template_add in", values, "templateAdd");
            return (Criteria) this;
        }

        public Criteria andTemplateAddNotIn(List<String> values) {
            addCriterion("template_add not in", values, "templateAdd");
            return (Criteria) this;
        }

        public Criteria andTemplateAddBetween(String value1, String value2) {
            addCriterion("template_add between", value1, value2, "templateAdd");
            return (Criteria) this;
        }

        public Criteria andTemplateAddNotBetween(String value1, String value2) {
            addCriterion("template_add not between", value1, value2, "templateAdd");
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

        public Criteria andListRowIsNull() {
            addCriterion("list_row is null");
            return (Criteria) this;
        }

        public Criteria andListRowIsNotNull() {
            addCriterion("list_row is not null");
            return (Criteria) this;
        }

        public Criteria andListRowEqualTo(Short value) {
            addCriterion("list_row =", value, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowNotEqualTo(Short value) {
            addCriterion("list_row <>", value, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowGreaterThan(Short value) {
            addCriterion("list_row >", value, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowGreaterThanOrEqualTo(Short value) {
            addCriterion("list_row >=", value, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowLessThan(Short value) {
            addCriterion("list_row <", value, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowLessThanOrEqualTo(Short value) {
            addCriterion("list_row <=", value, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowIn(List<Short> values) {
            addCriterion("list_row in", values, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowNotIn(List<Short> values) {
            addCriterion("list_row not in", values, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowBetween(Short value1, Short value2) {
            addCriterion("list_row between", value1, value2, "listRow");
            return (Criteria) this;
        }

        public Criteria andListRowNotBetween(Short value1, Short value2) {
            addCriterion("list_row not between", value1, value2, "listRow");
            return (Criteria) this;
        }

        public Criteria andSearchKeyIsNull() {
            addCriterion("search_key is null");
            return (Criteria) this;
        }

        public Criteria andSearchKeyIsNotNull() {
            addCriterion("search_key is not null");
            return (Criteria) this;
        }

        public Criteria andSearchKeyEqualTo(String value) {
            addCriterion("search_key =", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyNotEqualTo(String value) {
            addCriterion("search_key <>", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyGreaterThan(String value) {
            addCriterion("search_key >", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyGreaterThanOrEqualTo(String value) {
            addCriterion("search_key >=", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyLessThan(String value) {
            addCriterion("search_key <", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyLessThanOrEqualTo(String value) {
            addCriterion("search_key <=", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyLike(String value) {
            addCriterion("search_key like", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyNotLike(String value) {
            addCriterion("search_key not like", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyIn(List<String> values) {
            addCriterion("search_key in", values, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyNotIn(List<String> values) {
            addCriterion("search_key not in", values, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyBetween(String value1, String value2) {
            addCriterion("search_key between", value1, value2, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyNotBetween(String value1, String value2) {
            addCriterion("search_key not between", value1, value2, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchListIsNull() {
            addCriterion("search_list is null");
            return (Criteria) this;
        }

        public Criteria andSearchListIsNotNull() {
            addCriterion("search_list is not null");
            return (Criteria) this;
        }

        public Criteria andSearchListEqualTo(String value) {
            addCriterion("search_list =", value, "searchList");
            return (Criteria) this;
        }

        public Criteria andSearchListNotEqualTo(String value) {
            addCriterion("search_list <>", value, "searchList");
            return (Criteria) this;
        }

        public Criteria andSearchListGreaterThan(String value) {
            addCriterion("search_list >", value, "searchList");
            return (Criteria) this;
        }

        public Criteria andSearchListGreaterThanOrEqualTo(String value) {
            addCriterion("search_list >=", value, "searchList");
            return (Criteria) this;
        }

        public Criteria andSearchListLessThan(String value) {
            addCriterion("search_list <", value, "searchList");
            return (Criteria) this;
        }

        public Criteria andSearchListLessThanOrEqualTo(String value) {
            addCriterion("search_list <=", value, "searchList");
            return (Criteria) this;
        }

        public Criteria andSearchListLike(String value) {
            addCriterion("search_list like", value, "searchList");
            return (Criteria) this;
        }

        public Criteria andSearchListNotLike(String value) {
            addCriterion("search_list not like", value, "searchList");
            return (Criteria) this;
        }

        public Criteria andSearchListIn(List<String> values) {
            addCriterion("search_list in", values, "searchList");
            return (Criteria) this;
        }

        public Criteria andSearchListNotIn(List<String> values) {
            addCriterion("search_list not in", values, "searchList");
            return (Criteria) this;
        }

        public Criteria andSearchListBetween(String value1, String value2) {
            addCriterion("search_list between", value1, value2, "searchList");
            return (Criteria) this;
        }

        public Criteria andSearchListNotBetween(String value1, String value2) {
            addCriterion("search_list not between", value1, value2, "searchList");
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

        public Criteria andEngineTypeIsNull() {
            addCriterion("engine_type is null");
            return (Criteria) this;
        }

        public Criteria andEngineTypeIsNotNull() {
            addCriterion("engine_type is not null");
            return (Criteria) this;
        }

        public Criteria andEngineTypeEqualTo(String value) {
            addCriterion("engine_type =", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeNotEqualTo(String value) {
            addCriterion("engine_type <>", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeGreaterThan(String value) {
            addCriterion("engine_type >", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeGreaterThanOrEqualTo(String value) {
            addCriterion("engine_type >=", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeLessThan(String value) {
            addCriterion("engine_type <", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeLessThanOrEqualTo(String value) {
            addCriterion("engine_type <=", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeLike(String value) {
            addCriterion("engine_type like", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeNotLike(String value) {
            addCriterion("engine_type not like", value, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeIn(List<String> values) {
            addCriterion("engine_type in", values, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeNotIn(List<String> values) {
            addCriterion("engine_type not in", values, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeBetween(String value1, String value2) {
            addCriterion("engine_type between", value1, value2, "engineType");
            return (Criteria) this;
        }

        public Criteria andEngineTypeNotBetween(String value1, String value2) {
            addCriterion("engine_type not between", value1, value2, "engineType");
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