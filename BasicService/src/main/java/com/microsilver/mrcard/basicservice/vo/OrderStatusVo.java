package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class OrderStatusVo {
	@ApiModelProperty(value="用户id")
	private Integer userId;
	@ApiModelProperty(value="骑手id")
	private Integer deliveryId;
	@ApiModelProperty(value="订单id")
	private Integer orderId;
	@ApiModelProperty(value="订单号")
	private Long orderSn;
	@ApiModelProperty(value="订单状态")
	private Byte status;
}
