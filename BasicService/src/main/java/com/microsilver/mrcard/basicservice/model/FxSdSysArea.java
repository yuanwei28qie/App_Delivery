package com.microsilver.mrcard.basicservice.model;

import lombok.Data;

@Data
public class FxSdSysArea {
    private Long id;

    private Integer code;

    private Integer parentCode;

    private String name;

    private Integer level;

}