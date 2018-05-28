package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverinfo;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

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
    
    @Update("UPDATE fx_sd_user_deliverinfo SET city=#{city} ,"
    		+ "realname=#{realname} ,"
    		+ "sex=#{sex} ,"
    		+ "address=#{address} ,"
    		+ "otherphoneno=#{otherphoneno},"
    		+ "occupation=#{occupation} ,"
    		+ "create_time=#{createTime} ,"
    		+ "referee=#{referee},"
    		+ "check_status=#{checkStatus},"
    		+ "identity_card_no=#{identityCardNo} ,"
    		+ "identity_card_group=#{identityCardGroup} ,"
    		+ "identity_card_front=#{identityCardFront} ,"
    		+ "identity_card_back=#{identityCardBack} "
    		+ "WHERE id=#{id}")
    int updateEntity(FxSdUserDeliverinfo fx_sd_user_deliverinfo);

	
}