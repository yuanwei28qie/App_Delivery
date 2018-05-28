package com.microsilver.mrcard.basicservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGetInfo {
	@ApiModelProperty(value = "用户id")
	private Integer id;
}
