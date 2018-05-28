package com.microsilver.mrcard.basicservice.service;

import com.microsilver.mrcard.basicservice.dao.FxSdUserDeliverinfoMapper;
import com.microsilver.mrcard.basicservice.dao.FxSdUserPreRegMapper;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverinfo;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverinfoExample;
import com.microsilver.mrcard.basicservice.model.FxSdUserPreReg;
import com.microsilver.mrcard.basicservice.model.FxSdUserPreRegExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SuperDeliveryService {

	@Resource
	private FxSdUserDeliverinfoMapper fxSdUserDeliverinfoMapper;
	@Resource
	private FxSdUserPreRegMapper fxSdUserPreRegMapper;

	@Transactional
	public int insertDelivery(FxSdUserDeliverinfo fxSdUserDeliverinfo) {
		
		return fxSdUserDeliverinfoMapper.insertReturnId(fxSdUserDeliverinfo);
	}

	@Transactional
	public FxSdUserDeliverinfo selectDeliveryBymobile(Long mobile) {
		FxSdUserDeliverinfoExample example = new FxSdUserDeliverinfoExample();
		example.createCriteria().andMobileEqualTo(mobile+"");
		List<FxSdUserDeliverinfo> list = fxSdUserDeliverinfoMapper
				.selectByExample(example);
		if (list.size() > 0) {

			return list.get(0);
		}
		return null;
	}

	public FxSdUserDeliverinfo selectDeliveryByRefereeMobile(String refereeMobile) {
		FxSdUserDeliverinfoExample fxSdUserDeliverinfoExample = new FxSdUserDeliverinfoExample();
		FxSdUserDeliverinfoExample.Criteria createCriteria = fxSdUserDeliverinfoExample.createCriteria();
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
		example.createCriteria().andMobileEqualTo(mobile+"");
		List<FxSdUserPreReg> list = fxSdUserPreRegMapper.selectByExample(example);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	
	public void updatePwd(FxSdUserDeliverinfo selectDeliveryBymobile, Long mobile) {
		FxSdUserDeliverinfoExample example = new FxSdUserDeliverinfoExample();
		example.createCriteria().andMobileEqualTo(mobile+"");
		fxSdUserDeliverinfoMapper.updateByExampleSelective(selectDeliveryBymobile, example);
	}

	
	public FxSdUserDeliverinfo selectUserBysuperDeliveryId(String superDeliveryId) {
		return  fxSdUserDeliverinfoMapper.selectByPrimaryKey(Long.parseLong(superDeliveryId));
		
	}

	
	public void updateAvatar(FxSdUserDeliverinfo superDelivery) {
		fxSdUserDeliverinfoMapper.updateByPrimaryKey(superDelivery);
		
	}

	public FxSdUserDeliverinfo selectDeliveryByMobileAndId(String mobile, String superDeliveryId) {
		FxSdUserDeliverinfoExample fxSdUserDeliverinfoExample = new FxSdUserDeliverinfoExample();
		FxSdUserDeliverinfoExample.Criteria createCriteria = fxSdUserDeliverinfoExample.createCriteria();
		createCriteria.andMobileEqualTo(mobile).andIdEqualTo(Long.parseLong(superDeliveryId));
		List<FxSdUserDeliverinfo> selectByExample = fxSdUserDeliverinfoMapper
				.selectByExample(fxSdUserDeliverinfoExample);
		if (selectByExample.size() > 0) {
			FxSdUserDeliverinfo fxSdUserDeliveryInfo = selectByExample.get(0);
			return fxSdUserDeliveryInfo;
		}

		return null;
	}

	public void updateToken(FxSdUserDeliverinfo selectDeliveryByMobile) {
		fxSdUserDeliverinfoMapper.updateByPrimaryKey(selectDeliveryByMobile);
	}

	public void updateDelivery(FxSdUserDeliverinfo delivery) {
		fxSdUserDeliverinfoMapper.updateByPrimaryKey(delivery);
	}
}
