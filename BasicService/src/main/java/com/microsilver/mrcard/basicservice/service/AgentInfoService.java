package com.microsilver.mrcard.basicservice.service;

import com.microsilver.mrcard.basicservice.dao.FxSdUserAgentinfoMapper;
import com.microsilver.mrcard.basicservice.model.FxSdUserAgentinfo;
import com.microsilver.mrcard.basicservice.model.FxSdUserAgentinfoExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AgentInfoService {
	@Resource
	private FxSdUserAgentinfoMapper fxSdUserAgentinfoMapper;

	public FxSdUserAgentinfo selectAgentByAreaCode(Integer areaCode) {
		FxSdUserAgentinfoExample example = new FxSdUserAgentinfoExample();
		example.createCriteria().andCountyEqualTo(areaCode);
		List<FxSdUserAgentinfo> list = fxSdUserAgentinfoMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
