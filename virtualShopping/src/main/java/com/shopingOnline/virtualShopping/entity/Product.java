package com.shopingOnline.virtualShopping.entity;

import java.util.List;

public class Product {
    private Long id;
    private String name;
    private String descripion;
    private double price;
    private int stock;
    private List<String> colores;
    private List<String> size;

    public Product(Long id, String name, String descripion, double price, int stock, List<String> colores, List<String> size) {
        this.id = id;
        this.name = name;
        this.descripion = descripion;
        this.price = price;
        this.stock = stock;
        this.colores = colores;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<String> getColores() {
        return colores;
    }

    public void setColores(List<String> colores) {
        this.colores = colores;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }
}
