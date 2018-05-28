package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class PayWxVo {
	@ApiModelProperty(value = "订单单号")
	private Long outTradeNo;
	@ApiModelProperty(value = "订单金额(分为单位)")
	private Double totalFee;
}
