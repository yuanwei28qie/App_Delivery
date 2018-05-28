package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxSdSysLevelsetting;
import com.microsilver.mrcard.basicservice.model.FxSdSysLevelsettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxSdSysLevelsettingMapper {
    int countByExample(FxSdSysLevelsettingExample example);

    int deleteByExample(FxSdSysLevelsettingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxSdSysLevelsetting record);

    int insertSelective(FxSdSysLevelsetting record);

    List<FxSdSysLevelsetting> selectByExample(FxSdSysLevelsettingExample example);

    FxSdSysLevelsetting selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxSdSysLevelsetting record, @Param("example") FxSdSysLevelsettingExample example);

    int updateByExample(@Param("record") FxSdSysLevelsetting record, @Param("example") FxSdSysLevelsettingExample example);

    int updateByPrimaryKeySelective(FxSdSysLevelsetting record);

    int updateByPrimaryKey(FxSdSysLevelsetting record);
}