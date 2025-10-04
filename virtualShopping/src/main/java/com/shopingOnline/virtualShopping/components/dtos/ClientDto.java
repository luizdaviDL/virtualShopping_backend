package com.shopingOnline.virtualShopping.components.dtos;

public class ClientDto {
    private long id;
    private String name;
    private String email;

    public ClientDto(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public ClientDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
