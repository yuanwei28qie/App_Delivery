package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel
public class DeliveryCenterInfoDto {
	@ApiModelProperty(value = "骑手id")
	private Integer deliveryId;
	@ApiModelProperty(value = "服务分数")
	private Double serviceScore;
	@ApiModelProperty(value = "每日完成订单数")
	private Integer orderCount;
	@ApiModelProperty(value = "每日收入")
	private BigDecimal moneyToday;
}
