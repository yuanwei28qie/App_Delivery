package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class DeliveryRegisterVo {
	//mobile(手机号)-checkCode(验证码)-password(骑手密码)" +
	//					"-country(所在区县编码)-city(城市编码)-province(省份编码)
	@ApiModelProperty(value = "手机号")
	private Long mobile;
	@ApiModelProperty(value = "验证码")
	private Integer checkCode;
	@ApiModelProperty(value = "骑手密码")
	private String password;
	@ApiModelProperty(value = "所在区县编码")
	private Integer country;
	@ApiModelProperty(value = "城市编码")
	private Integer city;
	@ApiModelProperty(value = "省份编码")
	private Integer province;
}
