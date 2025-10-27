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
    private String transactionId; // ID do gateway (ex: Stripe, Mercado Pago)
    private String cardBrand; // VISA, MASTERCARD, etc.
    private String cardLastDigits; // últimos 4 dígitos (nunca o número completo!)
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

    public Payment(Long id, Order order, PaymentType typePayment, PaymentStatus statusPayment, double value, String transactionId, String cardBrand, String cardLastDigits, Date paymentDate) {
        this.id = id;
        this.order = order;
        this.typePayment = typePayment;
        this.statusPayment = statusPayment;
        this.value = value;
        this.transactionId = transactionId;
        this.cardBrand = cardBrand;
        this.cardLastDigits = cardLastDigits;
        this.paymentDate = paymentDate;
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

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public String getCardLastDigits() {
        return cardLastDigits;
    }

    public void setCardLastDigits(String cardLastDigits) {
        this.cardLastDigits = cardLastDigits;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
