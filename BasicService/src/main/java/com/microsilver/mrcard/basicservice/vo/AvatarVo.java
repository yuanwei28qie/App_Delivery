package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class AvatarVo {
	@ApiModelProperty(value = "用户id")
	private Integer userId;
	@ApiModelProperty(value = "用户头像url")
	private String userAvartarUrl;
}
