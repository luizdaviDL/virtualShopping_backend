package com.shopingOnline.virtualShopping.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "user_behavior")
public class UserBehavior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_shopping", precision = 15, scale = 2)
    private BigDecimal totalShopping;

    @Column(name = "section_time")
    private Integer sectionTime;

    @Column(name = "item_cart")
    private Integer itemCart;

    @Column(name = "payment_tye")
    private String paymentTye;

    @Column(name = "client_age")
    private Integer clientAge;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "device")
    private String device;

    @Column(name = "fraude")
    private Boolean fraude;

    // ===== CONSTRUTORES =====


    public UserBehavior() {
    }

    public UserBehavior(BigDecimal totalShopping, Integer sectionTime, Integer itemCart,
                        String state, String country, Boolean fraude) {
        this.totalShopping = totalShopping;
        this.sectionTime = sectionTime;
        this.itemCart = itemCart;
        this.paymentTye = null;
        this.clientAge = null;
        this.state = state;
        this.country = country;
        this.device = null;
        this.fraude = fraude;
    }

    // ===== GETTERS e SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getItemCart() {
        return itemCart;
    }

    public void setItemCart(Integer itemCart) {
        this.itemCart = itemCart;
    }

    public String getPaymentTye() {
        return paymentTye;
    }

    public void setPaymentTye(String paymentTye) {
        this.paymentTye = paymentTye;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Boolean getFraude() {
        return fraude;
    }

    public void setFraude(Boolean fraude) {
        this.fraude = fraude;
    }
}
