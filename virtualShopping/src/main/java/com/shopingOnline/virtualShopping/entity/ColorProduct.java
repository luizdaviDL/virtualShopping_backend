package com.shopingOnline.virtualShopping.entity;

import com.shopingOnline.virtualShopping.components.serializer.ColorProductSave;
import jakarta.persistence.Embeddable;

@Embeddable
public class ColorProduct {
    private String name;
    private String value;

    public ColorProduct() {
    }

    public ColorProduct(String name, String value) {
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

    public void setValue(String value) {
        this.value = value;
    }
}
