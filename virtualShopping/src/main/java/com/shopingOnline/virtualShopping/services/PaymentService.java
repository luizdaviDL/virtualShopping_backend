package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.dtos.PaymentDto;
import com.shopingOnline.virtualShopping.components.payment.PaymentComponents;
import com.shopingOnline.virtualShopping.components.serializer.PaymentSave;
import com.shopingOnline.virtualShopping.components.validationsUtil.payment.PaymentValidationUtil;
import com.shopingOnline.virtualShopping.entity.Order;
import com.shopingOnline.virtualShopping.entity.Payment;
import com.shopingOnline.virtualShopping.repository.OrderRepository;
import com.shopingOnline.virtualShopping.repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository repository;
    @Autowired
    private PaymentValidationUtil validationUtil;
    @Autowired
    private PaymentComponents paymentComponents;
    @Autowired
    private ModelMapper mapper;


    public PaymentDto save(PaymentSave data) {
        validationUtil.validatePaymentData(data);
        Order order = validationUtil.findAndValidateOrder(data.getOrder());

        validationUtil.checkExistingPayment(order);

        validationUtil.validatePaymentAmount(data.getValue(), order.getTotalPrice());
        Payment payment = paymentComponents.createPaymentEntity(data, order);
        return mapper.map(payment, PaymentDto.class);
    }
}
