package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class DeliveryIsWorkDto {
	@ApiModelProperty(value = "骑手id")
	private Integer superDeliveryId;
	@ApiModelProperty(value = "是否工作")
	private Integer isWork;
}
