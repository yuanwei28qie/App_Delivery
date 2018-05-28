package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserSimpleDto {
	@ApiModelProperty(value = "用户id")
	private Long userId;
	@ApiModelProperty(value = "用户token")
	private String userToken;
	@ApiModelProperty(value = "是否启用")
	private Integer status;
}
