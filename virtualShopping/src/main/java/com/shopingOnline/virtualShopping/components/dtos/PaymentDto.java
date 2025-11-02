package com.shopingOnline.virtualShopping.components.dtos;

import com.shopingOnline.virtualShopping.enums.PaymentStatus;
import com.shopingOnline.virtualShopping.enums.PaymentType;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentDto {
    private Long id;
    private Long order;
    private PaymentType typePayment;
    private PaymentStatus statusPayment;
    private BigDecimal value;
    private String deviceFingerprint;
    private String ipAddress;
    private String userAgent;
    private String location;
    private String transactionId;
    private Date paymentDate;
    private Date createdAt;

    public PaymentDto() {
    }

    public PaymentDto(Long id, PaymentType typePayment, PaymentStatus statusPayment, BigDecimal value, String deviceFingerprint, String ipAddress, String userAgent, String location, String transactionId, Date paymentDate, Date createdAt) {
        this.id = id;
        this.typePayment = typePayment;
        this.statusPayment = statusPayment;
        this.value = value;
        this.deviceFingerprint = deviceFingerprint;
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
        this.location = location;
        this.transactionId = transactionId;
        this.paymentDate = paymentDate;
        this.createdAt = createdAt;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentType getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(PaymentType typePayment) {
        this.typePayment = typePayment;
    }

    public PaymentStatus getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(PaymentStatus statusPayment) {
        this.statusPayment = statusPayment;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getDeviceFingerprint() {
        return deviceFingerprint;
    }

    public void setDeviceFingerprint(String deviceFingerprint) {
        this.deviceFingerprint = deviceFingerprint;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
