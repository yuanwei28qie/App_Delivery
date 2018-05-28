package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxUcenterMember;
import com.microsilver.mrcard.basicservice.model.FxUcenterMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxUcenterMemberMapper {
    int countByExample(FxUcenterMemberExample example);

    int deleteByExample(FxUcenterMemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxUcenterMember record);

    int insertSelective(FxUcenterMember record);

    List<FxUcenterMember> selectByExample(FxUcenterMemberExample example);

    FxUcenterMember selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxUcenterMember record, @Param("example") FxUcenterMemberExample example);

    int updateByExample(@Param("record") FxUcenterMember record, @Param("example") FxUcenterMemberExample example);

    int updateByPrimaryKeySelective(FxUcenterMember record);

    int updateByPrimaryKey(FxUcenterMember record);
}