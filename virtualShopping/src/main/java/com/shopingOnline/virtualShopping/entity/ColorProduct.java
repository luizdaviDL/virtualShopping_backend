package com.shopingOnline.virtualShopping.entity;

import com.shopingOnline.virtualShopping.components.serializer.ColorProductSave;
import jakarta.persistence.*;

@Entity
@Table(name = "color_product")
public class ColorProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String value;

    public ColorProduct() {
    }

    public ColorProduct(Long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public ColorProduct(ColorProductSave i) {
        this.name = i.getName();
        this.value = i.getValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
