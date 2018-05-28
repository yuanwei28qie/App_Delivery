package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxAddons;
import com.microsilver.mrcard.basicservice.model.FxAddonsExample;
import com.microsilver.mrcard.basicservice.model.FxAddonsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxAddonsMapper {
    int countByExample(FxAddonsExample example);

    int deleteByExample(FxAddonsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxAddonsWithBLOBs record);

    int insertSelective(FxAddonsWithBLOBs record);

    List<FxAddonsWithBLOBs> selectByExampleWithBLOBs(FxAddonsExample example);

    List<FxAddons> selectByExample(FxAddonsExample example);

    FxAddonsWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxAddonsWithBLOBs record, @Param("example") FxAddonsExample example);

    int updateByExampleWithBLOBs(@Param("record") FxAddonsWithBLOBs record, @Param("example") FxAddonsExample example);

    int updateByExample(@Param("record") FxAddons record, @Param("example") FxAddonsExample example);

    int updateByPrimaryKeySelective(FxAddonsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(FxAddonsWithBLOBs record);

    int updateByPrimaryKey(FxAddons record);
}