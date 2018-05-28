package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxAttachment;
import com.microsilver.mrcard.basicservice.model.FxAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxAttachmentMapper {
    int countByExample(FxAttachmentExample example);

    int deleteByExample(FxAttachmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxAttachment record);

    int insertSelective(FxAttachment record);

    List<FxAttachment> selectByExample(FxAttachmentExample example);

    FxAttachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxAttachment record, @Param("example") FxAttachmentExample example);

    int updateByExample(@Param("record") FxAttachment record, @Param("example") FxAttachmentExample example);

    int updateByPrimaryKeySelective(FxAttachment record);

    int updateByPrimaryKey(FxAttachment record);
}