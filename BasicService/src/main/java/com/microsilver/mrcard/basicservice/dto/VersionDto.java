package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VersionDto {
	@ApiModelProperty(value = "主键id")
	private Long id;
	@ApiModelProperty(value = "APP类型1:超级跑腿,2:超级飞人")
	private Short appType;
	@ApiModelProperty(value = "终端类型(1:android,2:ios)")
	private Short clientType;
	@ApiModelProperty(value = "版本号")
	private String version;
	@ApiModelProperty(value = "版本编号")
	private Integer code;
	@ApiModelProperty(value = "是否强制更新")
	private Short isForce;
	@ApiModelProperty(value = "更新说明")
	private String description;
	@ApiModelProperty(value = "下载地址")
	private String downAddress;

}
