package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderCreateVo {
	@ApiModelProperty(value = "用户id")
	private Integer userId;
	@ApiModelProperty(value = "运费")
	private BigDecimal dispatchPrice;
	@ApiModelProperty(value = "小费")
	private BigDecimal tipPrice;
	@ApiModelProperty(value = "起点姓名")
	private String startName;
	@ApiModelProperty(value = "起点电话")
	private Long startPhone;
	@ApiModelProperty(value = "起点地址")
	private String startAddress;
	@ApiModelProperty(value = "起点纬度")
	private Double startLat;
	@ApiModelProperty(value = "起点经度")
	private Double startLng;
	@ApiModelProperty(value = "终点姓名")
	private String endName;
	@ApiModelProperty(value = "终点电话")
	private Long endPhone;
	@ApiModelProperty(value = "终点地址")
	private String endAddress;
	@ApiModelProperty(value = "终点纬度")
	private Double endLat;
	@ApiModelProperty(value = "终点经度")
	private Double endLng;
	@ApiModelProperty(value = "重量")
	private Integer weight;
	@ApiModelProperty(value = "备注")
	private String remark;
	@ApiModelProperty(value = "区域编号")
	private Integer areaCode;
	@ApiModelProperty(value = "支付类型订单来源(1:android,2:ios,3:微信)")
	private Short sourceType;
	@ApiModelProperty(value = "订单类型(1.帮我买,2帮我取,3帮我送)")
	private Short orderType;
	@ApiModelProperty(value = "货物类型(0:其他1文件2美食3蛋糕4钥匙)")
	private Short goodsType;
	@ApiModelProperty(value = "商品(货物)描述")
	private String goodsRemark;
}
