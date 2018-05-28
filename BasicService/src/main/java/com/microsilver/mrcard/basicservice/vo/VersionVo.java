package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api
public class VersionVo {
	@ApiModelProperty(value = "APP类型1:超级跑腿(用户端),2:超级飞人(骑手端)")
	private Short appType;
	@ApiModelProperty(value = "终端类型(1:android,2:ios)")
	private Short clientType;
}
