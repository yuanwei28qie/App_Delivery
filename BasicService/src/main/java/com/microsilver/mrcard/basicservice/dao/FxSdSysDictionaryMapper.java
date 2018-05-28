package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxSdSysDictionary;
import com.microsilver.mrcard.basicservice.model.FxSdSysDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxSdSysDictionaryMapper {
    int countByExample(FxSdSysDictionaryExample example);

    int deleteByExample(FxSdSysDictionaryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FxSdSysDictionary record);

    int insertSelective(FxSdSysDictionary record);

    List<FxSdSysDictionary> selectByExample(FxSdSysDictionaryExample example);

    FxSdSysDictionary selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FxSdSysDictionary record, @Param("example") FxSdSysDictionaryExample example);

    int updateByExample(@Param("record") FxSdSysDictionary record, @Param("example") FxSdSysDictionaryExample example);

    int updateByPrimaryKeySelective(FxSdSysDictionary record);

    int updateByPrimaryKey(FxSdSysDictionary record);
}