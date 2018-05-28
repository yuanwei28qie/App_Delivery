package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxCategory;
import com.microsilver.mrcard.basicservice.model.FxCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxCategoryMapper {
    int countByExample(FxCategoryExample example);

    int deleteByExample(FxCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxCategory record);

    int insertSelective(FxCategory record);

    List<FxCategory> selectByExampleWithBLOBs(FxCategoryExample example);

    List<FxCategory> selectByExample(FxCategoryExample example);

    FxCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxCategory record, @Param("example") FxCategoryExample example);

    int updateByExampleWithBLOBs(@Param("record") FxCategory record, @Param("example") FxCategoryExample example);

    int updateByExample(@Param("record") FxCategory record, @Param("example") FxCategoryExample example);

    int updateByPrimaryKeySelective(FxCategory record);

    int updateByPrimaryKeyWithBLOBs(FxCategory record);

    int updateByPrimaryKey(FxCategory record);
}