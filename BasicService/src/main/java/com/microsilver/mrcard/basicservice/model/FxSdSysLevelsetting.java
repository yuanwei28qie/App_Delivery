package com.microsilver.mrcard.basicservice.model;

public class FxSdSysLevelsetting {
    private Integer id;

    private Integer totalStarScore;

    private String levelName;

    private Integer levelScore;

    private Integer deliveryId;

    private Double serviceScore;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalStarScore() {
        return totalStarScore;
    }

    public void setTotalStarScore(Integer totalStarScore) {
        this.totalStarScore = totalStarScore;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    public Integer getLevelScore() {
        return levelScore;
    }

    public void setLevelScore(Integer levelScore) {
        this.levelScore = levelScore;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Double getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(Double serviceScore) {
        this.serviceScore = serviceScore;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}