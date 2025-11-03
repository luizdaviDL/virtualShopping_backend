package com.shopingOnline.virtualShopping.entity;

import com.shopingOnline.virtualShopping.enums.PaymentStatus;
import com.shopingOnline.virtualShopping.enums.PaymentType;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "user_behavior")
public class UserBehavior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    @Column(name = "total_shopping", precision = 15, scale = 2)
    private BigDecimal totalShopping;

    @Column(name = "section_time")
    private Integer sectionTime;

    @Column(name = "interval_time")
    private Integer intervalTime;

    @Column(name = "item_cart")
    private Integer itemCart;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType paymentType;

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


    public UserBehavior(Client client,BigDecimal totalPrice, int sectionTime,int intervalTime , int size, PaymentType paymentType, Integer age, String state, String country,String device ,boolean fraude) {
        this.client = client;
        this.totalShopping = totalPrice;
        this.sectionTime = sectionTime;
        this.intervalTime = intervalTime;
        this.itemCart = size;
        this.paymentType = paymentType;
        this.clientAge = age;
        this.state = state;
        this.country = country;
        this.device = device;
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

    public PaymentType getPaymentTye() {
        return paymentType;
    }

    public void setPaymentTye(PaymentType paymentTye) {
        this.paymentType = paymentTye;
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

    public Integer getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(Integer intervalTime) {
        this.intervalTime = intervalTime;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
