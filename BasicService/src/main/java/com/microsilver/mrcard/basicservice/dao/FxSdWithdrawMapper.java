package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxSdWithdraw;
import com.microsilver.mrcard.basicservice.model.FxSdWithdrawExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FxSdWithdrawMapper {
    int countByExample(FxSdWithdrawExample example);

    int deleteByExample(FxSdWithdrawExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FxSdWithdraw record);

    int insertSelective(FxSdWithdraw record);

    List<FxSdWithdraw> selectByExample(FxSdWithdrawExample example);

    FxSdWithdraw selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FxSdWithdraw record, @Param("example") FxSdWithdrawExample example);

    int updateByExample(@Param("record") FxSdWithdraw record, @Param("example") FxSdWithdrawExample example);

    int updateByPrimaryKeySelective(FxSdWithdraw record);

    int updateByPrimaryKey(FxSdWithdraw record);

    int insertIntoReturnId(FxSdWithdraw record);
}