package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SuperDeliveryPositionDto {
	@ApiModelProperty("骑手id")
	private Long superDeliveryId;
	@ApiModelProperty("骑手纬度")
	private String lat;
	@ApiModelProperty("骑手经度")
	private String lng;
}
