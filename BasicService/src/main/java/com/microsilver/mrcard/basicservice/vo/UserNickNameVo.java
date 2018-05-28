package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserNickNameVo {
	@ApiModelProperty(value = "用户id")
	private Integer userId;
	@ApiModelProperty(value = "用户昵称")
	private String userNickName;
}
