package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxChannel;
import com.microsilver.mrcard.basicservice.model.FxChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxChannelMapper {
    int countByExample(FxChannelExample example);

    int deleteByExample(FxChannelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxChannel record);

    int insertSelective(FxChannel record);

    List<FxChannel> selectByExample(FxChannelExample example);

    FxChannel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxChannel record, @Param("example") FxChannelExample example);

    int updateByExample(@Param("record") FxChannel record, @Param("example") FxChannelExample example);

    int updateByPrimaryKeySelective(FxChannel record);

    int updateByPrimaryKey(FxChannel record);
}