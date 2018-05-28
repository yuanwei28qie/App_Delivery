package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxAuthGroup;
import com.microsilver.mrcard.basicservice.model.FxAuthGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxAuthGroupMapper {
    int countByExample(FxAuthGroupExample example);

    int deleteByExample(FxAuthGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxAuthGroup record);

    int insertSelective(FxAuthGroup record);

    List<FxAuthGroup> selectByExample(FxAuthGroupExample example);

    FxAuthGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxAuthGroup record, @Param("example") FxAuthGroupExample example);

    int updateByExample(@Param("record") FxAuthGroup record, @Param("example") FxAuthGroupExample example);

    int updateByPrimaryKeySelective(FxAuthGroup record);

    int updateByPrimaryKey(FxAuthGroup record);
}