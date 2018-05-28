package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class DeliveryScoreDto {
	@ApiModelProperty(value="骑手id")
	private Integer deliveryId;
	@ApiModelProperty(value="用户id")
	private Integer userId;
	@ApiModelProperty(value="订单id")
	private Integer orderId;
	@ApiModelProperty(value="骑手评价类型")
	private Byte deliveryRaiseType;
	@ApiModelProperty(value="骑手评价星级")
	private Integer starLevel;
	@ApiModelProperty(value="用户总评分")
	private Double levelScore;
	@ApiModelProperty(value="用户订单数")
	private Integer orderCount;
	@ApiModelProperty(value="用户综合分数")
	private Double serviceScore;

}
