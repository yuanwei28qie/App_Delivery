package com.microsilver.mrcard.basicservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



@JsonInclude(value=Include.NON_NULL)
@Data
public class RespBaseDto<T> {
	@ApiModelProperty(value = "状态码")
	private int state = 0;
	@ApiModelProperty(value = "信息")
	private String message;
	@ApiModelProperty(value = "泛型")
	private T data;
	
}

