package com.microsilver.mrcard.basicservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microsilver.mrcard.basicservice.dao.FxSdUserDeliverinfoMapper;
import com.microsilver.mrcard.basicservice.dao.FxSdUserPreRegMapper;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverAdditionalExample;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverinfo;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverinfoExample;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverinfoExample.Criteria;
import com.microsilver.mrcard.basicservice.model.FxSdUserPreReg;
import com.microsilver.mrcard.basicservice.model.FxSdUserPreRegExample;
import com.microsilver.mrcard.basicservice.service.SuperDeliveryService;

@Service
public class SuperDeliveryService {

	@Autowired
	private FxSdUserDeliverinfoMapper fxSdUserDeliverinfoMapper;
	@Autowired
	private FxSdUserPreRegMapper fxSdUserPreRegMapper;

	@Transactional
	public void insertDelivery(FxSdUserDeliverinfo fxSdUserDeliverinfo) {
		System.out.println(fxSdUserDeliverinfo.toString());
		fxSdUserDeliverinfoMapper.insert(fxSdUserDeliverinfo);
	}

	@Transactional
	public FxSdUserDeliverinfo selectDeliveryBymobile(String mobile) {
		FxSdUserDeliverinfoExample fxSdUserDeliverinfoExample = new FxSdUserDeliverinfoExample();
		Criteria createCriteria = fxSdUserDeliverinfoExample.createCriteria();
		createCriteria.andMobileLike(mobile);
		List<FxSdUserDeliverinfo> selectByExample = fxSdUserDeliverinfoMapper
				.selectByExample(fxSdUserDeliverinfoExample);
		if (selectByExample.size() > 0) {
			FxSdUserDeliverinfo fxSdUserDeliverinfo = selectByExample.get(0);
			return fxSdUserDeliverinfo;
		}
		return null;
	}

	public FxSdUserDeliverinfo selectDeliveryByRefereeMobile(String refereeMobile) {
		FxSdUserDeliverinfoExample fxSdUserDeliverinfoExample = new FxSdUserDeliverinfoExample();
		Criteria createCriteria = fxSdUserDeliverinfoExample.createCriteria();
		createCriteria.andMobileEqualTo(refereeMobile);
		List<FxSdUserDeliverinfo> selectByExample = fxSdUserDeliverinfoMapper
				.selectByExample(fxSdUserDeliverinfoExample);
		if (selectByExample.size() > 0) {
			FxSdUserDeliverinfo fxSdUserDeliverinfo = selectByExample.get(0);
			return fxSdUserDeliverinfo;
		}

		return null;
	}

	public void updatePwd(FxSdUserDeliverinfo info) {

		fxSdUserDeliverinfoMapper.updateByPrimaryKeySelective(info);
	}

	public void updateSuperDelivery(FxSdUserDeliverinfo info,Long id) {

		FxSdUserDeliverinfoExample example = new FxSdUserDeliverinfoExample();
		example.createCriteria().andIdEqualTo(id);

		fxSdUserDeliverinfoMapper.updateByExampleSelective(info, example);
	}

	public FxSdUserPreReg checkIsInvitation(long mobile) {
		FxSdUserPreRegExample example = new FxSdUserPreRegExample();
		example.createCriteria().andMobileEqualTo(mobile);
		List<FxSdUserPreReg> list = fxSdUserPreRegMapper.selectByExample(example);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	
	public void updatePwd(FxSdUserDeliverinfo selectDeliveryBymobile, String mobile) {
		FxSdUserDeliverinfoExample example = new FxSdUserDeliverinfoExample();
		example.createCriteria().andMobileEqualTo(mobile);
		fxSdUserDeliverinfoMapper.updateByExampleSelective(selectDeliveryBymobile, example);
	}

	
	public FxSdUserDeliverinfo selectUserBysuperDeliveryId(String superDeliveryId) {
		return  fxSdUserDeliverinfoMapper.selectByPrimaryKey(Long.parseLong(superDeliveryId));
		
	}

	
	public void updateAvatar(FxSdUserDeliverinfo superDelivery) {
		fxSdUserDeliverinfoMapper.updateByPrimaryKey(superDelivery);
		
	}

}
