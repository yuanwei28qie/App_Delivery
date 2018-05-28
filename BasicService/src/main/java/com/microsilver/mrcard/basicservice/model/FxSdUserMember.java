package com.microsilver.mrcard.basicservice.model;

import lombok.Data;

@Data
public class FxSdUserMember {
    private Long id;

    private String mobile;

    private String realname;

    private String identityCardNo;

    private String nickname;

    private String openid;

    private String pwd;

    private String salt;

    private Double serviceScore;

    private Double levelScore;

    private Integer createtime;

    private String avatar;

    private Byte status;

    private String openidQq;

    private String openidWx;

    private Long referee;

    private String identifier;

    private String token;

    private String imToken;

    private String imAccout;

    private String content;


}