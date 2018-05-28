package com.microsilver.mrcard.basicservice.service;


import com.microsilver.mrcard.basicservice.dao.FxSdSysCarriageDispatchMapper;
import com.microsilver.mrcard.basicservice.model.FxSdSysCarriageDispatch;
import com.microsilver.mrcard.basicservice.model.FxSdSysCarriageDispatchExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserCarriageDispatchService {
			
	@Resource
	private FxSdSysCarriageDispatchMapper fxSdSysCarriageDispatchMapper;


	public FxSdSysCarriageDispatch selectDispatchByAreaId(String areaId) {
		FxSdSysCarriageDispatchExample example = new FxSdSysCarriageDispatchExample();
		example.createCriteria().andAreaCodeEqualTo(Integer.valueOf(areaId));
		List<FxSdSysCarriageDispatch> list = fxSdSysCarriageDispatchMapper.selectByExample(example);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
	
}
