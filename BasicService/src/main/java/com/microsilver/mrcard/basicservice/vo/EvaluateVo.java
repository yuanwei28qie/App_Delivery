package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class EvaluateVo {
	@ApiModelProperty(value="用户id")
	private Integer userId;
	@ApiModelProperty(value="骑手id")
	private Integer deliveryId;
	@ApiModelProperty(value="订单id")
	private Integer orderId;
	@ApiModelProperty(value="星星级别,一星传2分,2星就4分,以此类推,5星为10分")
	private Integer starLevel;
	@ApiModelProperty(value="评价类型(1.好客户2.美女3.帅哥.热情大方4.平近易人5.时尚6.热心7.有礼貌)")
	private Short evaluateType;
	@ApiModelProperty(value="备注")
	private String remark;

}
