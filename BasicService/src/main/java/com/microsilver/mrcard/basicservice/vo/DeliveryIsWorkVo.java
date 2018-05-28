package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class DeliveryIsWorkVo {
	@ApiModelProperty(value = "骑手id")
	private Integer superDeliveryId;
	@ApiModelProperty(value = "是否工作,0休息,1工作")
	private Integer isWork;
}
