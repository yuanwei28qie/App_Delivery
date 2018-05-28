package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxDocument;
import com.microsilver.mrcard.basicservice.model.FxDocumentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxDocumentMapper {
    int countByExample(FxDocumentExample example);

    int deleteByExample(FxDocumentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxDocument record);

    int insertSelective(FxDocument record);

    List<FxDocument> selectByExample(FxDocumentExample example);

    FxDocument selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxDocument record, @Param("example") FxDocumentExample example);

    int updateByExample(@Param("record") FxDocument record, @Param("example") FxDocumentExample example);

    int updateByPrimaryKeySelective(FxDocument record);

    int updateByPrimaryKey(FxDocument record);
}