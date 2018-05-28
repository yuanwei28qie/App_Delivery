package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class FinanceVo {
	@ApiModelProperty(value = "用户id")
	private Integer userId;
	@ApiModelProperty(value = "用户类型(1.用户,2,骑手,3,代理商)")
	private Short userType;
}
