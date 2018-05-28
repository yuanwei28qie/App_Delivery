package com.microsilver.mrcard.basicservice.model;

import lombok.Data;

@Data
public class FxSdSysVersion {
    private Long id;

    private Short appType;

    private Short clientType;

    private String version;

    private Integer code;

    private Byte isForce;

    private String description;

    private String downDdress;


}