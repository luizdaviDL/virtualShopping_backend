package com.shopingOnline.virtualShopping.entity;

import com.shopingOnline.virtualShopping.enums.PaymentStatus;
import com.shopingOnline.virtualShopping.enums.PaymentType;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
    @Enumerated(EnumType.STRING) // salva como texto (ex: "PENDING")
    @Column(name = "type", nullable = false)
    private PaymentType typePayment;
    @Enumerated(EnumType.STRING) // salva como texto (ex: "PENDING")
    @Column(name = "status", nullable = false)
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
