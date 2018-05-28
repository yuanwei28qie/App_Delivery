package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserDelAddressVo {
	@ApiModelProperty(value = "用户id")
	private Integer id;
	@ApiModelProperty(value = "地址id")
	private Integer addressId;
}
