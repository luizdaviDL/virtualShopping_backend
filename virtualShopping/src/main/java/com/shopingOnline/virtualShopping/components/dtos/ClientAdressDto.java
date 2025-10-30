package com.shopingOnline.virtualShopping.components.dtos;

import com.shopingOnline.virtualShopping.entity.Client;
import com.shopingOnline.virtualShopping.entity.ClientAdress;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class ClientAdressDto {
    private Long id;
    private String city;
    private String state;
    private String cep;
    private String adress;
    private String numberHome;
    private String complement;
    private String neighborhood;
    private String country;
    private ClientDto client;

    public ClientAdressDto(Long id, String city, String state, String cep, String adress, String houseNumber, String complement, String neighborhood, String country,ClientDto client) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.cep = cep;
        this.adress = adress;
        this.numberHome = houseNumber;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.country = country;
        this.client = client;
    }

    public ClientAdressDto() {
    }

    public ClientAdressDto(ClientAdress save, ClientDto clientDto) {
        this.id = save.getId();
        this.city = save.getCity();
        this.state = save.getState();
        this.cep = save.getCep();
        this.adress = save.getAdress();
        this.numberHome = save.getNumberHome();
        this.complement = save.getComplementAdress();
        this.neighborhood = save.getNeighborhood();
        this.country = save.getCountry();
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNumberHome() {
        return numberHome;
    }

    public void setNumberHome(String numberHome) {
        this.numberHome = numberHome;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
