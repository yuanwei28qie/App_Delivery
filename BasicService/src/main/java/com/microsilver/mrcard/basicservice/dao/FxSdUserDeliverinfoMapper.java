package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverinfo;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverinfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FxSdUserDeliverinfoMapper {
    int countByExample(FxSdUserDeliverinfoExample example);

    int deleteByExample(FxSdUserDeliverinfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FxSdUserDeliverinfo record);

    int insertSelective(FxSdUserDeliverinfo record);

    List<FxSdUserDeliverinfo> selectByExampleWithBLOBs(FxSdUserDeliverinfoExample example);

    List<FxSdUserDeliverinfo> selectByExample(FxSdUserDeliverinfoExample example);

    FxSdUserDeliverinfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FxSdUserDeliverinfo record, @Param("example") FxSdUserDeliverinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") FxSdUserDeliverinfo record, @Param("example") FxSdUserDeliverinfoExample example);

    int updateByExample(@Param("record") FxSdUserDeliverinfo record, @Param("example") FxSdUserDeliverinfoExample example);

    int updateByPrimaryKeySelective(FxSdUserDeliverinfo record);

    int updateByPrimaryKeyWithBLOBs(FxSdUserDeliverinfo record);

    int updateByPrimaryKey(FxSdUserDeliverinfo record);

    int insertReturnId(FxSdUserDeliverinfo record);
}