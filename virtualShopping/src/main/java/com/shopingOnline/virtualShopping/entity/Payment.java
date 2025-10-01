package com.shopingOnline.virtualShopping.entity;

import com.shopingOnline.virtualShopping.enums.PaymentStatus;
import com.shopingOnline.virtualShopping.enums.PaymentType;

import java.util.Date;

public class Payment {
    private Long id;
    private Order order;
    private PaymentType typePayment;
    private PaymentStatus statusPayment;
    private double value;

    public Payment(Long id, Order order, PaymentType typePayment, PaymentStatus statusPayment, double value) {
        this.id = id;
        this.order = order;
        this.typePayment = typePayment;
        this.statusPayment = statusPayment;
        this.value = value;
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
