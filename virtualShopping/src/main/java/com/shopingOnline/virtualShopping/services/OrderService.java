package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.dtos.OrderItemDto;
import com.shopingOnline.virtualShopping.components.serializer.OrderSave;
import com.shopingOnline.virtualShopping.components.validationsUtil.client.ClientValidationAdressUtil;
import com.shopingOnline.virtualShopping.components.validationsUtil.client.ClientValidationUtil;
import com.shopingOnline.virtualShopping.components.validationsUtil.orderItem.OrderItemValidationUtil;
import com.shopingOnline.virtualShopping.components.validationsUtil.payment.PaymentValidationUtil;
import com.shopingOnline.virtualShopping.entity.*;
import com.shopingOnline.virtualShopping.enums.OrderStatus;
import com.shopingOnline.virtualShopping.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
    private ClientAdressRepository adressRepository;
    @Autowired
    private OrderItemValidationUtil validtion;
    @Autowired
    private PaymentValidationUtil validtionPayment;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ModelMapper mapper;

    public OrderItemDto save(OrderSave data) {
        validtion.ValidateProductsOrders(data);
        ClientValidationUtil.validateClientExistById(clientRepository,data.getUser().getId());
        ClientValidationAdressUtil.validateAdressExist(data.getAdress());

        //separa os produtos e salvar e aguardar o pagamento para os trabalh.. separarem
        //pedido processando =  usa quando esta aguardando pagamento
        Client client = clientRepository.findById(data.getUser().getId()).get();
        ClientAdress adress = adressRepository.findById(data.getAdress()).get();

        Order orderInstance = new Order(data.getItems(), client, adress, OrderStatus.AWAITING_PAYMENT);
        Order save =  repository.save(orderInstance);
        return mapper.map(save, OrderItemDto.class);
    }



}
