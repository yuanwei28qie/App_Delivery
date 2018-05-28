package com.microsilver.mrcard.basicservice.model;

import lombok.Data;

@Data
public class FxUcenterMember {
    private Integer id;

    private String username;

    private String password;

    private Long agentId;

    private Integer level;

    private String mobile;

    private Integer regTime;

    private Long regIp;

    private Integer lastLoginTime;

    private Long lastLoginIp;

    private Integer updateTime;

    private Byte status;

    private Byte flag;


}