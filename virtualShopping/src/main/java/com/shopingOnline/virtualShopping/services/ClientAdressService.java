package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.dtos.ClientAdressDto;
import com.shopingOnline.virtualShopping.components.serializer.ClientAdressSave;
import com.shopingOnline.virtualShopping.components.validationsUtil.client.ClientValidationAdressUtil;
import com.shopingOnline.virtualShopping.entity.ClientAdress;
import com.shopingOnline.virtualShopping.repository.ClientAdressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientAdressService {
    @Autowired
    private ClientAdressRepository repository;
    @Autowired
    private ModelMapper mapper;

    public ClientAdressDto save(ClientAdressSave data) {
        //ciente pode ter varios endereços por cep
        //deve ter pelo menos um dos indereços como principal
        ClientValidationAdressUtil.validateAdressExist(repository, data.getCep());
        ClientAdress instance = mapper.map(data, ClientAdress.class);
        ClientAdress save = repository.save(instance);
        return null;

    }
}
