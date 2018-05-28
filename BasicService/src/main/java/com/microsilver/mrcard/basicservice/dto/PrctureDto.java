package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PrctureDto {
	@ApiModelProperty(value = "图片url")
	private String pictureUrl;
}
