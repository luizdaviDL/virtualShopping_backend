package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.dtos.*;
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

import java.util.ArrayList;
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
    @Autowired
    private ItemOrderRepository itemOrderRepository;

    public OrderDto save(OrderSave data) {
        //verifuicar se ja exuiste os itens pedidos para o mesmo cliente, o mesmo não pode sazer o mesmo pedido duplicado
       // Order order = repository.findByClient(data.getUser());

        validtion.ValidateProductsOrders(data);
        ClientValidationUtil.validateClientExistById(clientRepository,data.getUser());
        adressValidation.validateAdressExist(data.getAdress());

        Client client = clientRepository.findById(data.getUser()).get();
        ClientAdress adress = adressRepository.findById(data.getAdress()).get();
        Order orderInstance = new Order(client, adress, OrderStatus.DRAFT, OrderStatus.AWAITING_PAYMENT ,data.getTotalPrice());
        Order savedOrder = repository.save(orderInstance);
        List<ItemOrder> itemOrdes = itemOrdercomponent.ItemOrderSave_to_ItemOrders(data.getItems(), savedOrder);
        orderInstance.setItems(itemOrdes);
        Order save =  repository.save(orderInstance);
        return  orderComponent.orderDto(save);
    }

    public List<OrderDto> getAll(){
        List<OrderDto> dtos= new ArrayList<>();
        List<Order> orders = repository.findAll();

        for(Order i: orders){
            List<ItemOrder> items = itemOrderRepository.findByProduct(i.getId());
            Client client = itemOrderRepository.finByClient(i.getId());
            ClientAdress adress = adressRepository.findByClient(client.getId());
            //ClientDto client = mapper.map(i.getClient(), ClientDto.class);
            List<OrderItemDto> itmems = itemOrdercomponent.list_itemsOrderDto(i);

            //ClientAdressDto adress = mapper.map(i.getClient(), ClientAdressDto.class);

        }
        return null;
    }


}
