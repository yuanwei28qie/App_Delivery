package com.microsilver.mrcard.basicservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FxSdUserAddress {
    @ApiModelProperty(value="地址id")
    private Integer id;
    @ApiModelProperty(value="姓名")
    private String realname;
    @ApiModelProperty(value="电话")
    private String mobile;
    @ApiModelProperty(value="省份")
    private String province;
    @ApiModelProperty(value="城市")
    private String city;
    @ApiModelProperty(value="区域")
    private String area;
    @ApiModelProperty(value="街道")
    private String street;
    @ApiModelProperty(value="详细地址")
    private String address;
    @ApiModelProperty(value="纬度")
    private String lat;
    @ApiModelProperty(value="经度")
    private String lng;
    @ApiModelProperty(value="是否默认(0为非默认,1是默认)")
    private Byte isdefault;
    @ApiModelProperty(value="用户id")
    private Long memberId;


}