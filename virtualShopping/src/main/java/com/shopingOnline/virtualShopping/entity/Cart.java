package com.shopingOnline.virtualShopping.entity;

import java.util.List;

public class Cart {
    private Long id;
    private List<Product> products;
    private Client client;
    private String total;

    public Cart(Long id, List<Product> products, Client client, String total) {
        this.id = id;
        this.products = products;
        this.client = client;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
