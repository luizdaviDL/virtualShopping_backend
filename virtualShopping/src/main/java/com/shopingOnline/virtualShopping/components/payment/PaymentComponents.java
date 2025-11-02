package com.shopingOnline.virtualShopping.components.payment;

import com.shopingOnline.virtualShopping.components.serializer.PaymentSave;
import com.shopingOnline.virtualShopping.entity.Order;
import com.shopingOnline.virtualShopping.entity.Payment;
import com.shopingOnline.virtualShopping.enums.PaymentStatus;
import com.shopingOnline.virtualShopping.enums.PaymentType;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PaymentComponents
{
    public Payment createPaymentEntity(PaymentSave data, Order order) {
        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setTypePayment(data.getTypePayment());
        payment.setStatusPayment(PaymentStatus.PENDING); // Sempre inicia como pendente
        payment.setValue(data.getValue());

        // Dados para detecção de fraude
        payment.setDeviceFingerprint(data.getDeviceFingerprint());
        payment.setIpAddress(data.getIpAddress());
        payment.setUserAgent(data.getUserAgent());
        payment.setLocation(data.getLocation());

        // Dados transacionais
        payment.setTransactionId(generateTransactionId());
        payment.setCreatedAt(new Date());

        // Dados específicos por tipo de pagamento
        setPaymentTypeSpecificData(payment, data);

        return payment;
    }

    private String generateTransactionId() {
        return "TXN_" + System.currentTimeMillis() + "_" +
                java.util.UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private boolean shouldProcessImmediately(PaymentType type) {
        // PIX e Cartão processam imediatamente, Boleto fica pendente
        return type == PaymentType.PIX || type == PaymentType.CREDIT_CARD;
    }

    private void setPaymentTypeSpecificData(Payment payment, PaymentSave data) {
        switch (data.getTypePayment()) {
            case PIX:
                payment.setPixKey(data.getPixKey());
                payment.setPixKeyType(data.getPixKeyType());
                payment.setBankOrigin(data.getBankOrigin());
                break;

            case CREDIT_CARD:
                payment.setCardBrand(data.getCardBrand());
                payment.setCardLastDigits(data.getCardLastDigits());
                break;

            case BOLETO:
                payment.setBarcode(data.getBarcode());
                payment.setDueDate(data.getDueDate());
                payment.setBankSlipUrl(data.getBankSlipUrl());
                break;
        }
    }
}
