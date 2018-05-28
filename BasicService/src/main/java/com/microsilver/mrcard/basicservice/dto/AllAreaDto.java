package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AllAreaDto {
	@ApiModelProperty(value = "区域id")
	private Long id;
	@ApiModelProperty(value = "县/区编码")
	private Long code;
	@ApiModelProperty(value = "上一级编码")
	private Long parentCode;
	@ApiModelProperty(value = "当前区域名称")
	private String name;
	@ApiModelProperty(value = "当前区域等级(1省/直辖市,2市,3区/县)")
	private Short level;


}
