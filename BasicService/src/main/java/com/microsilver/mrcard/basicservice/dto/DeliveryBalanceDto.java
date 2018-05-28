package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel
public class DeliveryBalanceDto {

	@ApiModelProperty(value = "财务id")
	private Integer financeId;
	@ApiModelProperty(value = "骑手id")
	private Integer deliveryId;
	@ApiModelProperty(value = "今日收益")
	private BigDecimal todayMoney;
	@ApiModelProperty(value = "累计收益")
	private BigDecimal totalMoney;
	@ApiModelProperty(value = "当前余额")
	private BigDecimal balance;
}
