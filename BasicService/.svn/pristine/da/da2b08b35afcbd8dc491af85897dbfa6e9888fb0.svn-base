/**
 * 
 */
package com.microsilver.mrcard.basicservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsilver.mrcard.basicservice.dao.FxSdSysCarriageDispatchMapper;
import com.microsilver.mrcard.basicservice.model.FxSdSysCarriageDispatch;
import com.microsilver.mrcard.basicservice.model.FxSdSysCarriageDispatchExample;

/**
 * 
 * @Name com.microsilver.mrcard.basicservice.service.UserCarriageDispatch
 * @Description 
 * 
 * @Author huwei
 * @Version 2018年4月8日 下午5:15:46
 * @Copyright  Micro Silver-SuperDelivery
 *
 */
@Service
public class UserCarriageDispatchService {
			
	@Autowired
	private FxSdSysCarriageDispatchMapper fxSdSysCarriageDispatchMapper;


	public FxSdSysCarriageDispatch selectDispatchByAreaId(String areaId) {
		FxSdSysCarriageDispatchExample example = new FxSdSysCarriageDispatchExample();
		example.createCriteria().andAreaCodeEqualTo(Long.parseLong(areaId));
		List<FxSdSysCarriageDispatch> list = fxSdSysCarriageDispatchMapper.selectByExample(example);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
	
}
