package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class DeliveryPageVo {
	@ApiModelProperty(value = "当前页")
	private Integer currentPage;
	@ApiModelProperty(value = "每页需要显示的数量")
	private Integer pageSize;
	@ApiModelProperty(value = "骑手所在区域(县/区)")
	private Integer areaCode;
}
