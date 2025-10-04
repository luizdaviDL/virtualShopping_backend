package com.shopingOnline.virtualShopping.components.client;

import com.shopingOnline.virtualShopping.components.dtos.ClientDto;
import com.shopingOnline.virtualShopping.entity.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientComponents {
    @Autowired
    private ModelMapper mapper;

    public List<ClientDto> listClientDto(List<Client> data) {
        ArrayList<ClientDto> list = new ArrayList<>();
        for(Client i : data){
            list.add(mapper.map(i, ClientDto.class));
        }
        return list;

    }
}
