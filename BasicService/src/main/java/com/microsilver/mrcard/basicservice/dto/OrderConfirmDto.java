package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class OrderConfirmDto {
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

	@ApiModelProperty(value="用户名")
	private String userName;
	@ApiModelProperty(value="用户头像")
	private String avatar;
	@ApiModelProperty(value="用户评分")
	private Double userScore;
	@ApiModelProperty(value="用户电话")
	private Long userMobile;
	@ApiModelProperty(value="订单总额")
	private Double orderSumAccount;
}
