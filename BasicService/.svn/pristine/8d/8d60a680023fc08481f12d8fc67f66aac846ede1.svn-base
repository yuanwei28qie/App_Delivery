package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxActionLog;
import com.microsilver.mrcard.basicservice.model.FxActionLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxActionLogMapper {
    int countByExample(FxActionLogExample example);

    int deleteByExample(FxActionLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxActionLog record);

    int insertSelective(FxActionLog record);

    List<FxActionLog> selectByExample(FxActionLogExample example);

    FxActionLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxActionLog record, @Param("example") FxActionLogExample example);

    int updateByExample(@Param("record") FxActionLog record, @Param("example") FxActionLogExample example);

    int updateByPrimaryKeySelective(FxActionLog record);

    int updateByPrimaryKey(FxActionLog record);
}