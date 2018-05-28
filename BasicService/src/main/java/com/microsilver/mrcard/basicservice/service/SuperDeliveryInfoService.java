
package com.microsilver.mrcard.basicservice.service;

import java.util.List;

import com.microsilver.mrcard.basicservice.dao.FxSdUserDeliverAdditionalMapper;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverAdditional;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverAdditionalExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SuperDeliveryInfoService {

	private final FxSdUserDeliverAdditionalMapper fxSdUserDeliverAdditionalMapper;

	@Autowired
	public SuperDeliveryInfoService(FxSdUserDeliverAdditionalMapper fxSdUserDeliverAdditionalMapper) {
		this.fxSdUserDeliverAdditionalMapper = fxSdUserDeliverAdditionalMapper;
	}

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


	public void updateDeliveryWork(FxSdUserDeliverAdditional deliveryWork) {
		fxSdUserDeliverAdditionalMapper.updateByPrimaryKey(deliveryWork);
	}
}
