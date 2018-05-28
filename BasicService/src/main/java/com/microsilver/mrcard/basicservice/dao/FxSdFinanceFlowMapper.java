package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxSdFinanceFlow;
import com.microsilver.mrcard.basicservice.model.FxSdFinanceFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxSdFinanceFlowMapper {
    int countByExample(FxSdFinanceFlowExample example);

    int deleteByExample(FxSdFinanceFlowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FxSdFinanceFlow record);

    int insertSelective(FxSdFinanceFlow record);

    List<FxSdFinanceFlow> selectByExample(FxSdFinanceFlowExample example);

    FxSdFinanceFlow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FxSdFinanceFlow record, @Param("example") FxSdFinanceFlowExample example);

    int updateByExample(@Param("record") FxSdFinanceFlow record, @Param("example") FxSdFinanceFlowExample example);

    int updateByPrimaryKeySelective(FxSdFinanceFlow record);

    int updateByPrimaryKey(FxSdFinanceFlow record);
}