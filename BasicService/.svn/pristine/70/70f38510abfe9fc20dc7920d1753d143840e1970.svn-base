/**
 * 
 */
package com.microsilver.mrcard.basicservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsilver.mrcard.basicservice.dao.FxSdUserDeliverAdditionalMapper;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverAdditional;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverAdditionalExample;

/**
 * 
 * @Name com.microsilver.mrcard.basicservice.service.UserInfoService
 * @Description 
 * 
 * @Author huwei
 * @Version 2018年4月4日 上午11:59:14
 * @Copyright  Micro Silver-SuperDelivery
 *
 */
@Service
public class SupserDeliveryInfoService {

	@Autowired
	private  FxSdUserDeliverAdditionalMapper fxSdUserDeliverAdditionalMapper;
	public FxSdUserDeliverAdditional selectInfoByDelivery(Long id) {
		FxSdUserDeliverAdditionalExample example = new FxSdUserDeliverAdditionalExample();
		example.createCriteria().andDeliverIdEqualTo(id);
		List<FxSdUserDeliverAdditional> list = fxSdUserDeliverAdditionalMapper.selectByExample(example);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
	public List<FxSdUserDeliverAdditional> selectSuperDelivery() {
		FxSdUserDeliverAdditionalExample example = new FxSdUserDeliverAdditionalExample();
		List<FxSdUserDeliverAdditional> list = fxSdUserDeliverAdditionalMapper.selectByExample(example);
		if(list.size()>0) {
			return list;
		}
			return null;
	}
	
	
	
}
