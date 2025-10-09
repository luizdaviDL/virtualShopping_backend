package com.shopingOnline.virtualShopping.components.validationsUtil.payment;

import com.shopingOnline.virtualShopping.components.exceptions.BusinessException;
import com.shopingOnline.virtualShopping.entity.Payment;
import com.shopingOnline.virtualShopping.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PaymentValidationUtil {
    @Autowired
    private PaymentRepository repository;

    public void validatePaymentExistById(Long id) {
        Optional<Payment> getPayment = repository.findById(id);
        if (getPayment.isEmpty()) {
            throw new BusinessException("This payment not exist in the data base: " + id);
        }

    }
}
