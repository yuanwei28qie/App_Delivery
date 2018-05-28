package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserAddressAddVo {
	@ApiModelProperty(value = "用户手机号")
	private Long mobile;
	@ApiModelProperty(value = "地址id")
	private Integer addressId;
	@ApiModelProperty(value = "姓名")
	private String realName;
	@ApiModelProperty(value = "省")
	private Integer province;
	@ApiModelProperty(value = "市")
	private Integer city;
	@ApiModelProperty(value = "县/区")
	private Integer area;
	@ApiModelProperty(value = "街道")
	private String street;
	@ApiModelProperty(value = "详细地址")
	private String address;
	@ApiModelProperty(value = "纬度")
	private Double lat;
	@ApiModelProperty(value = "经度")
	private Double lng;
	@ApiModelProperty(value = "isDefault")
	private Short isDefault;
	@ApiModelProperty(value = "userId")
	private Integer userId;
}
