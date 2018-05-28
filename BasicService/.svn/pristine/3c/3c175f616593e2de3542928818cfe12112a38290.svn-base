package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxAuthRule;
import com.microsilver.mrcard.basicservice.model.FxAuthRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxAuthRuleMapper {
    int countByExample(FxAuthRuleExample example);

    int deleteByExample(FxAuthRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxAuthRule record);

    int insertSelective(FxAuthRule record);

    List<FxAuthRule> selectByExample(FxAuthRuleExample example);

    FxAuthRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxAuthRule record, @Param("example") FxAuthRuleExample example);

    int updateByExample(@Param("record") FxAuthRule record, @Param("example") FxAuthRuleExample example);

    int updateByPrimaryKeySelective(FxAuthRule record);

    int updateByPrimaryKey(FxAuthRule record);
}