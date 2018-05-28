package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxSdSysAreaopen;
import com.microsilver.mrcard.basicservice.model.FxSdSysAreaopenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxSdSysAreaopenMapper {
    int countByExample(FxSdSysAreaopenExample example);

    int deleteByExample(FxSdSysAreaopenExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FxSdSysAreaopen record);

    int insertSelective(FxSdSysAreaopen record);

    List<FxSdSysAreaopen> selectByExample(FxSdSysAreaopenExample example);

    FxSdSysAreaopen selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FxSdSysAreaopen record, @Param("example") FxSdSysAreaopenExample example);

    int updateByExample(@Param("record") FxSdSysAreaopen record, @Param("example") FxSdSysAreaopenExample example);

    int updateByPrimaryKeySelective(FxSdSysAreaopen record);

    int updateByPrimaryKey(FxSdSysAreaopen record);
}