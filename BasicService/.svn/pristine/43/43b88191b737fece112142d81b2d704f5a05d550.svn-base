package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxConfig;
import com.microsilver.mrcard.basicservice.model.FxConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxConfigMapper {
    int countByExample(FxConfigExample example);

    int deleteByExample(FxConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxConfig record);

    int insertSelective(FxConfig record);

    List<FxConfig> selectByExampleWithBLOBs(FxConfigExample example);

    List<FxConfig> selectByExample(FxConfigExample example);

    FxConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxConfig record, @Param("example") FxConfigExample example);

    int updateByExampleWithBLOBs(@Param("record") FxConfig record, @Param("example") FxConfigExample example);

    int updateByExample(@Param("record") FxConfig record, @Param("example") FxConfigExample example);

    int updateByPrimaryKeySelective(FxConfig record);

    int updateByPrimaryKeyWithBLOBs(FxConfig record);

    int updateByPrimaryKey(FxConfig record);
}