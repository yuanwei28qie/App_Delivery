package com.microsilver.mrcard.basicservice.model;

import java.math.BigDecimal;

public class FxSdSysCarriageDispatch {
    private Long id;

    private Integer areaCode;

    private BigDecimal basePrice;

    private Byte baseMileage;

    private Integer beginTime;

    private Integer endTime;

    private BigDecimal nightMarkup;

    private BigDecimal mileageMarkup;

    private BigDecimal specialMarkup;

    private BigDecimal weightMarkup;

    private Integer initialWeight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public Byte getBaseMileage() {
        return baseMileage;
    }

    public void setBaseMileage(Byte baseMileage) {
        this.baseMileage = baseMileage;
    }

    public Integer getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Integer beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getNightMarkup() {
        return nightMarkup;
    }

    public void setNightMarkup(BigDecimal nightMarkup) {
        this.nightMarkup = nightMarkup;
    }

    public BigDecimal getMileageMarkup() {
        return mileageMarkup;
    }

    public void setMileageMarkup(BigDecimal mileageMarkup) {
        this.mileageMarkup = mileageMarkup;
    }

    public BigDecimal getSpecialMarkup() {
        return specialMarkup;
    }

    public void setSpecialMarkup(BigDecimal specialMarkup) {
        this.specialMarkup = specialMarkup;
    }

    public BigDecimal getWeightMarkup() {
        return weightMarkup;
    }

    public void setWeightMarkup(BigDecimal weightMarkup) {
        this.weightMarkup = weightMarkup;
    }

    public Integer getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(Integer initialWeight) {
        this.initialWeight = initialWeight;
    }
}