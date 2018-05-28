package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxMember;
import com.microsilver.mrcard.basicservice.model.FxMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxMemberMapper {
    int countByExample(FxMemberExample example);

    int deleteByExample(FxMemberExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(FxMember record);

    int insertSelective(FxMember record);

    List<FxMember> selectByExample(FxMemberExample example);

    FxMember selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") FxMember record, @Param("example") FxMemberExample example);

    int updateByExample(@Param("record") FxMember record, @Param("example") FxMemberExample example);

    int updateByPrimaryKeySelective(FxMember record);

    int updateByPrimaryKey(FxMember record);
}