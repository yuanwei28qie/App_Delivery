package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class DeliveryLatLngDto {

	@ApiModelProperty(value = "骑手id")
	private Integer id;
	@ApiModelProperty(value = "骑手经度")
	private Double lng;
	@ApiModelProperty(value = "骑手纬度")
	private Double lat;

}
