package com.microsilver.mrcard.basicservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

	@ApiModelProperty("用户id")
	private Long userId;
	@ApiModelProperty("用户token")
	private String token;
	@ApiModelProperty("电话")
	private Long mobile;
	@ApiModelProperty("真实姓名")
	private String realName;
	@ApiModelProperty("昵称")
	private String nickName;
	@ApiModelProperty("创建时间")
	private Long createTime;
	@ApiModelProperty("头像")
	private String avatar;
	@ApiModelProperty("状态")
	private Integer status;
	@ApiModelProperty("财务id")
	private Integer financeId;
	@ApiModelProperty("推荐人id")
	private Integer refereeId;
	@ApiModelProperty("用户身份证")
	private String identityCardNo;


}
