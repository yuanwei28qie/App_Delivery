package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class OrderDispatchVo {
	@ApiModelProperty(value = "起点纬度")
	private Double startLat;
	@ApiModelProperty(value = "起点经度")
	private Double startLng;
	@ApiModelProperty(value = "终点纬度")
	private Double endLat;
	@ApiModelProperty(value = "终点经度")
	private Double endLng;
	@ApiModelProperty(value = "重量")
	private Integer weight;
	@ApiModelProperty(value = "区域编码")
	private Integer areaCode;
	@ApiModelProperty(value = "小费")
	private Integer tipPrice;
}
