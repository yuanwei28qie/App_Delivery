package com.microsilver.mrcard.basicservice.service;

import com.microsilver.mrcard.basicservice.dao.FxSdSysLevelsettingMapper;
import com.microsilver.mrcard.basicservice.model.FxSdSysLevelsetting;
import com.microsilver.mrcard.basicservice.model.FxSdSysLevelsettingExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LevelService {
	@Resource
	private FxSdSysLevelsettingMapper fxSdSysLevelsettingMapper;


	public FxSdSysLevelsetting selectByUserId(Integer userId) {
		FxSdSysLevelsettingExample example = new FxSdSysLevelsettingExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<FxSdSysLevelsetting> list = fxSdSysLevelsettingMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public void updateLevel(FxSdSysLevelsetting level) {
		fxSdSysLevelsettingMapper.updateByPrimaryKey(level);
	}

	public void insertInto(FxSdSysLevelsetting levelSetting) {
		fxSdSysLevelsettingMapper.insert(levelSetting);
	}

	public FxSdSysLevelsetting selectByDliveryId(Integer deliveryId) {
		FxSdSysLevelsettingExample example = new FxSdSysLevelsettingExample();
		example.createCriteria().andDeliveryIdEqualTo(deliveryId);
		List<FxSdSysLevelsetting> list = fxSdSysLevelsettingMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
