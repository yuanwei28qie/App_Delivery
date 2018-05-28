package com.microsilver.mrcard.basicservice.dao;

import com.microsilver.mrcard.basicservice.model.FxPicture;
import com.microsilver.mrcard.basicservice.model.FxPictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FxPictureMapper {
    int countByExample(FxPictureExample example);

    int deleteByExample(FxPictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FxPicture record);

    int insertSelective(FxPicture record);

    List<FxPicture> selectByExample(FxPictureExample example);

    FxPicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FxPicture record, @Param("example") FxPictureExample example);

    int updateByExample(@Param("record") FxPicture record, @Param("example") FxPictureExample example);

    int updateByPrimaryKeySelective(FxPicture record);

    int updateByPrimaryKey(FxPicture record);
}