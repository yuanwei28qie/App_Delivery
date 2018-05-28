package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxDocumentArticle;
import com.microsilver.mrcard.basicservice.model.FxDocumentArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxDocumentArticleMapper {
    int countByExample(FxDocumentArticleExample example);

    int deleteByExample(FxDocumentArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxDocumentArticle record);

    int insertSelective(FxDocumentArticle record);

    List<FxDocumentArticle> selectByExampleWithBLOBs(FxDocumentArticleExample example);

    List<FxDocumentArticle> selectByExample(FxDocumentArticleExample example);

    FxDocumentArticle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxDocumentArticle record, @Param("example") FxDocumentArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") FxDocumentArticle record, @Param("example") FxDocumentArticleExample example);

    int updateByExample(@Param("record") FxDocumentArticle record, @Param("example") FxDocumentArticleExample example);

    int updateByPrimaryKeySelective(FxDocumentArticle record);

    int updateByPrimaryKeyWithBLOBs(FxDocumentArticle record);

    int updateByPrimaryKey(FxDocumentArticle record);
}