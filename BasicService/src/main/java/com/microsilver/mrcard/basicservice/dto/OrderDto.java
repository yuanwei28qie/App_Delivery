package com.microsilver.mrcard.basicservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {
	@ApiModelProperty(value="用户id")
	private Integer userId;
	@ApiModelProperty(value="骑手id")
	private Integer deliveryId;
	@ApiModelProperty(value="订单号")
	private Long orderSn;
	@ApiModelProperty(value="订单id")
	private Integer orderId;
	@ApiModelProperty(value="运费")
	private BigDecimal dispatchPrice;
	@ApiModelProperty(value="小费")
	private BigDecimal tipPrice;
	@ApiModelProperty(value="起点姓名")
	private String startName;
	@ApiModelProperty(value="起点电话")
	private Long startPhone;
	@ApiModelProperty(value="起点地址")
	private String startAddress;
	@ApiModelProperty(value="起点经度")
	private Double startLat;
	@ApiModelProperty(value="起点维度")
	private Double startLng;
	@ApiModelProperty(value="终点姓名")
	private String endName;
	@ApiModelProperty(value="终点电话")
	private Long endPhone;
	@ApiModelProperty(value="终点地址")
	private String endAddress;
	@ApiModelProperty(value="终点经度")
	private Double endLat;
	@ApiModelProperty(value="终点纬度")
	private Double endLng;
	@ApiModelProperty(value="起点到终点的里程数")
	private Double mileages;
	@ApiModelProperty(value="重量")
	private Integer weight;
	@ApiModelProperty(value="备注")
	private String remark;
	@ApiModelProperty(value="订单所在区域编号(区县级)")
	private Integer areaCode;

	@ApiModelProperty(value="取货码")
	private Integer pickupNumber;

	@ApiModelProperty(value="支付类型 1为余额支付 2在线支付 3 货到付款 11 后台付款 21 微信支付 22 支付宝支付 23 银联支付")
	private Integer payType;
	@ApiModelProperty(value="第三方支付单编号")
	private Integer transId;
	@ApiModelProperty(value="订单类型(1.帮我买,2帮我取,3帮我送)")
	private Integer orderType;

	@ApiModelProperty(value="订单来源(1:android,2:ios,3:微信)")
	private Integer sourceType;
	@ApiModelProperty(value="下单时间")
	private String createTime;
	@ApiModelProperty(value="状态(1:待支付2:待抢单,3待取货,4.待收货,5.订单完成,6.评价完成,7.等待退款8:退款完成,9:订单取消,-1:订单已锁定）")
	private Integer status;
	@ApiModelProperty(value="订单总金额")
	private BigDecimal totalCount;
	@ApiModelProperty(value = "货物类型(0:其他1文件2美食3蛋糕4钥匙)")
	private Short goodsType;
	@ApiModelProperty(value = "商品(货物)描述")
	private String goodsRemark;
}
