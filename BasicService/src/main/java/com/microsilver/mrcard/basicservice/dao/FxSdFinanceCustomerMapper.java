package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxSdFinanceCustomer;
import com.microsilver.mrcard.basicservice.model.FxSdFinanceCustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxSdFinanceCustomerMapper {
    int countByExample(FxSdFinanceCustomerExample example);

    int deleteByExample(FxSdFinanceCustomerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FxSdFinanceCustomer record);

    int insertSelective(FxSdFinanceCustomer record);

    List<FxSdFinanceCustomer> selectByExample(FxSdFinanceCustomerExample example);

    FxSdFinanceCustomer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FxSdFinanceCustomer record, @Param("example") FxSdFinanceCustomerExample example);

    int updateByExample(@Param("record") FxSdFinanceCustomer record, @Param("example") FxSdFinanceCustomerExample example);

    int updateByPrimaryKeySelective(FxSdFinanceCustomer record);

    int updateByPrimaryKey(FxSdFinanceCustomer record);

    int insertIntoAndReturnId(FxSdFinanceCustomer customer);
}