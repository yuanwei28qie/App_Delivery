package com.microsilver.mrcard.basicservice.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class FxSdFinanceFlow {
    private Long id;

    private Long financeId;

    private BigDecimal amount;

    private Integer amountType;

    private Integer source;

    private Long orderId;

    private Integer changeTime;


}