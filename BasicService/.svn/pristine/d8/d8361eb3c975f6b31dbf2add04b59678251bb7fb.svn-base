package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxAction;
import com.microsilver.mrcard.basicservice.model.FxActionExample;
import com.microsilver.mrcard.basicservice.model.FxActionWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxActionMapper {
    int countByExample(FxActionExample example);

    int deleteByExample(FxActionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxActionWithBLOBs record);

    int insertSelective(FxActionWithBLOBs record);

    List<FxActionWithBLOBs> selectByExampleWithBLOBs(FxActionExample example);

    List<FxAction> selectByExample(FxActionExample example);

    FxActionWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxActionWithBLOBs record, @Param("example") FxActionExample example);

    int updateByExampleWithBLOBs(@Param("record") FxActionWithBLOBs record, @Param("example") FxActionExample example);

    int updateByExample(@Param("record") FxAction record, @Param("example") FxActionExample example);

    int updateByPrimaryKeySelective(FxActionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(FxActionWithBLOBs record);

    int updateByPrimaryKey(FxAction record);
}