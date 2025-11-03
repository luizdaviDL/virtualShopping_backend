package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.dtos.OrderDto;
import com.shopingOnline.virtualShopping.components.dtos.PaymentDto;
import com.shopingOnline.virtualShopping.components.payment.PaymentComponents;
import com.shopingOnline.virtualShopping.components.serializer.PaymentSave;
import com.shopingOnline.virtualShopping.components.validationsUtil.payment.PaymentValidationUtil;
import com.shopingOnline.virtualShopping.entity.ClientInformation;
import com.shopingOnline.virtualShopping.entity.Order;
import com.shopingOnline.virtualShopping.entity.Payment;
import com.shopingOnline.virtualShopping.entity.UserBehavior;
import com.shopingOnline.virtualShopping.repository.ClientInformationRepository;
import com.shopingOnline.virtualShopping.repository.OrderRepository;
import com.shopingOnline.virtualShopping.repository.PaymentRepository;
import com.shopingOnline.virtualShopping.repository.UserBehaviorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserBehaviorRepository userBehaviorRepository;
    @Autowired
    private ClientInformationRepository clientInformationRepository;


    public PaymentDto save(PaymentSave data) {
        validationUtil.validatePaymentData(data);
        Order order = validationUtil.findAndValidateOrder(data.getOrder());

        validationUtil.checkExistingPayment(order);

        validationUtil.validatePaymentAmount(data.getValue(), order.getTotalPrice());
        Payment payment = paymentComponents.createPaymentEntity(data, order);
        repository.save(payment);
        Optional<Order> orderData = orderRepository.findById(payment.getOrder().getId());
        Order orderUpdate = orderData.orElseThrow(() -> new IllegalArgumentException("Order not found with ID: " + payment.getOrder().getId()));

        orderUpdate.setStatusPayment(payment.getStatusPayment());
        orderRepository.save(orderUpdate);

        PaymentDto dto = new PaymentDto();
        dto.setId(payment.getId());
        dto.setOrder(payment.getOrder().getId());
        dto.setTypePayment(payment.getTypePayment());
        dto.setStatusPayment(payment.getStatusPayment());
        dto.setValue(payment.getValue());
        dto.setDeviceFingerprint(payment.getDeviceFingerprint());
        dto.setIpAddress(payment.getIpAddress());
        dto.setUserAgent(payment.getUserAgent());
        dto.setLocation(payment.getLocation());
        dto.setTransactionId(payment.getTransactionId());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setCreatedAt(payment.getCreatedAt());
        dto.setOrder(order.getId());

        Optional<UserBehavior> behavier = userBehaviorRepository.findByClientId(payment.clientId());
        if(behavier.isPresent()){
            if(payment.getOrder().getClient().getId()== behavier.get().getClient().getId() && payment.getValue() == behavier.get().getTotalShopping()){
                behavier.get().setPaymentTye(payment.getTypePayment());
                userBehaviorRepository.save(behavier);
            }
        }

        return dto;
    }
}
