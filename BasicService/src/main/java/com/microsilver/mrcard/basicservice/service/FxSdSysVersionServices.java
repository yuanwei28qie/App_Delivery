
package com.microsilver.mrcard.basicservice.service;

import java.util.List;

import com.microsilver.mrcard.basicservice.dao.FxSdSysVersionMapper;
import com.microsilver.mrcard.basicservice.model.FxSdSysVersion;
import com.microsilver.mrcard.basicservice.model.FxSdSysVersionExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class FxSdSysVersionServices {
		
	@Resource
	private FxSdSysVersionMapper fxSdSysVersionMapper;

	public FxSdSysVersion checkVersion(Short appType, Short clientType) {
		FxSdSysVersionExample fxSdSysVersionExample = new FxSdSysVersionExample();
		fxSdSysVersionExample.createCriteria().andAppTypeEqualTo(appType).andClientTypeEqualTo(clientType);
		List<FxSdSysVersion> list = fxSdSysVersionMapper.selectByExample(fxSdSysVersionExample);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}
}
