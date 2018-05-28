package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FinanceDto {
	@ApiModelProperty(value = "财务id")
	private Integer financeId;
	@ApiModelProperty(value = "实际金额（可提现金额）")
	private BigDecimal totalAmount;
	@ApiModelProperty(value = "不可提现金额")
	private BigDecimal otherAmount;

}
