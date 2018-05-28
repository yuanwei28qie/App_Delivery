package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxSdUserAgentinfo;
import com.microsilver.mrcard.basicservice.model.FxSdUserAgentinfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FxSdUserAgentinfoMapper {
    int countByExample(FxSdUserAgentinfoExample example);

    int deleteByExample(FxSdUserAgentinfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FxSdUserAgentinfo record);

    int insertSelective(FxSdUserAgentinfo record);

    List<FxSdUserAgentinfo> selectByExample(FxSdUserAgentinfoExample example);

    FxSdUserAgentinfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FxSdUserAgentinfo record, @Param("example") FxSdUserAgentinfoExample example);

    int updateByExample(@Param("record") FxSdUserAgentinfo record, @Param("example") FxSdUserAgentinfoExample example);

    int updateByPrimaryKeySelective(FxSdUserAgentinfo record);

    int updateByPrimaryKey(FxSdUserAgentinfo record);
}