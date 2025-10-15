package com.shopingOnline.virtualShopping.entity;

import com.shopingOnline.virtualShopping.components.serializer.ItemOrderSave;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "item_order")
public class ItemOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private int quantity;
    private Double unicPrice;
    private Double discount; //frete
    private String size;
    private String color;


    public ItemOrder(Long id, Product product, int quantity, Double unicPrice, Double discount, String size, String color) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unicPrice = unicPrice;
        this.discount = discount;
        this.size = size;
        this.color = color;
    }

    public ItemOrder(ItemOrderSave i
                     ) {
        this.quantity = i.getQuantity();
        this.unicPrice = i.getUnicPrice();
        this.discount = i.getDiscount();
        this.size = i.getSize();
        this.color = i.getColor();
    }

    public Double getUnicPrice() {
        return unicPrice;
    }

    public void setUnicPrice(Double unicPrice) {
        this.unicPrice = unicPrice;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
