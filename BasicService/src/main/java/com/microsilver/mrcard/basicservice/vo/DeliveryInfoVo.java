package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class DeliveryInfoVo {

	@ApiModelProperty(value = "区域编号")
	private Integer areaCode;
	@ApiModelProperty(value = "纬度(类型传入Double)")
	private Double lat;
	@ApiModelProperty(value = "经度(类型传入Double)")
	private Double lng;
}
