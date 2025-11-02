package com.shopingOnline.virtualShopping.components.validationsUtil.payment;

import com.shopingOnline.virtualShopping.components.exceptions.BusinessException;
import com.shopingOnline.virtualShopping.components.serializer.PaymentSave;
import com.shopingOnline.virtualShopping.entity.Order;
import com.shopingOnline.virtualShopping.enums.OrderStatus;
import com.shopingOnline.virtualShopping.enums.PaymentStatus;
import com.shopingOnline.virtualShopping.repository.OrderRepository;
import com.shopingOnline.virtualShopping.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
@Component
public class PaymentValidationUtil {
    @Autowired
    private PaymentRepository repository;
    @Autowired
    private OrderRepository orderRepository;

    public void validatePaymentData(PaymentSave data) {

        if (data.getOrder() == null) {
            throw new IllegalArgumentException("Order is required");
        }

        if (data.getTypePayment() == null) {
            throw new IllegalArgumentException("Payment type is required");
        }

        if (data.getValue().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero");
        }

        if (data.getDeviceFingerprint() == null || data.getDeviceFingerprint().trim().isEmpty()) {
            throw new IllegalArgumentException("Device fingerprint is required for security");
        }

        if (data.getIpAddress() == null || data.getIpAddress().trim().isEmpty()) {
            throw new IllegalArgumentException("IP address is required for security");
        }

        // ✅ Validate data specific to each payment type
        validatePaymentTypeSpecificData(data);
    }

    public void validatePaymentTypeSpecificData(PaymentSave data) {
        switch (data.getTypePayment()) {
            case PIX:
                if (data.getPixKey() == null || data.getPixKey().trim().isEmpty()) {
                    throw new IllegalArgumentException("PIX key is required for PIX payments");
                }
                break;

            case CREDIT_CARD:
                if (data.getCardLastDigits() == null || data.getCardLastDigits().length() != 4) {
                    throw new IllegalArgumentException("Last 4 digits of the card are required");
                }
                break;

            case BOLETO:
                if (data.getBarcode() == null || data.getBarcode().trim().isEmpty()) {
                    throw new IllegalArgumentException("Barcode is required for boleto payments");
                }
                break;
        }
    }

    public Order findAndValidateOrder(Long orderData) {

        Order order = orderRepository.findById(orderData)
                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + orderData));

        // Check if the order is already paid
        if (order.getStatusPayment().equals(PaymentStatus.PAIED)) {
            throw new IllegalStateException("Order is already paid");
        }

        // Check if the order is canceled
        if (order.getStatusPayment().equals(PaymentStatus.CANCELLED)) {
            throw new IllegalStateException("Cannot pay a canceled order");
        }

        return order;
    }

    public void checkExistingPayment(Order order) {
        boolean existingPayment = repository.existsByOrderAndStatusPaymentIn(
                order,
                Arrays.asList(PaymentStatus.PENDING, PaymentStatus.PROCESSING, PaymentStatus.APPROVED)
        );

        if (existingPayment) {
            throw new IllegalStateException("There is already a payment in progress for this order");
        }
    }

    public void validatePaymentAmount(BigDecimal paymentAmount, BigDecimal orderAmount) {
        BigDecimal difference = paymentAmount.subtract(orderAmount).abs();
        BigDecimal tolerance = new BigDecimal("0.01"); // 1 cent tolerance

        if (difference.compareTo(tolerance) > 0) {
            throw new IllegalArgumentException(
                    String.format("Payment amount (R$ %.2f) does not match the order amount (R$ %.2f)",
                            paymentAmount, orderAmount)
            );
        }
    }




}
