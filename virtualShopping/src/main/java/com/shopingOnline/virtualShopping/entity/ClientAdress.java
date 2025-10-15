package com.shopingOnline.virtualShopping.entity;

import com.shopingOnline.virtualShopping.components.serializer.ClientAdressSave;
import jakarta.persistence.*;

@Entity
@Table(name = "client_adress")
public class ClientAdress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adress;
    private String cep;
    private String numberHome;
    private String complementAdress;
    private String neighborhood;
    private String city;
    private String state;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    public ClientAdress(Long id, String adress, String cep, String numberHome, String complementAdress, String neighborhood, String city, String state, Client client) {
        this.id = id;
        this.adress = adress;
        this.cep = cep;
        this.numberHome = numberHome;
        this.complementAdress = complementAdress;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.client = client;
    }

    public ClientAdress() {
    }

    public ClientAdress(ClientAdressSave data, Client getClient) {
        this.adress = data.getAdress();
        this.cep = data.getCep();
        this.numberHome = data.getNumberHome();
        this.complementAdress = data.getComplementAdress();
        this.neighborhood = data.getNeighborhood();
        this.city = data.getCity();
        this.state = data.getState();
        this.client = getClient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumberHome() {
        return numberHome;
    }

    public void setNumberHome(String numberHome) {
        this.numberHome = numberHome;
    }

    public String getComplementAdress() {
        return complementAdress;
    }

    public void setComplementAdress(String complementAdress) {
        this.complementAdress = complementAdress;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
