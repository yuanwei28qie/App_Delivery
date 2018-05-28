package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class EditPwdVo {
	@ApiModelProperty(value = "电话")
	private Long mobile;
	@ApiModelProperty(value = "旧密码或者验证码")
	private String code;
	@ApiModelProperty(value = "类型:1修改(密码),2忘记(验证码)")
	private Short type;
	@ApiModelProperty(value = "新密码")
	private String newPwd;
}
