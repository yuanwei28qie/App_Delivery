package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class DeliveryRobbOrderVo {
	@ApiModelProperty(value = "订单id")
	private Integer orderId;
	@ApiModelProperty(value = "订单号")
	private Long orderSn;
	@ApiModelProperty(value = "骑手id")
	private Integer deliveryId;
}
