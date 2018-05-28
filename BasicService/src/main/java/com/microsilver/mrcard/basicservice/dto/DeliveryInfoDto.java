package com.microsilver.mrcard.basicservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryInfoDto {
	@ApiModelProperty(value="用户头像")
	private String AvatarUrl;
	@ApiModelProperty(value="用户名")
	private String userNikeName;
	@ApiModelProperty(value="用户评分")
	private Double userService;
	@ApiModelProperty(value="用户手机号")
	private Long mobile;
	@ApiModelProperty(value="订单金额")
	private BigDecimal orderAccount;


	@ApiModelProperty(value="订单状态(3-待取货,4-待收货)")
	private Integer status;
	@ApiModelProperty(value="用户id")
	private Integer userId;
	@ApiModelProperty(value="骑手id")
	private Integer deliveryId;
	@ApiModelProperty(value="订单id")
	private Integer orderId;
	@ApiModelProperty(value="订单号")
	private Long orderSn;

	@ApiModelProperty(value="收货人地址")
	private String endAddress;
	@ApiModelProperty(value="起点到终点的里程数")
	private Double mileages;
	@ApiModelProperty(value="发货人姓名")
	private String startName;
	@ApiModelProperty(value="发货人电话")
	private Long startPhone;

	@ApiModelProperty(value="收货人姓名")
	private String endName;

	@ApiModelProperty(value="收货人电话")
	private Long endPhone;

	@ApiModelProperty(value="开始经纬度")
	private String startLngLat;
	@ApiModelProperty(value="终点经纬度")
	private String endLngLat;
	@ApiModelProperty(value="预计时间内取货(规则即抢单之后的十二分钟内)")
	private Long expectedTime;



	@ApiModelProperty(value="备注")
	private String remark;

	@ApiModelProperty(value="商品备注")
	private String goodsRemark;
}
