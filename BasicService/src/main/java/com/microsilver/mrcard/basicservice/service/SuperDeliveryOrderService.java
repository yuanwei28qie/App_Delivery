
package com.microsilver.mrcard.basicservice.service;

import javax.annotation.Resource;

import com.microsilver.mrcard.basicservice.dao.FxSdUserDeliverAdditionalMapper;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverAdditional;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverAdditionalExample;
import org.springframework.stereotype.Service;

import com.microsilver.mrcard.basicservice.core.exception.BusinessException;
import com.microsilver.mrcard.basicservice.model.enums.EWarning;

import java.util.List;


@Service
public class SuperDeliveryOrderService {
	
	@Resource
	private FxSdUserDeliverAdditionalMapper fxSdUserDeliverAdditionalMapper;
	
	public FxSdUserDeliverAdditional isWork(Long superDeliveryId, Byte isWork) {
		if(superDeliveryId == null || isWork == null){
			throw new BusinessException(EWarning.ErrorParams);
		}
		FxSdUserDeliverAdditionalExample example = new FxSdUserDeliverAdditionalExample();
		example.createCriteria().andDeliverIdEqualTo(superDeliveryId);
		List<FxSdUserDeliverAdditional> list = fxSdUserDeliverAdditionalMapper.selectByExample(example);
		if(list!=null){
			return list.get(0);
		}
		return null;
	}

	
	public void insertfxSdUserDeliverAdditional(FxSdUserDeliverAdditional fxSdUserDeliverAdditional) {
		fxSdUserDeliverAdditionalMapper.insert(fxSdUserDeliverAdditional);
	}

	public void updateDeliveryAdditionalIsWork(FxSdUserDeliverAdditional work) {

		fxSdUserDeliverAdditionalMapper.updateByPrimaryKey(work);

	}

	public FxSdUserDeliverAdditional selectDeliveryInfo(Integer deliveryId) {
		FxSdUserDeliverAdditionalExample example = new FxSdUserDeliverAdditionalExample();
		example.createCriteria().andDeliverIdEqualTo(deliveryId.longValue());
		List<FxSdUserDeliverAdditional> list = fxSdUserDeliverAdditionalMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
