package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.dtos.*;
import com.shopingOnline.virtualShopping.components.itemOrder.ItemOrderComponet;
import com.shopingOnline.virtualShopping.components.order.OrderComponent;
import com.shopingOnline.virtualShopping.components.product.Components;
import com.shopingOnline.virtualShopping.components.serializer.OrderSave;
import com.shopingOnline.virtualShopping.components.validationsUtil.client.ClientValidationAdressUtil;
import com.shopingOnline.virtualShopping.components.validationsUtil.client.ClientValidationUtil;
import com.shopingOnline.virtualShopping.components.validationsUtil.order.OrderValidationUtil;
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
    private UserBehaviorRepository behaviorRepository;
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
    @Autowired
    private OrderValidationUtil orderValidation;

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
        for (ItemOrder item : itemOrdes) {
            Product product = item.getProduct();
            int updatedQuantity = product.getStock() - item.getQuantity();
            product.setStock(updatedQuantity);
            productRepository.save(product);
        }
        orderInstance.setItems(itemOrdes);
        Order save =  repository.save(orderInstance);
        UserBehavior behavior = new UserBehavior(save.getId(), save.getTotalPrice(), save.getDate());
        behaviorRepository.save(behavior);
        return  orderComponent.orderDto(save);
    }

    public List<OrderDto> getAll(){
        List<Order> orders = repository.findAll();
        return orderComponent.orderDto_list(orders);
    }

    public OrderDto update(OrderSave data) {
        orderValidation.validateOrderExist(data.getId());
        Order order = repository.findById(data.getId()).get();
        order.setStatus(data.getStatus());
        Order updated = repository.save(order);
        return orderComponent.orderDto(updated);
    }

    public List<OrderDto> delete(OrderSave data) {
        orderValidation.validateOrderExist(data.getId());
        Order order = repository.findById(data.getId()).get();

        if (order.getStatus() != OrderStatus.DRAFT) {
            throw new IllegalStateException("Just ordes with status DRAFT could be delete.");
        }

        repository.deleteById(data.getId());
        return getAll();
    }


}
