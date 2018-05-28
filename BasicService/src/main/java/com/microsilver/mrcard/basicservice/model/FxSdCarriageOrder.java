package com.microsilver.mrcard.basicservice.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class FxSdCarriageOrder {
    private Long id;

    private Long memberId;

    private Long deliverId;

    private String ordersn;

    private String serviceDesc;

    private BigDecimal dispatchPrice;

    private BigDecimal tipPrice;

    private BigDecimal goodsPrice;

    private String startName;

    private String startPhone;

    private String startAddress;

    private String startLat;

    private String startLng;

    private String endName;

    private String endPhone;

    private String endAddress;

    private String endLat;

    private String endLng;

    private Double mileages;

    private Integer weight;

    private String remark;

    private Integer areaCode;

    private String pic;

    private Byte memberDelete;

    private Byte deliverDelete;

    private Byte memberAppraise;

    private String memberAppraiseDesc;

    private Byte memberAppraiseScore;

    private Byte deliverAppraise;

    private String deliverAppraiseDesc;

    private Byte deliverAppraiseScore;

    private String pickupNumber;

    private Byte sourceType;

    private Byte payType;

    private Byte orderType;

    private Byte isSettlement;

    private String transId;

    private Long agentid;

    private Integer orderTime;

    private Integer createTime;

    private Byte status;

    private Integer expiredTime;

    private Short goodsType;

    private String goodsRemark;

    private Short memberAppraiseType;

    private Short deliveryAppraiseType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(Long deliverId) {
        this.deliverId = deliverId;
    }

    public String getOrdersn() {
        return ordersn;
    }

    public void setOrdersn(String ordersn) {
        this.ordersn = ordersn == null ? null : ordersn.trim();
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc == null ? null : serviceDesc.trim();
    }

    public BigDecimal getDispatchPrice() {
        return dispatchPrice;
    }

    public void setDispatchPrice(BigDecimal dispatchPrice) {
        this.dispatchPrice = dispatchPrice;
    }

    public BigDecimal getTipPrice() {
        return tipPrice;
    }

    public void setTipPrice(BigDecimal tipPrice) {
        this.tipPrice = tipPrice;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getStartName() {
        return startName;
    }

    public void setStartName(String startName) {
        this.startName = startName == null ? null : startName.trim();
    }

    public String getStartPhone() {
        return startPhone;
    }

    public void setStartPhone(String startPhone) {
        this.startPhone = startPhone == null ? null : startPhone.trim();
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress == null ? null : startAddress.trim();
    }

    public String getStartLat() {
        return startLat;
    }

    public void setStartLat(String startLat) {
        this.startLat = startLat == null ? null : startLat.trim();
    }

    public String getStartLng() {
        return startLng;
    }

    public void setStartLng(String startLng) {
        this.startLng = startLng == null ? null : startLng.trim();
    }

    public String getEndName() {
        return endName;
    }

    public void setEndName(String endName) {
        this.endName = endName == null ? null : endName.trim();
    }

    public String getEndPhone() {
        return endPhone;
    }

    public void setEndPhone(String endPhone) {
        this.endPhone = endPhone == null ? null : endPhone.trim();
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress == null ? null : endAddress.trim();
    }

    public String getEndLat() {
        return endLat;
    }

    public void setEndLat(String endLat) {
        this.endLat = endLat == null ? null : endLat.trim();
    }

    public String getEndLng() {
        return endLng;
    }

    public void setEndLng(String endLng) {
        this.endLng = endLng == null ? null : endLng.trim();
    }

    public Double getMileages() {
        return mileages;
    }

    public void setMileages(Double mileages) {
        this.mileages = mileages;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Byte getMemberDelete() {
        return memberDelete;
    }

    public void setMemberDelete(Byte memberDelete) {
        this.memberDelete = memberDelete;
    }

    public Byte getDeliverDelete() {
        return deliverDelete;
    }

    public void setDeliverDelete(Byte deliverDelete) {
        this.deliverDelete = deliverDelete;
    }

    public Byte getMemberAppraise() {
        return memberAppraise;
    }

    public void setMemberAppraise(Byte memberAppraise) {
        this.memberAppraise = memberAppraise;
    }

    public String getMemberAppraiseDesc() {
        return memberAppraiseDesc;
    }

    public void setMemberAppraiseDesc(String memberAppraiseDesc) {
        this.memberAppraiseDesc = memberAppraiseDesc == null ? null : memberAppraiseDesc.trim();
    }

    public Byte getMemberAppraiseScore() {
        return memberAppraiseScore;
    }

    public void setMemberAppraiseScore(Byte memberAppraiseScore) {
        this.memberAppraiseScore = memberAppraiseScore;
    }

    public Byte getDeliverAppraise() {
        return deliverAppraise;
    }

    public void setDeliverAppraise(Byte deliverAppraise) {
        this.deliverAppraise = deliverAppraise;
    }

    public String getDeliverAppraiseDesc() {
        return deliverAppraiseDesc;
    }

    public void setDeliverAppraiseDesc(String deliverAppraiseDesc) {
        this.deliverAppraiseDesc = deliverAppraiseDesc == null ? null : deliverAppraiseDesc.trim();
    }

    public Byte getDeliverAppraiseScore() {
        return deliverAppraiseScore;
    }

    public void setDeliverAppraiseScore(Byte deliverAppraiseScore) {
        this.deliverAppraiseScore = deliverAppraiseScore;
    }

    public String getPickupNumber() {
        return pickupNumber;
    }

    public void setPickupNumber(String pickupNumber) {
        this.pickupNumber = pickupNumber == null ? null : pickupNumber.trim();
    }

    public Byte getSourceType() {
        return sourceType;
    }

    public void setSourceType(Byte sourceType) {
        this.sourceType = sourceType;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public Byte getIsSettlement() {
        return isSettlement;
    }

    public void setIsSettlement(Byte isSettlement) {
        this.isSettlement = isSettlement;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId == null ? null : transId.trim();
    }

    public Long getAgentid() {
        return agentid;
    }

    public void setAgentid(Long agentid) {
        this.agentid = agentid;
    }

    public Integer getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Integer orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Integer expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Short getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Short goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsRemark() {
        return goodsRemark;
    }

    public void setGoodsRemark(String goodsRemark) {
        this.goodsRemark = goodsRemark == null ? null : goodsRemark.trim();
    }

    public Short getMemberAppraiseType() {
        return memberAppraiseType;
    }

    public void setMemberAppraiseType(Short memberAppraiseType) {
        this.memberAppraiseType = memberAppraiseType;
    }

    public Short getDeliveryAppraiseType() {
        return deliveryAppraiseType;
    }

    public void setDeliveryAppraiseType(Short deliveryAppraiseType) {
        this.deliveryAppraiseType = deliveryAppraiseType;
    }
}