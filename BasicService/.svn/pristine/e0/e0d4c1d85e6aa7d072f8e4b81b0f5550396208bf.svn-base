package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxAttribute;
import com.microsilver.mrcard.basicservice.model.FxAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxAttributeMapper {
    int countByExample(FxAttributeExample example);

    int deleteByExample(FxAttributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxAttribute record);

    int insertSelective(FxAttribute record);

    List<FxAttribute> selectByExample(FxAttributeExample example);

    FxAttribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxAttribute record, @Param("example") FxAttributeExample example);

    int updateByExample(@Param("record") FxAttribute record, @Param("example") FxAttributeExample example);

    int updateByPrimaryKeySelective(FxAttribute record);

    int updateByPrimaryKey(FxAttribute record);
}