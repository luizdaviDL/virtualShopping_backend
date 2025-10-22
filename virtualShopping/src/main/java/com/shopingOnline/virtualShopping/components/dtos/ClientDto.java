package com.shopingOnline.virtualShopping.components.dtos;

public class ClientDto {
    private long id;
    private String name;
    private String email;
    private String passWord;

    public ClientDto(long id, String name, String email, String passWord) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passWord = passWord;
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
