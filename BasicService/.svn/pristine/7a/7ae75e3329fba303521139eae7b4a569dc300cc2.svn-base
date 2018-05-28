package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxUserdata;
import com.microsilver.mrcard.basicservice.model.FxUserdataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxUserdataMapper {
    int countByExample(FxUserdataExample example);

    int deleteByExample(FxUserdataExample example);

    int insert(FxUserdata record);

    int insertSelective(FxUserdata record);

    List<FxUserdata> selectByExample(FxUserdataExample example);

    int updateByExampleSelective(@Param("record") FxUserdata record, @Param("example") FxUserdataExample example);

    int updateByExample(@Param("record") FxUserdata record, @Param("example") FxUserdataExample example);
}