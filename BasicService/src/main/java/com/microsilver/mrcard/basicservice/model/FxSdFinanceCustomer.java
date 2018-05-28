package com.microsilver.mrcard.basicservice.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class FxSdFinanceCustomer {
    private Long id;

    private String mobile;

    private Byte userType;

    private BigDecimal totalAmount;

    private BigDecimal realAmount;

    private BigDecimal otherAmount;

    private BigDecimal advanceAmount;

    private Integer createTime;

    private Byte status;

}