package com.shopingOnline.virtualShopping.components.validationsUtil.orderItem;

import com.shopingOnline.virtualShopping.components.exceptions.BusinessException;
import com.shopingOnline.virtualShopping.entity.ItemOrder;
import com.shopingOnline.virtualShopping.entity.Product;
import com.shopingOnline.virtualShopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderItemValidationAdressUtil {
    @Autowired
    private ProductRepository productRepository;

    public void ValidateProductsExiste(List<ItemOrder> itens) {
        for (ItemOrder item : itens) {
            // 1. Verificar se o produto existe no banco de dados (estoque)
            Product product = productRepository.findById(item.getProduct()).orElse(null);

            if (product == null) {
                throw new BusinessException("Produto com ID " + item.getProduct() + " não encontrado.");
            }

            // 3. Verificar se a quantidade solicitada é maior que a quantidade disponível no estoque
            if (item.getQuantity() > product.getStock()) {
                throw new BusinessException("Quantidade insuficiente para o produto: " + product.getName());
            }
        }
    }
}
