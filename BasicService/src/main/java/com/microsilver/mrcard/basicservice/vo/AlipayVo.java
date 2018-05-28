package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class AlipayVo {
	@ApiModelProperty(value = "商户订单号")
	private String out_trade_no ;
	@ApiModelProperty(value = "订单金额(精确到两个小数点)")
	private String total_amount ;

}
