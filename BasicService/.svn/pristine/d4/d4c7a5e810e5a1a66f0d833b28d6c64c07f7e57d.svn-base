package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxSdUserAddress;
import com.microsilver.mrcard.basicservice.model.FxSdUserAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxSdUserAddressMapper {
    int countByExample(FxSdUserAddressExample example);

    int deleteByExample(FxSdUserAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxSdUserAddress record);

    int insertSelective(FxSdUserAddress record);

    List<FxSdUserAddress> selectByExample(FxSdUserAddressExample example);

    FxSdUserAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxSdUserAddress record, @Param("example") FxSdUserAddressExample example);

    int updateByExample(@Param("record") FxSdUserAddress record, @Param("example") FxSdUserAddressExample example);

    int updateByPrimaryKeySelective(FxSdUserAddress record);

    int updateByPrimaryKey(FxSdUserAddress record);
}