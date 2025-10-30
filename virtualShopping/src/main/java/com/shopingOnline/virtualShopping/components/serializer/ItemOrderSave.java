package com.shopingOnline.virtualShopping.components.serializer;

import java.math.BigDecimal;

public class ItemOrderSave {
    private Long productId;
    private int quantity;
    private BigDecimal unicPrice;
    private BigDecimal discount;
    private String size;
    private Long color;

    public ItemOrderSave(Long productId, int quantity, BigDecimal unicPrice, BigDecimal discount, String size, Long color) {
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

    public BigDecimal getUnicPrice() {
        return unicPrice;
    }

    public void setUnicPrice(BigDecimal unicPrice) {
        this.unicPrice = unicPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getColor() {
        return color;
    }

    public void setColor(Long color) {
        this.color = color;
    }
}
