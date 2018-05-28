package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
@Data
@ApiModel
public class DeliveryCenterDto {
	@ApiModelProperty(value = "骑手id")
	private Integer deliveryId;
	@ApiModelProperty(value = "骑手邀请码")
	private Integer deliveryInvitationCode;
	@ApiModelProperty(value = "等级名称")
	private String levelName;
	@ApiModelProperty(value = "今日订单完成数")
	private Integer orderCountToday;
	@ApiModelProperty(value = "今日里程数")
	private Double distanceToday;
	@ApiModelProperty(value = "今日收益")
	private BigDecimal moneyToday;

	@ApiModelProperty(value = "累计订单完成数")
	private Integer orderCountAll;
	@ApiModelProperty(value = "累计里程数")
	private Double distanceAll;
	@ApiModelProperty(value = "累计收益")
	private BigDecimal moneyAll;

	@ApiModelProperty(value = "信用分")
	private Double creditScore;
	@ApiModelProperty(value = "签约状态(1已签约;2未签约)")
	private Short status;
	@ApiModelProperty(value = "骑手头像")
	private String deliveryURL;
	@ApiModelProperty(value = "账户余额")
	private BigDecimal balance;

}
