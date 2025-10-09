package com.shopingOnline.virtualShopping.components.validationsUtil.payment;

import com.shopingOnline.virtualShopping.components.exceptions.BusinessException;
import com.shopingOnline.virtualShopping.entity.Client;
import com.shopingOnline.virtualShopping.repository.ClientRepository;
import com.shopingOnline.virtualShopping.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class Payment {
    @Autowired
    private static PaymentRepository repository;
    public static void validatePaymentExistById(Long id) {
        Optional<Payment> findCatedory = repository.findById(id);
        if (findCatedory.isEmpty()) {
            throw new BusinessException("Client does not exist in the database: " + id);
        }

    }
}
