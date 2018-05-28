
package com.microsilver.mrcard.basicservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class SuperDeliveryDto {
	@ApiModelProperty("骑手id")
	private Long superDeliveryId;
	@ApiModelProperty("骑手真实姓名")
	private String realName;
	@ApiModelProperty("骑手头像地址URL")
	private String avatar;
	@ApiModelProperty("现居地")
	private String address;
	@ApiModelProperty("性别(0-男,1-女)")
	private Short gender;
	@ApiModelProperty("电话号码")
	private String mobile;
	@ApiModelProperty("支付宝账号")
	private String aliPayAccount;
	@ApiModelProperty("身份证")
	private String identityCardNo;
	@ApiModelProperty("创建账号时间")
	private String createTime;
	@ApiModelProperty("身份证正面url")
	private String identityCardFront;
	@ApiModelProperty("身份证反面url")
	private String identityCardBack;
	@ApiModelProperty("身份证合照url")
	private String identityCardGroup;

	@ApiModelProperty("骑手所在省份编码")
	private String province;
	@ApiModelProperty("骑手所在市区编码")
	private String city;
	@ApiModelProperty("骑手所在县区编码")
	private String county;
	@ApiModelProperty("紧急人联系电话")
	private String otherPhone;
	@ApiModelProperty("职业")
	private String occupation;
	@ApiModelProperty("推荐人")
	private String referee;

	@ApiModelProperty("审核状态(0:审核未通过,1:待审核(完善资料后),2:已审核.3预审核(注册之后))")
	private Short checkStatus;
	@ApiModelProperty("服务分")
	private BigDecimal serviceScore;
	@ApiModelProperty("等级名称")
	private String levelName;
	@ApiModelProperty("工作状态(0表示休息,1表示开工)")
	private Byte workStatus;
	@ApiModelProperty("今日里程")
	private Integer todayMileage;
	@ApiModelProperty("今日接单数量")
	private Integer todayNumber;
	@ApiModelProperty("今日收入")
	private String todayIncome;
	@ApiModelProperty("累计里程")
	private Integer totalMileage;
	@ApiModelProperty("累计单数")
	private Integer totalNumber;
	@ApiModelProperty("累计收入")
	private String totalIncome;
	@ApiModelProperty("余额")
	private String realAmount;
	@ApiModelProperty("即时通讯账号")
	private String imAccount;
	@ApiModelProperty("即时通讯token")
	private String imToken;
	@ApiModelProperty("骑手token")
	private String token;

}
