package com.shopingOnline.virtualShopping.components.dtos;

import com.shopingOnline.virtualShopping.entity.Client;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class ClientAdressDto {
    private Long id;
    private String city;
    private String state;
    private ClientDto client;
}
