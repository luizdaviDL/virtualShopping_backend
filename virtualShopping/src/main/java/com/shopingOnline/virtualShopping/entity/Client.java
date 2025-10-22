package com.shopingOnline.virtualShopping.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String passWord;
    @OneToMany(mappedBy = "client")
    private List<ClientAdress> adresses;

    public Client(long id, String name, String email, String passWord) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passWord = passWord;
    }

    public Client() {
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

    public List<ClientAdress> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<ClientAdress> adresses) {
        this.adresses = adresses;
    }
   
}
