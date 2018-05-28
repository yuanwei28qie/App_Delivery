package com.microsilver.mrcard.basicservice.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class FxSdUserDeliverAdditional {
    private Long id;

    private Long deliverId;

    private String lat;

    private String lng;

    private BigDecimal serviceScore;

    private Integer levelScore;

    private Byte isWork;

    private Integer totalMileage;

    private Integer totalNumber;


}