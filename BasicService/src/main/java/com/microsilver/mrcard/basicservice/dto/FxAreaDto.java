
package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class FxAreaDto {
	@ApiModelProperty("区域主键")
	private Integer id;
	@ApiModelProperty("省")
	private String province;
	@ApiModelProperty("省-编码")
	private String provinceNum;
	@ApiModelProperty("市")
	private String city;
	@ApiModelProperty("市-编码")
	private String cityNum;
	@ApiModelProperty("县/区")
	private String county;
	@ApiModelProperty("县/区-编码")
	private String countyNum;
}
