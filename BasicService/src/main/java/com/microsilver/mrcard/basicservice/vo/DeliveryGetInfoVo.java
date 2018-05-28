package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class DeliveryGetInfoVo {

	@ApiModelProperty(value = "骑手id")
	private Integer deliveryId;
}
