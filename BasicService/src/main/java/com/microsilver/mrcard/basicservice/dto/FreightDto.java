
package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;


@Data
public class FreightDto {
	@ApiModelProperty(value = "运费总和")
	private Integer SumBigDecimal;
	@ApiModelProperty(value = "运费明细.basicPrice默认价格;weightPrice重量价格;distancePrice距离价格;nightPrice夜间价格;mileages订单距离;tipPrice小费")
	private Map<String, BigDecimal> map;
}
