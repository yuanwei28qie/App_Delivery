package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxSdUserPreReg;
import com.microsilver.mrcard.basicservice.model.FxSdUserPreRegExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxSdUserPreRegMapper {
    int countByExample(FxSdUserPreRegExample example);

    int deleteByExample(FxSdUserPreRegExample example);

    int deleteByPrimaryKey(String mobile);

    int insert(FxSdUserPreReg record);

    int insertSelective(FxSdUserPreReg record);

    List<FxSdUserPreReg> selectByExample(FxSdUserPreRegExample example);

    FxSdUserPreReg selectByPrimaryKey(String mobile);

    int updateByExampleSelective(@Param("record") FxSdUserPreReg record, @Param("example") FxSdUserPreRegExample example);

    int updateByExample(@Param("record") FxSdUserPreReg record, @Param("example") FxSdUserPreRegExample example);

    int updateByPrimaryKeySelective(FxSdUserPreReg record);

    int updateByPrimaryKey(FxSdUserPreReg record);
}