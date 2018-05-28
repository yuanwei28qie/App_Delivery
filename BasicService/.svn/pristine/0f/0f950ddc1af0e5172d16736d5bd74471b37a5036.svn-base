package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxUcenterSetting;
import com.microsilver.mrcard.basicservice.model.FxUcenterSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxUcenterSettingMapper {
    int countByExample(FxUcenterSettingExample example);

    int deleteByExample(FxUcenterSettingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxUcenterSetting record);

    int insertSelective(FxUcenterSetting record);

    List<FxUcenterSetting> selectByExampleWithBLOBs(FxUcenterSettingExample example);

    List<FxUcenterSetting> selectByExample(FxUcenterSettingExample example);

    FxUcenterSetting selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxUcenterSetting record, @Param("example") FxUcenterSettingExample example);

    int updateByExampleWithBLOBs(@Param("record") FxUcenterSetting record, @Param("example") FxUcenterSettingExample example);

    int updateByExample(@Param("record") FxUcenterSetting record, @Param("example") FxUcenterSettingExample example);

    int updateByPrimaryKeySelective(FxUcenterSetting record);

    int updateByPrimaryKeyWithBLOBs(FxUcenterSetting record);

    int updateByPrimaryKey(FxUcenterSetting record);
}