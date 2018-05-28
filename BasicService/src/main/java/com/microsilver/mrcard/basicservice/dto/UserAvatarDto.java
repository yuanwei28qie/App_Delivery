package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserAvatarDto {
	@ApiModelProperty(value = "用户id")
	private Long id;
	@ApiModelProperty(value = "用户头像url地址")
	private String userAvatarUrl;
}
