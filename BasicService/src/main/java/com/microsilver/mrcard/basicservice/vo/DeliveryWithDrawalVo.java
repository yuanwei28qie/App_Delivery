package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class DeliveryWithDrawalVo {
	@ApiModelProperty(value = "骑手支付宝账号")
	private String AliPayAccount;
	@ApiModelProperty(value = "骑手电话")
	private Long deliveryMobile;
	@ApiModelProperty(value = "提现金额")
	private Double drawAccount;


}
