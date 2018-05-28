package com.microsilver.mrcard.basicservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MobileVo {
	@NotNull
	@ApiModelProperty(value = "手机号")
	private Long mobile;
	@NotNull
	@ApiModelProperty(value = "验证码类型-1注册,2登陆,3收货码,4修改(忘记)密码")
	private short type;
}
