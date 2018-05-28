package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class RegisterOrLoginVo {
	@ApiModelProperty(value = "手机号")
	private Long mobile;
	@ApiModelProperty(value = "验证码")
	private Integer checkCode;

}
