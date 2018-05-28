package com.microsilver.mrcard.basicservice.model;

import lombok.Data;

@Data
public class FxSdUserDeliverinfo {
    private Long id;

    private String mobile;

    private String pwd;

    private String salt;

    private String realname;

    private String avatar;

    private Short gender;

    private String address;

    private String alipayAccount;

    private String identityCardNo;

    private String identityCardFront;

    private String identityCardBack;

    private String identityCardGroup;

    private Integer createTime;

    private Short checkStatus;

    private String remark;

    private Integer province;

    private Integer city;

    private Integer county;

    private String otherphoneno;

    private String occupation;

    private String identifier;

    private Long referee;

    private Long financeId;

    private String imToken;

    private String imAccout;

    private Long agentId;

    private Byte states;

    private Double serviceScore;

    private Double levelSocre;

    private byte[] token;


}