package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserNickNameDto {

	@ApiModelProperty(value = "用户id")
	private Long userId;

	@ApiModelProperty(value = "用户昵称")
	private String nickName;
}
