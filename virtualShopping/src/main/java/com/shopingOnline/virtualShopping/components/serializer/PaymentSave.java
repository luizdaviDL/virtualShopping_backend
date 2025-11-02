package com.shopingOnline.virtualShopping.components.serializer;

import com.shopingOnline.virtualShopping.entity.Order;
import com.shopingOnline.virtualShopping.enums.PaymentStatus;
import com.shopingOnline.virtualShopping.enums.PaymentType;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentSave {
    private Long id;
    private Long order;
    private PaymentType typePayment;
    private PaymentStatus statusPayment;
    private BigDecimal value;
    private String deviceFingerprint; // Hash do dispositivo
    private String ipAddress; // IP do cliente
    private String userAgent; // Navegador/SO
    private String location; // Cidade/Estado baseado no IP
    // DADOS TRANSACTIONAIS COMUNS
    private String transactionId;
    private Date paymentDate;
    private Date createdAt;

    // CAMPOS ESPECÍFICOS (podem ser NULL)
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

    public PaymentSave() {
    }

    public PaymentSave(Long order,
                       PaymentType typePayment,
                       PaymentStatus statusPayment,
                       BigDecimal value,
                       String deviceFingerprint,
                       String ipAddress,
                       String userAgent,
                       String location,
                       String transactionId,
                       Date paymentDate,
                       Date createdAt,
                       String cardBrand,
                       String cardLastDigits,
                       String pixKey,
                       String pixKeyType,
                       String pixTransactionId,
                       String bankOrigin,
                       String barcode,
                       Date dueDate,
                       String bankSlipUrl) {
        this.order = order;
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
        this.cardBrand = cardBrand;
        this.cardLastDigits = cardLastDigits;
        this.pixKey = pixKey;
        this.pixKeyType = pixKeyType;
        this.pixTransactionId = pixTransactionId;
        this.bankOrigin = bankOrigin;
        this.barcode = barcode;
        this.dueDate = dueDate;
        this.bankSlipUrl = bankSlipUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
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

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    public String getPixKey() {
        return pixKey;
    }

    public void setPixKey(String pixKey) {
        this.pixKey = pixKey;
    }

    public String getPixKeyType() {
        return pixKeyType;
    }

    public void setPixKeyType(String pixKeyType) {
        this.pixKeyType = pixKeyType;
    }

    public String getPixTransactionId() {
        return pixTransactionId;
    }

    public void setPixTransactionId(String pixTransactionId) {
        this.pixTransactionId = pixTransactionId;
    }

    public String getBankOrigin() {
        return bankOrigin;
    }

    public void setBankOrigin(String bankOrigin) {
        this.bankOrigin = bankOrigin;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getBankSlipUrl() {
        return bankSlipUrl;
    }

    public void setBankSlipUrl(String bankSlipUrl) {
        this.bankSlipUrl = bankSlipUrl;
    }
}
