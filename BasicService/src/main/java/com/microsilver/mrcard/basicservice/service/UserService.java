
package com.microsilver.mrcard.basicservice.service;

import java.util.List;

import com.microsilver.mrcard.basicservice.dao.*;
import com.microsilver.mrcard.basicservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService {

	private final FxSdUserMemberMapper fxSdUserMemberMapper;
	private final FxSdUserPreRegMapper fxSdUserPreRegMapper;
	private final FxSdUserAddressMapper fxSdUserAddressMapper;
	private final FxSdUserDeliverAdditionalMapper fxSdUserDeliverAdditionalMapper;
	
	private final FxSdFinanceCustomerMapper fxSdFinanceCustomerMapper;

	@Autowired
	public UserService(FxSdUserMemberMapper fxSdUserMemberMapper, FxSdUserPreRegMapper fxSdUserPreRegMapper, FxSdUserAddressMapper fxSdUserAddressMapper, FxSdUserDeliverAdditionalMapper fxSdUserDeliverAdditionalMapper, FxSdFinanceCustomerMapper fxSdFinanceCustomerMapper) {
		this.fxSdUserMemberMapper = fxSdUserMemberMapper;
		this.fxSdUserPreRegMapper = fxSdUserPreRegMapper;
		this.fxSdUserAddressMapper = fxSdUserAddressMapper;
		this.fxSdUserDeliverAdditionalMapper = fxSdUserDeliverAdditionalMapper;
		this.fxSdFinanceCustomerMapper = fxSdFinanceCustomerMapper;
	}

	public FxSdUserMember selectUserByMobile(String mobile) {
		FxSdUserMemberExample fxSdUserMemberExample = new FxSdUserMemberExample();
		FxSdUserMemberExample.Criteria createCriteria = fxSdUserMemberExample.createCriteria();
		createCriteria.andMobileLike(mobile);
		List<FxSdUserMember> selectByExample = fxSdUserMemberMapper.selectByExample(fxSdUserMemberExample);
		if (selectByExample.size() > 0) {
			return selectByExample.get(0);
		}
		return null;
	}

	public void insertUser(FxSdUserMember info) {
		fxSdUserMemberMapper.insert(info);
	}

	public void updatePwd(FxSdUserMember selectUserByMobile,String mobile) {
		FxSdUserMemberExample example = new FxSdUserMemberExample();
		example.createCriteria().andMobileEqualTo(mobile);
		fxSdUserMemberMapper.updateByExampleSelective(selectUserByMobile, example);
	}

	public FxSdUserPreReg checkIsInvitation(Long mobile) {
		FxSdUserPreRegExample example = new FxSdUserPreRegExample();
		example.createCriteria().andMobileEqualTo(mobile+"");
		List<FxSdUserPreReg> list = fxSdUserPreRegMapper.selectByExample(example);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public void updateStatus(String refereeId, FxSdUserMember fxSdUserMember) {
		FxSdUserMemberExample example = new FxSdUserMemberExample();
		example.createCriteria().andMobileEqualTo(fxSdUserMember.getMobile());
		fxSdUserMember.setReferee(Long.parseLong(refereeId));
		fxSdUserMemberMapper.updateByExampleSelective(fxSdUserMember, example);
	}

	public FxSdUserMember selectUserByUserId(String userId) {
		return fxSdUserMemberMapper.selectByPrimaryKey(Long.parseLong(userId));
	}

	
	public void updatePhone(FxSdUserMember selectUserByMobile, String oldPhoneNumber) {
		FxSdUserMemberExample example = new FxSdUserMemberExample();
		example.createCriteria().andMobileEqualTo(oldPhoneNumber);
		fxSdUserMemberMapper.updateByExampleSelective(selectUserByMobile, example);
	}

	
	public int selectUserAddressByUserId(Long id) {
		FxSdUserAddressExample example = new FxSdUserAddressExample();
		example.createCriteria().andMemberIdEqualTo(id);
		return  fxSdUserAddressMapper.countByExample(example);
	}

	
	public void updateAddress(FxSdUserAddress fxSdUserAddress, Integer addressId) {
		FxSdUserAddressExample example = new FxSdUserAddressExample();
		example.createCriteria().andIdEqualTo(Integer.valueOf(addressId));
		fxSdUserAddressMapper.updateByExampleSelective(fxSdUserAddress, example);
	}
	public void insertAddress(FxSdUserAddress fxSdUserAddress) {
		fxSdUserAddressMapper.insert(fxSdUserAddress);

	}

	
	public void deleteAddress(String addressId) {
		fxSdUserAddressMapper.deleteByPrimaryKey(Integer.valueOf(addressId));
	}


	public List<FxSdUserAddress> selectUserAllAddress(String memberId) {
		FxSdUserAddressExample example = new FxSdUserAddressExample();
		example.createCriteria().andMemberIdEqualTo(Long.parseLong(memberId));
		List<FxSdUserAddress> list = fxSdUserAddressMapper.selectByExample(example);
		if(list.size()>0) {
			return list;
		}
		return null;
	}

	
	public void updateAvatar(FxSdUserMember user) {
		fxSdUserMemberMapper.updateByPrimaryKey(user);
	}
	
	public long getIdentityId(FxSdUserMember user) {
		
		return fxSdUserMemberMapper.insertIntoAndReturnId(user);
	}

	public FxSdUserAddress selectMemberAddress(String memberId, String addressId) {
		
		FxSdUserAddressExample example = new FxSdUserAddressExample();
		example.createCriteria().andMemberIdEqualTo(Long.parseLong(memberId)).andIdEqualTo(Integer.parseInt(addressId));
		List<FxSdUserAddress> list = fxSdUserAddressMapper.selectByExample(example);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	public List<FxSdUserAddress> selectUserByMemberIdAndNotId(String memberId, String addressId) {
		FxSdUserAddressExample example = new FxSdUserAddressExample();
		example.createCriteria().andMemberIdEqualTo(Long.parseLong(memberId)).andIdNotEqualTo(Integer.valueOf(addressId));
		List<FxSdUserAddress> list = fxSdUserAddressMapper.selectByExample(example);
		if(list.size()>0) {
			return list;
		}
		return null;
	}

	public void updateNickName(FxSdUserMember user) {
		fxSdUserMemberMapper.updateByPrimaryKey(user);
	}

	public void insertReturnId(FxSdUserAddress fxSdUserAddress) {
		fxSdUserAddressMapper.insertReturnId(fxSdUserAddress);
	}

	public void updateToken(FxSdUserMember selectUserByMobile) {
		fxSdUserMemberMapper.updateByPrimaryKey(selectUserByMobile);
	}

	public void updateUser(FxSdUserMember user) {
		fxSdUserMemberMapper.updateByPrimaryKey(user);
	}
}
