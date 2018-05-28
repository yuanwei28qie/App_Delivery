package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxSdUserMember;
import com.microsilver.mrcard.basicservice.model.FxSdUserMemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FxSdUserMemberMapper {
    int countByExample(FxSdUserMemberExample example);

    int deleteByExample(FxSdUserMemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FxSdUserMember record);

    int insertSelective(FxSdUserMember record);

    List<FxSdUserMember> selectByExampleWithBLOBs(FxSdUserMemberExample example);

    List<FxSdUserMember> selectByExample(FxSdUserMemberExample example);

    FxSdUserMember selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FxSdUserMember record, @Param("example") FxSdUserMemberExample example);

    int updateByExampleWithBLOBs(@Param("record") FxSdUserMember record, @Param("example") FxSdUserMemberExample example);

    int updateByExample(@Param("record") FxSdUserMember record, @Param("example") FxSdUserMemberExample example);

    int updateByPrimaryKeySelective(FxSdUserMember record);

    int updateByPrimaryKeyWithBLOBs(FxSdUserMember record);

    int updateByPrimaryKey(FxSdUserMember record);

    int insertIntoAndReturnId(FxSdUserMember record);


}