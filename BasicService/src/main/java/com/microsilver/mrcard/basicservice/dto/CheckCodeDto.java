package com.microsilver.mrcard.basicservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckCodeDto {
	@ApiModelProperty(value = "电话")
	private String mobile;
	@ApiModelProperty(value = "验证码")
	private String checkCode;
}
