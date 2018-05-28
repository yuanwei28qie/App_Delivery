/**
 * 
 */
package com.microsilver.mrcard.basicservice.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microsilver.mrcard.basicservice.core.exception.BusinessException;
import com.microsilver.mrcard.basicservice.dao.FxSdUserDeliverAdditionalMapper;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverAdditional;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverAdditionalExample;
import com.microsilver.mrcard.basicservice.model.enums.EWarning;

/**
 * 
 * @Name com.microsilver.mrcard.basicservice.service.SuperDeliveryOrderService
 * @Description 
 * 
 * @Author huwei
 * @Version 2018年3月28日 下午3:17:50
 * @Copyright  Micro Silver-SuperDelivery
 *
 */
@Service
public class SuperDeliveryOrderService {
	
	@Resource
	private  FxSdUserDeliverAdditionalMapper fxSdUserDeliverAdditionalMapper;
	
	public int isWork(Long superDeliveryId, Boolean isWork) {
		if(superDeliveryId == null || isWork == null){
			throw new BusinessException(EWarning.ErrorParams);
		}
		FxSdUserDeliverAdditionalExample example = new FxSdUserDeliverAdditionalExample();
		example.createCriteria().andDeliverIdEqualTo(superDeliveryId);
		FxSdUserDeliverAdditional additional =  new FxSdUserDeliverAdditional();
		additional.setIsWork(isWork);
		int result = fxSdUserDeliverAdditionalMapper.updateByExampleSelective(additional, example);
		return result;
	}
	
}
