package com.shopingOnline.virtualShopping.components.serializer;

import com.shopingOnline.virtualShopping.entity.Product;
import jakarta.persistence.ManyToOne;

public class ItemOrderSave {
    private Long productId;
    private int quantity;
    private Double unicPrice;
    private Double discount;

    public ItemOrderSave(Long productId, int quantity, Double unicPrice, Double discount) {
        this.productId = productId;
        this.quantity = quantity;
        this.unicPrice = unicPrice;
        this.discount = discount;
    }

    public ItemOrderSave() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getUnicPrice() {
        return unicPrice;
    }

    public void setUnicPrice(Double unicPrice) {
        this.unicPrice = unicPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
