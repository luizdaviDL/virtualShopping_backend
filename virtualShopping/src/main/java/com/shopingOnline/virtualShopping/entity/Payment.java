package com.shopingOnline.virtualShopping.entity;

import com.shopingOnline.virtualShopping.enums.PaymentStatus;
import com.shopingOnline.virtualShopping.enums.PaymentType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Todas os pagamentos na mesma tabela
@DiscriminatorColumn(name = "payment_method", discriminatorType = DiscriminatorType.STRING)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PaymentType typePayment;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PaymentStatus statusPayment;

    private BigDecimal value;

    // ✅ DADOS PARA FRAUDE DETECTION (ADICIONAR ESTES)
    private String deviceFingerprint; // Hash do dispositivo
    private String ipAddress; // IP do cliente
    private String userAgent; // Navegador/SO
    private String location; // Cidade/Estado baseado no IP

    // ✅ DADOS TRANSACTIONAIS COMUNS
    private String transactionId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    // ✅ CAMPOS ESPECÍFICOS (podem ser NULL)
    // Para Cartão
    private String cardBrand;
    private String cardLastDigits;

    // Para PIX
    private String pixKey; // Chave PIX usada
    private String pixKeyType; // CPF, Email, Telefone, Aleatória
    private String pixTransactionId; // ID específico do PIX
    private String bankOrigin; // Banco de origem

    // Para Boleto
    private String barcode; // Código do boleto
    private Date dueDate; // Data de vencimento
    private String bankSlipUrl; // URL do boleto

    // Construtores
    public Payment() {
    }

    public Payment(Order order, PaymentType typePayment, PaymentStatus statusPayment,
                   BigDecimal value, String deviceFingerprint, String ipAddress) {
        this();
        this.order = order;
        this.typePayment = typePayment;
        this.statusPayment = statusPayment;
        this.value = value;
        this.deviceFingerprint = deviceFingerprint;
        this.ipAddress = ipAddress;
    }

    @Transient // Não persiste no banco!
    public Long clientId() {
        return this.order != null ? this.order.getClient().getId() : null;
    }


    // ✅ MÉTODOS ESPECÍFICOS POR TIPO
    public boolean isPIX() {
        return PaymentType.PIX.equals(this.typePayment);
    }

    public boolean isCreditCard() {
        return PaymentType.CREDIT_CARD.equals(this.typePayment);
    }

    public boolean isBankSlip() {
        return PaymentType.BOLETO.equals(this.typePayment);
    }

    //-----------------

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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
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

    public String getDeviceFingerprint() { return deviceFingerprint; }
    public void setDeviceFingerprint(String deviceFingerprint) { this.deviceFingerprint = deviceFingerprint; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getUserAgent() { return userAgent; }
    public void setUserAgent(String userAgent) { this.userAgent = userAgent; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public String getPixKey() { return pixKey; }
    public void setPixKey(String pixKey) { this.pixKey = pixKey; }

    public String getPixKeyType() { return pixKeyType; }
    public void setPixKeyType(String pixKeyType) { this.pixKeyType = pixKeyType; }

    public String getPixTransactionId() { return pixTransactionId; }
    public void setPixTransactionId(String pixTransactionId) { this.pixTransactionId = pixTransactionId; }

    public String getBankOrigin() { return bankOrigin; }
    public void setBankOrigin(String bankOrigin) { this.bankOrigin = bankOrigin; }

    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }

    public Date getDueDate() { return dueDate; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

    public String getBankSlipUrl() { return bankSlipUrl; }
    public void setBankSlipUrl(String bankSlipUrl) { this.bankSlipUrl = bankSlipUrl; }
}