package com.shopingOnline.virtualShopping.components.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shopingOnline.virtualShopping.components.serializer.ItemOrderSave;
import com.shopingOnline.virtualShopping.entity.ItemOrder;
import com.shopingOnline.virtualShopping.entity.Order;
import com.shopingOnline.virtualShopping.entity.Product;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemDto {
    private Long id;
    private String name;
    private ItemOrderSave product;
    private int quantity;
    private Double unicPrice;
    private Double discount;
    private String color;
    private String size;
    private CategoryDto category;

    public OrderItemDto(Long id, ItemOrderSave product, int quantity, Double unicPrice, Double discount) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unicPrice = unicPrice;
        this.discount = discount;
    }

    public OrderItemDto() {
    }

    public OrderItemDto(Product product, ItemOrder i, CategoryDto category) {
        this.id = product.getId();
        this.name = product.getName();
        this.color = i.getColor();
        this.size = i.getSize();
        this.quantity = i.getQuantity();
        this.category = category;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemOrderSave getProduct() {
        return product;
    }
;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public void setProduct(ItemOrderSave product) {
        this.product = product;
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
