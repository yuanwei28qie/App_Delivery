package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SuperDeliverySimpleDto {
	@ApiModelProperty("骑手id")
	private String superDeliveryId;
	@ApiModelProperty("骑手token")
	private String token;
	@ApiModelProperty("头像")
	private String avatar;
	@ApiModelProperty("手机号")
	private String mobile;
}
