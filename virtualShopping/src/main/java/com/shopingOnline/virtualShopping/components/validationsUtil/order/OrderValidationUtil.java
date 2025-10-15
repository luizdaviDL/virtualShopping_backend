package com.shopingOnline.virtualShopping.components.validationsUtil.order;

import com.shopingOnline.virtualShopping.components.exceptions.BusinessException;
import com.shopingOnline.virtualShopping.entity.Order;
import com.shopingOnline.virtualShopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
@Component
public class OrderValidationUtil {
    @Autowired
    private OrderRepository repository;

    public  void validateOrderExist(Long id){
        Optional<Order> order = repository.findById(id);
        if(order.isEmpty()){
            throw new BusinessException("this order not exist in the data base" );
        }
    }
}
