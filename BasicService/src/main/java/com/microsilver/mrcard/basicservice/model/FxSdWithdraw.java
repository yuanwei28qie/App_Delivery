package com.microsilver.mrcard.basicservice.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class FxSdWithdraw {
    private Long id;

    private Long financeId;

    private Integer createTime;

    private BigDecimal amount;

    private Integer isapproval;

    private Integer approvalTime;

    private String withdrawSn;


}