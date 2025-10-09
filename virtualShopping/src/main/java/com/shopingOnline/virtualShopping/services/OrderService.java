package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.dtos.OrderItemDto;
import com.shopingOnline.virtualShopping.components.serializer.OrderSave;
import com.shopingOnline.virtualShopping.components.validationsUtil.client.ClientValidationUtil;
import com.shopingOnline.virtualShopping.components.validationsUtil.orderItem.OrderItemValidationUtil;
import com.shopingOnline.virtualShopping.entity.Client;
import com.shopingOnline.virtualShopping.entity.ItemOrder;
import com.shopingOnline.virtualShopping.entity.Payment;
import com.shopingOnline.virtualShopping.repository.ClientRepository;
import com.shopingOnline.virtualShopping.repository.OrderRepository;
import com.shopingOnline.virtualShopping.repository.PaymentRepository;
import com.shopingOnline.virtualShopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderItemValidationUtil validtion;
    @Autowired
    private ClientValidationUtil clientValidtion;
    @Autowired
    private PaymentRepository paymentRepository;

    public OrderItemDto save(OrderSave data) {
        validtion.ValidateProductsOrders(data);
        clientValidtion.validateClientExistById(clientRepository,data.getUser().getId());

        if(data.getPaymentStatus().equals("PAID")){
            //buscar: user, payment
            Client client = clientRepository.findById(data.getUser().getId()).get();
            Optional<Payment> payment = paymentRepository.findById(data.getPaymentId());
            //clientRepository
            //update: estoque
            //add: produto do user

        }
        //verificar se tem relamente pedidos
        //se itens pedidos estão em estoque

        //valdar preço atual
        //se pagamento foi confirmado
        //limit de credito(
        //descontos
        //ItemOrder item  productRepository

    }
}
