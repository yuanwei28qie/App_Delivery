/**
 * 
 */
package com.microsilver.mrcard.basicservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsilver.mrcard.basicservice.dao.FxSdPicturemd5Mapper;
import com.microsilver.mrcard.basicservice.model.FxSdPicturemd5;
import com.microsilver.mrcard.basicservice.model.FxSdPicturemd5Example;

/**
 * 
 * @Name com.microsilver.mrcard.basicservice.service.PictureMd5Service
 * @Description 
 * 
 * @Author huwei
 * @Version 2018年4月5日 下午12:00:24
 * @Copyright  Micro Silver-SuperDelivery
 *
 */
@Service
public class PictureMd5Service {
		@Autowired
		private FxSdPicturemd5Mapper fxSdPicturemd5Mapper;

		public List<FxSdPicturemd5> selectPicture() {
			FxSdPicturemd5Example example = new FxSdPicturemd5Example();
			List<FxSdPicturemd5> list = fxSdPicturemd5Mapper.selectByExample(example);
			if(list.size()>0) {
				return list;
			}
			return null;
		}

		public void insert(FxSdPicturemd5 md5) {
			fxSdPicturemd5Mapper.insertSelective(md5);
		}

		
		public void update(FxSdPicturemd5 fxSdPicturemd5) {
			FxSdPicturemd5Example example = new FxSdPicturemd5Example();
			example.createCriteria().andIdEqualTo(fxSdPicturemd5.getId());
			fxSdPicturemd5Mapper.updateByExampleSelective(fxSdPicturemd5, example);
		}
		
}
