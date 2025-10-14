package com.shopingOnline.virtualShopping.components.serializer;

import com.shopingOnline.virtualShopping.entity.Product;
import jakarta.persistence.ManyToOne;

public class ItemOrderSave {
    private Long productId;
    private int quantity;
    private Double unicPrice;
    private Double discount;
    private String size;
    private String color;

    public ItemOrderSave(Long productId, int quantity, Double unicPrice, Double discount, String size, String color) {
        this.productId = productId;
        this.quantity = quantity;
        this.unicPrice = unicPrice;
        this.discount = discount;
        this.size = size;
        this.color = color;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
