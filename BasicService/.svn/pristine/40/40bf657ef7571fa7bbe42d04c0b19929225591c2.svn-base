/**
 * 
 */
package com.microsilver.mrcard.basicservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsilver.mrcard.basicservice.dao.FxSdSysVersionMapper;
import com.microsilver.mrcard.basicservice.model.FxSdSysVersion;
import com.microsilver.mrcard.basicservice.model.FxSdSysVersionExample;

/**
 * 
 * @Name com.microsilver.mrcard.basicservice.service.FxSdSysVersionServices
 * @Description 
 * 
 * @Author huwei
 * @Version 2018年4月2日 下午2:57:50
 * @Copyright  Micro Silver-SuperDelivery
 *
 */
@Service
public class FxSdSysVersionServices {
		
	@Autowired
	private FxSdSysVersionMapper fxSdSysVersionMapper;
	
	public FxSdSysVersion CheackVersion(Integer appType,Boolean clientType) {
		
		FxSdSysVersionExample fxSdSysVersionExample = new FxSdSysVersionExample();
		fxSdSysVersionExample.createCriteria().andAppTypeEqualTo(appType).andClientTypeEqualTo(clientType.booleanValue());
		List<FxSdSysVersion> list = fxSdSysVersionMapper.selectByExample(fxSdSysVersionExample);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}
}
