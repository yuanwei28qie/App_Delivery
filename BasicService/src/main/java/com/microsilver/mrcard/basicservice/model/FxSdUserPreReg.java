package com.microsilver.mrcard.basicservice.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class FxSdUserPreReg {
    private String mobile;

    private Long id;

    private Boolean type;

    private String refereeId;

    private Short status;

    private BigDecimal amount;


}