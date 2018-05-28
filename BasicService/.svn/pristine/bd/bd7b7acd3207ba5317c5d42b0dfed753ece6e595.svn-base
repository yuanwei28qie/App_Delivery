package com.microsilver.mrcard.basicservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description="区域信息")
@Data
public class FxSdSysArea {
	@ApiModelProperty("区域主键id")
    private Long id;
	@ApiModelProperty("当前区域编号")
    private Long code;
	@ApiModelProperty("上级区域编号")
    private Long parentCode;
	@ApiModelProperty("当前区域名称")
    private String name;
	@ApiModelProperty("当前区域所在等级,1表示省份;2表示城市;3表示市区")
    private Integer level;

    
}