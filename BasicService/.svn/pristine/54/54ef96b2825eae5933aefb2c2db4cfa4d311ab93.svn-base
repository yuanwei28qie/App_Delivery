package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxHooks;
import com.microsilver.mrcard.basicservice.model.FxHooksExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxHooksMapper {
    int countByExample(FxHooksExample example);

    int deleteByExample(FxHooksExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxHooks record);

    int insertSelective(FxHooks record);

    List<FxHooks> selectByExampleWithBLOBs(FxHooksExample example);

    List<FxHooks> selectByExample(FxHooksExample example);

    FxHooks selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxHooks record, @Param("example") FxHooksExample example);

    int updateByExampleWithBLOBs(@Param("record") FxHooks record, @Param("example") FxHooksExample example);

    int updateByExample(@Param("record") FxHooks record, @Param("example") FxHooksExample example);

    int updateByPrimaryKeySelective(FxHooks record);

    int updateByPrimaryKeyWithBLOBs(FxHooks record);

    int updateByPrimaryKey(FxHooks record);
}