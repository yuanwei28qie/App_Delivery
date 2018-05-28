package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxSdCarriageOrder;
import com.microsilver.mrcard.basicservice.model.FxSdCarriageOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FxSdCarriageOrderMapper {
    int countByExample(FxSdCarriageOrderExample example);

    int deleteByExample(FxSdCarriageOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FxSdCarriageOrder record);

    int insertSelective(FxSdCarriageOrder record);

    List<FxSdCarriageOrder> selectByExample(FxSdCarriageOrderExample example);

    FxSdCarriageOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FxSdCarriageOrder record, @Param("example") FxSdCarriageOrderExample example);

    int updateByExample(@Param("record") FxSdCarriageOrder record, @Param("example") FxSdCarriageOrderExample example);

    int updateByPrimaryKeySelective(FxSdCarriageOrder record);

    int updateByPrimaryKey(FxSdCarriageOrder record);

	int insertIntoAndReturnId(FxSdCarriageOrder record);
}