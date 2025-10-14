package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.dtos.OrderDto;
import com.shopingOnline.virtualShopping.components.dtos.OrderItemDto;
import com.shopingOnline.virtualShopping.components.dtos.ProductDto;
import com.shopingOnline.virtualShopping.components.itemOrder.ItemOrderComponet;
import com.shopingOnline.virtualShopping.components.order.OrderComponent;
import com.shopingOnline.virtualShopping.components.product.Components;
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
    @Autowired
    private ItemOrderComponet itemOrdercomponent;
    @Autowired
    ClientValidationAdressUtil adressValidation;
    @Autowired
    private OrderComponent orderComponent;
    @Autowired
    private Components productComponent;

    public OrderDto save(OrderSave data) {
        //verifuicar se ja exuiste os itens pedidos para o mesmo cliente, o mesmo não pode sazer o mesmo pedido duplicado
       // Order order = repository.findByClient(data.getUser());

        validtion.ValidateProductsOrders(data);
        ClientValidationUtil.validateClientExistById(clientRepository,data.getUser());
        adressValidation.validateAdressExist(data.getAdress());

        Client client = clientRepository.findById(data.getUser()).get();
        ClientAdress adress = adressRepository.findById(data.getAdress()).get();
        List<ItemOrder> itemOrdes = itemOrdercomponent.ItemOrderSave_to_ItemOrders(data.getItems());

        Order orderInstance = new Order(itemOrdes, client, adress, OrderStatus.DRAFT, OrderStatus.AWAITING_PAYMENT ,data.getTotalPrice());
        Order save =  repository.save(orderInstance);
        return  orderComponent.orderDto(save);
    }



}
