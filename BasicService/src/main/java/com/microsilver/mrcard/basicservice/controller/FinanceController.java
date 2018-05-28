package com.microsilver.mrcard.basicservice.controller;


import com.microsilver.mrcard.basicservice.dto.DeliveryBalanceDto;
import com.microsilver.mrcard.basicservice.dto.FinanceDto;
import com.microsilver.mrcard.basicservice.dto.RespBaseDto;
import com.microsilver.mrcard.basicservice.model.FxSdCarriageOrder;
import com.microsilver.mrcard.basicservice.model.FxSdFinanceCustomer;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverinfo;
import com.microsilver.mrcard.basicservice.model.enums.EWarning;
import com.microsilver.mrcard.basicservice.service.FinanceService;
import com.microsilver.mrcard.basicservice.service.OrderService;
import com.microsilver.mrcard.basicservice.service.SuperDeliveryService;
import com.microsilver.mrcard.basicservice.utils.DateUnixTimeUtils;
import com.microsilver.mrcard.basicservice.vo.DeliveryGetInfoVo;
import com.microsilver.mrcard.basicservice.vo.FinanceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Api(value = "/api/finance", description = "财务API")
@Controller
@RequestMapping(value = "/api/finance")
@SuppressWarnings("unchecked")
@Transactional
public class FinanceController extends BaseController {

    private final FinanceService financeService;
	private final SuperDeliveryService superDeliveryService;
	private final OrderService orderService;

	@Autowired
	public FinanceController(FinanceService financeService, SuperDeliveryService superDeliveryService, OrderService orderService) {
		this.financeService = financeService;
		this.superDeliveryService = superDeliveryService;
		this.orderService = orderService;
	}


	@ApiOperation(value = "新增财务账号", httpMethod = "POST")
    @PostMapping(value = "/addAccount",produces ="application/json;charset=UTF-8")
    @ResponseBody
    public RespBaseDto<FinanceDto> addAccount(
            @RequestBody FinanceVo financeVo
    ) {
        RespBaseDto<FinanceDto> result = new RespBaseDto<>();
        FinanceDto financeDto = new FinanceDto();
        Integer userId = financeVo.getUserId();
        Short userType =financeVo.getUserType();
        try {
            if (userId != null && userType != null) {
                FxSdFinanceCustomer customer = new FxSdFinanceCustomer();
                customer.setMobile(userId+"");
                customer.setUserType(userType.byteValue());
				financeService.insertFinaceCustomer(customer);
                financeDto.setFinanceId(customer.getId().intValue());
                //返回财务id
                result.setData(financeDto);
                result.setMessage("ok");
                result.setState(200);
            }else{
                result.setData(financeDto);
                result.setMessage(EWarning.MessageIsNull.getName());
                result.setState(EWarning.MessageIsNull.getValue());
            }
        } catch (Exception e) {
            logger.error("addAccount error:{}", e.getMessage());
            result.setMessage(EWarning.Unknown.getName() + e.getMessage());
            result.setState(EWarning.Unknown.getValue());
            result.setData(new FinanceDto());
        }

        return result;
    }

    @ApiOperation(value = "获取骑手余额", httpMethod = "POST")
    @PostMapping(value = "/getDeliveryBalance",produces ="application/json;charset=UTF-8")
    @ResponseBody
    public RespBaseDto<DeliveryBalanceDto> getDeliveryBalance(
            @RequestBody DeliveryGetInfoVo deliveryGetInfoVo
    ) {
        RespBaseDto<DeliveryBalanceDto> result = new RespBaseDto<>();
        try {
			Integer deliveryId = deliveryGetInfoVo.getDeliveryId();
			DeliveryBalanceDto dto = new DeliveryBalanceDto();
			List<Double> list = new ArrayList();
			List<Double> listTotal = new ArrayList();
            if (deliveryId != null) {
				FxSdUserDeliverinfo delivery = superDeliveryService.selectUserBysuperDeliveryId(deliveryId + "");
				if(delivery!=null){
					FxSdFinanceCustomer finance = new FxSdFinanceCustomer();
					finance.setUserType((byte)2);
					finance.setMobile(delivery.getMobile());
					FxSdFinanceCustomer fxSdFinanceDelivery = financeService.selectAccountByUserIdAndUserType(finance);
					if(fxSdFinanceDelivery!=null){
						//当前账户余额
						BigDecimal totalAmount = fxSdFinanceDelivery.getTotalAmount();
						//今日总收益
						List<FxSdCarriageOrder> orders = orderService.selectOrderByDelivery(deliveryId);
						if(orders!=null){
							double sum =0.0;
							double sumTotal =0.0;
							for (FxSdCarriageOrder order:
								 orders) {
								Integer createTime = order.getCreateTime();
								//Date timeDate = UnixTimeChangeUtils.getTimeDate(createTime + "");
								//boolean today = UnixTimeChangeUtils.isToday(timeDate);
								Date date = DateUnixTimeUtils.TimeStamp2Date(createTime + "");
								String format = DateUnixTimeUtils.format(date);
								if(format.equals("今天")){
									//今日收入
									BigDecimal once = order.getDispatchPrice().add(order.getTipPrice());
									list.add(once.doubleValue());
								}
								BigDecimal once = order.getDispatchPrice().add(order.getTipPrice());
								listTotal.add(once.doubleValue());
							}
							for (double a:
							list) {
								sum+=a;
							}
							for (double a:
									listTotal) {
								sumTotal+=a;
							}
							dto.setDeliveryId(deliveryId);
							dto.setFinanceId(fxSdFinanceDelivery.getId().intValue());
							dto.setTodayMoney(new BigDecimal(sum));
							dto.setTotalMoney(new BigDecimal(sumTotal));
							dto.setBalance(totalAmount);
							result.setData(dto);
							result.setState(200);
							result.setMessage("ok");
						}else{
							result.setData(dto);
							result.setMessage(EWarning.NoOrderInfo.getName());
							result.setState(EWarning.NoOrderInfo.getValue());
						}
					}else {
						result.setData(dto);
						result.setMessage(EWarning.NoFinanceMsg.getName());
						result.setState(EWarning.NoFinanceMsg.getValue());
					}
				}else{
					result.setData(dto);
					result.setMessage(EWarning.NonExistent.getName());
					result.setState(EWarning.NonExistent.getValue());
				}
            }else{
				result.setData(dto);
				result.setMessage(EWarning.MessageIsNull.getName());
				result.setState(EWarning.MessageIsNull.getValue());
			}
        } catch (Exception e) {
            logger.error("getMyBalance error:{}", e.getMessage());
            result.setMessage(EWarning.Unknown.getName() + e.getMessage());
            result.setState(EWarning.Unknown.getValue());
        }
        return result;
    }
}
