package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.dtos.OrderItemDto;
import com.shopingOnline.virtualShopping.components.dtos.ProductDto;
import com.shopingOnline.virtualShopping.components.itemOrder.ItemOrderComponet;
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
    private ItemOrderComponet component;
    @Autowired
    ClientValidationAdressUtil adressValidation;
    @Autowired
    private Components productComponent;

    public OrderItemDto save(OrderSave data) {
        validtion.ValidateProductsOrders(data);
        ClientValidationUtil.validateClientExistById(clientRepository,data.getUser());
        adressValidation.validateAdressExist(data.getAdress());

        //separa os produtos e salvar e aguardar o pagamento para os trabalh.. separarem
        //pedido processando =  usa quando esta aguardando pagamento
        Client client = clientRepository.findById(data.getUser()).get();
        ClientAdress adress = adressRepository.findById(data.getAdress()).get();
        List<ItemOrder> itemOrdes = component.ItemOrderSave_to_ItemOrders(data.getItems());

        Order orderInstance = new Order(itemOrdes, client, adress, OrderStatus.DRAFT, OrderStatus.AWAITING_PAYMENT ,data.getTotalPrice());
        Order save =  repository.save(orderInstance);
        List<ProductDto> dtosProduct = productComponent.listDtoProductItems(save.getItems());
        OrderItemDto dd = new OrderItemDto(dtosProduct);
        return mapper.map(dtosProduct, OrderItemDto.class);
    }



}
