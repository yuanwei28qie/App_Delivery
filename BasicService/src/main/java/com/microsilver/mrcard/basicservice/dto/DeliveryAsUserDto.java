package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class DeliveryAsUserDto {
	@ApiModelProperty(value = "骑手id")
	private Integer deliveryId;
	@ApiModelProperty(value = "骑手头像url")
	private String deliveryAvatarUrl;
	@ApiModelProperty(value = "骑手名称")
	private String deliveryIdNickName;
	@ApiModelProperty(value = "服务次数")
	private Integer serviceNumber;
	@ApiModelProperty(value = "服务分")
	private Double serviceScore;
	@ApiModelProperty(value = "骑手经度")
	private Double lng;
	@ApiModelProperty(value = "骑手纬度")
	private Double lat;
}
