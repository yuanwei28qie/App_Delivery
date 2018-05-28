package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxFile;
import com.microsilver.mrcard.basicservice.model.FxFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxFileMapper {
    int countByExample(FxFileExample example);

    int deleteByExample(FxFileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxFile record);

    int insertSelective(FxFile record);

    List<FxFile> selectByExample(FxFileExample example);

    FxFile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxFile record, @Param("example") FxFileExample example);

    int updateByExample(@Param("record") FxFile record, @Param("example") FxFileExample example);

    int updateByPrimaryKeySelective(FxFile record);

    int updateByPrimaryKey(FxFile record);
}