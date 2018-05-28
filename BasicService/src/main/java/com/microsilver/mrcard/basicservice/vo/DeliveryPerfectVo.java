package com.microsilver.mrcard.basicservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel
public class DeliveryPerfectVo {
	@ApiModelProperty("骑手id")
	private Integer superDeliveryId;
	@ApiModelProperty("电话号码")
	private Long mobile;
	@ApiModelProperty("登陆密码")
	private String password;
	@ApiModelProperty("真实姓名")
	private String realName;
	@ApiModelProperty("性别")
	private Short gender;
	@ApiModelProperty("骑手所在省份编码")
	private Integer province;
	@ApiModelProperty("骑手所在市区编码")
	private Integer city;
	@ApiModelProperty("骑手所在县区编码")
	private Integer county;
	@ApiModelProperty("支付宝账号")
	private String aliPayAccount;
	@ApiModelProperty("身份证")
	private String identityCardNo;
	@ApiModelProperty("现居地")
	private String address;
	@ApiModelProperty("紧急人联系电话")
	private Long otherPhone;
	@ApiModelProperty("职业")
	private String occupation;
	@ApiModelProperty("身份证正面url")
	private String identityCardFront;
	@ApiModelProperty("身份证反面url")
	private String identityCardBack;
	@ApiModelProperty("身份证合照url")
	private String identityCardGroup;
}
