
package com.microsilver.mrcard.basicservice.service;

import com.github.pagehelper.PageHelper;
import com.microsilver.mrcard.basicservice.dao.FxSdCarriageOrderMapper;
import com.microsilver.mrcard.basicservice.model.FxSdCarriageOrder;
import com.microsilver.mrcard.basicservice.model.FxSdCarriageOrderExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class OrderService {

	@Resource
	private FxSdCarriageOrderMapper fxSdCarriageOrderMapper;


	public  Byte selectOrderByDeliveryId(Long id) {
		FxSdCarriageOrderExample example = new FxSdCarriageOrderExample();
		example.createCriteria().andDeliverIdEqualTo(id);
		List<FxSdCarriageOrder> list = fxSdCarriageOrderMapper.selectByExample(example);
		if(list.size()>0) {
			return list.get(0).getStatus();
		}
		return null;
	}


	public List<FxSdCarriageOrder> selectOrderByMemberId(String id) {
		FxSdCarriageOrderExample example = new FxSdCarriageOrderExample();
		example.createCriteria().andMemberIdEqualTo(Long.parseLong(id));
		List<FxSdCarriageOrder> list = fxSdCarriageOrderMapper.selectByExample(example);
		if(list.size()>0) {
			return list;
		}
		return null;	
	}


	public FxSdCarriageOrder selectOrderByOrdersnAndMemberId(String memberId, String orderNumber) {
		FxSdCarriageOrderExample example = new FxSdCarriageOrderExample();
		example.createCriteria().andMemberIdEqualTo(Long.parseLong(memberId)).andOrdersnEqualTo(orderNumber);
		List<FxSdCarriageOrder> list = fxSdCarriageOrderMapper.selectByExample(example);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
		
	}


	
	public FxSdCarriageOrder selectOrderByOrdersn(String ordersn) {
		FxSdCarriageOrderExample example = new FxSdCarriageOrderExample();
		example.createCriteria().andOrdersnEqualTo(ordersn);
		List<FxSdCarriageOrder> list = fxSdCarriageOrderMapper.selectByExample(example);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
		
		
	}

	public List<FxSdCarriageOrder> selectOrderByPage(Byte status,long userId,Integer currentPage, Integer pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		FxSdCarriageOrderExample example = new	FxSdCarriageOrderExample();
		example.createCriteria().andMemberIdEqualTo(userId).andStatusEqualTo(status);
		//所有记录
		List<FxSdCarriageOrder> orderAll = fxSdCarriageOrderMapper.selectByExample(example);
		if(orderAll!=null){
			System.out.println(orderAll);
			return orderAll;
		}
		return null;
	}

	
	public void insertOrder(FxSdCarriageOrder order) {
		fxSdCarriageOrderMapper.insert(order);
		
	}


	public void insertIntoAndReturnId(FxSdCarriageOrder order) {
		fxSdCarriageOrderMapper.insertIntoAndReturnId(order);
	}

	public List<FxSdCarriageOrder> selectOrderByPageAndOrderByTime(Integer areaCode,Integer currentPage,Integer pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		FxSdCarriageOrderExample example = new FxSdCarriageOrderExample();
		example.setOrderByClause("create_time DESC");
		example.createCriteria().andAreaCodeEqualTo(areaCode).andStatusEqualTo((byte)2);
		List<FxSdCarriageOrder> orderAll = fxSdCarriageOrderMapper.selectByExample(example);
		if(orderAll!=null){
			return orderAll;
		}
		return null;
	}

	public List<FxSdCarriageOrder> selectAllOrderByPage(Byte status, long userIdLong, Integer currentPage, Integer pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		FxSdCarriageOrderExample example = new	FxSdCarriageOrderExample();
		example.createCriteria().andMemberIdEqualTo(userIdLong).andStatusNotEqualTo(status);
		example.setOrderByClause("create_time DESC,id ASC");
		//所有记录
		List<FxSdCarriageOrder> orderAll = fxSdCarriageOrderMapper.selectByExample(example);
		if(orderAll!=null){
			return orderAll;
		}
		return null;
	}

	public List<FxSdCarriageOrder> selectOrderLessByPage(Byte status,long userIdLong, Integer currentPage, Integer pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		FxSdCarriageOrderExample example = new	FxSdCarriageOrderExample();
		example.createCriteria().andMemberIdEqualTo(userIdLong).andStatusLessThan(status);
		//所有记录
		List<FxSdCarriageOrder> orderAll = fxSdCarriageOrderMapper.selectByExample(example);
		if(orderAll!=null){
			return orderAll;
		}
		return null;
	}

	public FxSdCarriageOrder selectOrderByOrderIdAndOrderSn(Integer orderId, Long orderSn) {
		FxSdCarriageOrderExample example = new FxSdCarriageOrderExample();
		example.createCriteria().andOrdersnEqualTo(orderSn+"").andIdEqualTo(orderId.longValue());
		List<FxSdCarriageOrder> list = fxSdCarriageOrderMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public int updateOrder(FxSdCarriageOrder order) {
		int i = fxSdCarriageOrderMapper.updateByPrimaryKey(order);
		if(i==1){
			return i;
		}
		return 0;
	}

	public FxSdCarriageOrder selectOrderByOrderIdAndOrderSnAndDeliveryId(Integer orderId, Long orderSn, Integer deliveryId) {
		FxSdCarriageOrderExample example = new FxSdCarriageOrderExample();
		example.createCriteria().andOrdersnEqualTo(orderSn+"").andIdEqualTo(orderId.longValue()).andDeliverIdEqualTo(deliveryId.longValue());
		List<FxSdCarriageOrder> list = fxSdCarriageOrderMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public FxSdCarriageOrder selectOrderByOrderSn(Long outTradeNo) {
		FxSdCarriageOrderExample example = new FxSdCarriageOrderExample();
		example.createCriteria().andOrdersnEqualTo(outTradeNo+"");
		List<FxSdCarriageOrder> list = fxSdCarriageOrderMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public FxSdCarriageOrder selectOrderByOrderId(Integer orderId) {
		FxSdCarriageOrderExample example = new FxSdCarriageOrderExample();
		example.createCriteria().andIdEqualTo(orderId.longValue());
		List<FxSdCarriageOrder> list = fxSdCarriageOrderMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public int selectOrderCountByUserId(Integer userId) {
		FxSdCarriageOrderExample example = new FxSdCarriageOrderExample();
		example.createCriteria().andMemberIdEqualTo(userId.longValue());
		int i = fxSdCarriageOrderMapper.countByExample(example);
		if(i!=-1){
			return i;
		}
		return -1;
	}
	public int selectOrderCountByDeliveryId(Integer deliveryId) {
		FxSdCarriageOrderExample example = new FxSdCarriageOrderExample();
		example.createCriteria().andDeliverIdEqualTo(deliveryId.longValue());
		int i = fxSdCarriageOrderMapper.countByExample(example);
		if(i!=-1){
			return i;
		}
		return -1;
	}

	public List<FxSdCarriageOrder> selectOrderByDelivery(long l) {
		FxSdCarriageOrderExample example = new FxSdCarriageOrderExample();
		example.createCriteria().andDeliverIdEqualTo(l);
		List<FxSdCarriageOrder> list = fxSdCarriageOrderMapper.selectByExample(example);
		if(list.size()>0){
			return list;
		}
		return null;

	}

	public List<FxSdCarriageOrder> selectOrderByPageOfDeliveryId(int currentPage, int pageSize, Integer deliveryId,Integer areaCode) {
		PageHelper.startPage(currentPage, pageSize);
		FxSdCarriageOrderExample example = new	FxSdCarriageOrderExample();
		example.createCriteria().andDeliverIdEqualTo(deliveryId.longValue()).andAreaCodeEqualTo(areaCode);
		example.setOrderByClause("create_time DESC");
		//所有记录
		List<FxSdCarriageOrder> orderAll = fxSdCarriageOrderMapper.selectByExample(example);
		if(orderAll!=null){
			return orderAll;
		}
		return null;
	}

	public List<FxSdCarriageOrder> selectOrderPageByUser(long userIdLong, Integer currentPage, Integer pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		FxSdCarriageOrderExample example = new	FxSdCarriageOrderExample();
		example.createCriteria().andMemberIdEqualTo(userIdLong);
		example.setOrderByClause("create_time DESC");
		//所有记录
		List<FxSdCarriageOrder> orderAll = fxSdCarriageOrderMapper.selectByExample(example);
		if(orderAll!=null){
			return orderAll;
		}
		return null;
	}

	public List<FxSdCarriageOrder> selectAllOrder() {
		FxSdCarriageOrderExample example = new	FxSdCarriageOrderExample();
		example.createCriteria().andStatusEqualTo((byte)7);
		List<FxSdCarriageOrder> orderAll = fxSdCarriageOrderMapper.selectByExample(example);
		if(orderAll!=null){
			return orderAll;
		}
		return null;
	}


}
