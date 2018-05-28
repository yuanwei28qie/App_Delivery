package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel
public class DeliveryWithDrawDto {
	@ApiModelProperty(value = "提现id")
	private Integer withDrawId;
	@ApiModelProperty(value = "财务id")
	private Integer financeId;
	@ApiModelProperty(value = "骑手电话")
	private Long deliveryMobile;
	@ApiModelProperty(value = "提现金额")
	private BigDecimal withDrawAccount;
	@ApiModelProperty(value = "骑手账户余额")
	private BigDecimal balanceAccount;
	@ApiModelProperty(value = "审核状态")
	private Short status;
	@ApiModelProperty(value = "提现单号")
	private Long withDrawSn;
}
