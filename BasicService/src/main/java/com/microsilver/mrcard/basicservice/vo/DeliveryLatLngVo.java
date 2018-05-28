package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class DeliveryLatLngVo {

	@ApiModelProperty(value = "骑手id")
	private Integer id;
	@ApiModelProperty(value = "骑手经度")
	private Double lng;
	@ApiModelProperty(value = "骑手纬度")
	private Double lat;

}
