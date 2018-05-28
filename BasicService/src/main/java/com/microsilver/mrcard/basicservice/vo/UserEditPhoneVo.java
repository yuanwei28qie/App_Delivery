package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserEditPhoneVo {

	@ApiModelProperty(value = "用户旧手机")
	private Long oldPhoneNumber;
	@ApiModelProperty(value = "用户旧手机验证码")
	private Integer oldCheckCode;
	@ApiModelProperty(value = "用户新手机")
	private Long newPhoneNumber;
	@ApiModelProperty(value = "用户新手机验证码")
	private Integer newCheckCode;
}
