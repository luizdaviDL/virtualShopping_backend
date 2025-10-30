package com.shopingOnline.virtualShopping.entity;

import com.shopingOnline.virtualShopping.enums.PaymentType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user_behavior")
public class UserBehavior {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @Column(name = "total_shopping")
    private BigDecimal totalShopping;

    @Column(name = "section_time")
    private Integer sectionTime;

    @Column(name = "interval_time")
    private String intervalTime;

    @OneToMany
    private List<ItemOrder> itemCart;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType paymentType;

    @Column(name = "client_age")
    private Integer clientAge;

    @Column(name = "state")
    private String state;

    @Column(name = "device")
    private String device;

    @Column(name = "fraud")
    private Boolean fraud;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public UserBehavior(Long id, Order order, BigDecimal totalShopping, Integer sectionTime, String intervalTime, List<ItemOrder> itemCart, PaymentType paymentType, Integer clientAge, String state, String device, Boolean fraud, LocalDateTime createdAt) {
        this.id = id;
        this.order = order;
        this.totalShopping = totalShopping;
        this.sectionTime = sectionTime;
        this.intervalTime = intervalTime;
        this.itemCart = itemCart;
        this.paymentType = paymentType;
        this.clientAge = clientAge;
        this.state = state;
        this.device = device;
        this.fraud = fraud;
        this.createdAt = createdAt;
    }

    public UserBehavior(Long id, BigDecimal totalPrice, LocalDate date) {
        this.id = id;
        this.totalShopping = totalPrice;
        this.createdAt = date != null ? date.atStartOfDay() : LocalDateTime.now();
        this.fraud = false;
        this.sectionTime = 0;
        this.intervalTime = "00:00";
        this.clientAge = 0;
        this.state = "Unknown";
        this.device = "Unknown";
        this.paymentType = PaymentType.CREDIT_CARD;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BigDecimal getTotalShopping() {
        return totalShopping;
    }

    public void setTotalShopping(BigDecimal totalShopping) {
        this.totalShopping = totalShopping;
    }

    public Integer getSectionTime() {
        return sectionTime;
    }

    public void setSectionTime(Integer sectionTime) {
        this.sectionTime = sectionTime;
    }

    public String getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(String intervalTime) {
        this.intervalTime = intervalTime;
    }

    public List<ItemOrder> getItemCart() {
        return itemCart;
    }

    public void setItemCart(List<ItemOrder> itemCart) {
        this.itemCart = itemCart;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getClientAge() {
        return clientAge;
    }

    public void setClientAge(Integer clientAge) {
        this.clientAge = clientAge;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Boolean getFraud() {
        return fraud;
    }

    public void setFraud(Boolean fraud) {
        this.fraud = fraud;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
