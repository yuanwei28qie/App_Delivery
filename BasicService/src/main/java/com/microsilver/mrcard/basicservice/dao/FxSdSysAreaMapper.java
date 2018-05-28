package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxSdSysArea;
import com.microsilver.mrcard.basicservice.model.FxSdSysAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxSdSysAreaMapper {
    int countByExample(FxSdSysAreaExample example);

    int deleteByExample(FxSdSysAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FxSdSysArea record);

    int insertSelective(FxSdSysArea record);

    List<FxSdSysArea> selectByExample(FxSdSysAreaExample example);

    FxSdSysArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FxSdSysArea record, @Param("example") FxSdSysAreaExample example);

    int updateByExample(@Param("record") FxSdSysArea record, @Param("example") FxSdSysAreaExample example);

    int updateByPrimaryKeySelective(FxSdSysArea record);

    int updateByPrimaryKey(FxSdSysArea record);
}