package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxMenu;
import com.microsilver.mrcard.basicservice.model.FxMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxMenuMapper {
    int countByExample(FxMenuExample example);

    int deleteByExample(FxMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxMenu record);

    int insertSelective(FxMenu record);

    List<FxMenu> selectByExample(FxMenuExample example);

    FxMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxMenu record, @Param("example") FxMenuExample example);

    int updateByExample(@Param("record") FxMenu record, @Param("example") FxMenuExample example);

    int updateByPrimaryKeySelective(FxMenu record);

    int updateByPrimaryKey(FxMenu record);
}