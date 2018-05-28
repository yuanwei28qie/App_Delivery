package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxModel;
import com.microsilver.mrcard.basicservice.model.FxModelExample;
import com.microsilver.mrcard.basicservice.model.FxModelWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxModelMapper {
    int countByExample(FxModelExample example);

    int deleteByExample(FxModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxModelWithBLOBs record);

    int insertSelective(FxModelWithBLOBs record);

    List<FxModelWithBLOBs> selectByExampleWithBLOBs(FxModelExample example);

    List<FxModel> selectByExample(FxModelExample example);

    FxModelWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxModelWithBLOBs record, @Param("example") FxModelExample example);

    int updateByExampleWithBLOBs(@Param("record") FxModelWithBLOBs record, @Param("example") FxModelExample example);

    int updateByExample(@Param("record") FxModel record, @Param("example") FxModelExample example);

    int updateByPrimaryKeySelective(FxModelWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(FxModelWithBLOBs record);

    int updateByPrimaryKey(FxModel record);
}