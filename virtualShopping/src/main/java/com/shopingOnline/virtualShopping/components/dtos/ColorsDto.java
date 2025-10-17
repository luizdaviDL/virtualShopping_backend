package com.shopingOnline.virtualShopping.components.dtos;

public class ColorsDto {
    private String name;
    private String value;

    public ColorsDto() {
    }

    public ColorsDto(String name, String value) {
        this.name = name;
        this.value = value;
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
