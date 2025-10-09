package com.shopingOnline.virtualShopping.components.validationsUtil.orderItem;

import com.shopingOnline.virtualShopping.components.exceptions.BusinessException;
import com.shopingOnline.virtualShopping.components.serializer.OrderSave;
import com.shopingOnline.virtualShopping.entity.ItemOrder;
import com.shopingOnline.virtualShopping.entity.Product;
import com.shopingOnline.virtualShopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OrderItemValidationUtil {
    @Autowired
    private ProductRepository productRepository;

    public void ValidateProductsOrders(OrderSave data) {
        for(ItemOrder i: data.getItems()){
            Optional<Product> product = productRepository.findById(i.getProduct().getId());
            if(product.isEmpty()){
                throw new BusinessException("Product with id: "+ i.getProduct().getId() + " not exist");
            }
            if(i.getQuantity() > product.get().getStock()){
                throw new BusinessException("the stock is not enougth to product id: "+ i.getProduct().getId());
            }

            if(!i.getUnicPrice().equals(product.get().getPrice())){
                throw new BusinessException("the price is not update to product id: "+ i.getProduct().getId());
            }
        }
    }
}
