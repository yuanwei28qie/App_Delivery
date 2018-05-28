
package com.microsilver.mrcard.basicservice.service;

import com.microsilver.mrcard.basicservice.dao.FxSdFinanceCustomerMapper;
import com.microsilver.mrcard.basicservice.dao.FxSdFinanceFlowMapper;
import com.microsilver.mrcard.basicservice.dao.FxSdWithdrawMapper;
import com.microsilver.mrcard.basicservice.model.FxSdFinanceCustomer;
import com.microsilver.mrcard.basicservice.model.FxSdFinanceCustomerExample;
import com.microsilver.mrcard.basicservice.model.FxSdFinanceFlow;
import com.microsilver.mrcard.basicservice.model.FxSdWithdraw;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class FinanceService {
	@Resource
	private  FxSdFinanceCustomerMapper fxSdFinanceCustomerMapper;
	@Resource
	private  FxSdFinanceFlowMapper fxSdFinanceFlowMapper;
	@Resource
	private FxSdWithdrawMapper fxSdWithdrawMapper;



	public void insertFinaceCustomer(FxSdFinanceCustomer customer) {
		fxSdFinanceCustomerMapper.insertIntoAndReturnId(customer);
	}

	public FxSdFinanceCustomer selectAccountByUserIdAndUserType(FxSdFinanceCustomer customer) {
		FxSdFinanceCustomerExample example = new FxSdFinanceCustomerExample();
		example.createCriteria().andMobileEqualTo(customer.getMobile()).andUserTypeEqualTo(customer.getUserType());
		List<FxSdFinanceCustomer> list = fxSdFinanceCustomerMapper.selectByExample(example);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public int updateFinance(FxSdFinanceCustomer delivery) {
		int i = fxSdFinanceCustomerMapper.updateByPrimaryKey(delivery);
		if(i==1){
			return 1;
		}
		return 0;
	}

	public void insertFinanceFlow(FxSdFinanceFlow flow) {
		fxSdFinanceFlowMapper.insert(flow);
	}

	public void insertFinanceWithdraw(FxSdWithdraw fxSdWithdraw) {
		fxSdWithdrawMapper.insertIntoReturnId(fxSdWithdraw);
	}

	public FxSdFinanceCustomer selectFinance(int i, String mobile) {
		FxSdFinanceCustomerExample example = new FxSdFinanceCustomerExample();
		example.createCriteria().andMobileEqualTo(mobile).andUserTypeEqualTo((byte)i);
		List<FxSdFinanceCustomer> list = fxSdFinanceCustomerMapper.selectByExample(example);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
