package com.shopingOnline.virtualShopping.components.dtos;

import com.shopingOnline.virtualShopping.entity.Client;
import com.shopingOnline.virtualShopping.entity.ClientAdress;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class ClientAdressDto {
    private Long id;
    private String city;
    private String state;
    private ClientDto client;

    public ClientAdressDto(Long id, String city, String state, ClientDto client) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.client = client;
    }

    public ClientAdressDto() {
    }

    public ClientAdressDto(ClientAdress save, ClientDto clientDto) {
        this.id = save.getId();
        this.city = save.getCity();
        this.state = save.getState();
        this.client = clientDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }
}
