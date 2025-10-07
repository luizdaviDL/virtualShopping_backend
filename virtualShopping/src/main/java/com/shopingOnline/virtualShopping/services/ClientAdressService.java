package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.dtos.ClientAdressDto;
import com.shopingOnline.virtualShopping.components.dtos.ClientDto;
import com.shopingOnline.virtualShopping.components.serializer.ClientAdressSave;
import com.shopingOnline.virtualShopping.components.validationsUtil.client.ClientValidationAdressUtil;
import com.shopingOnline.virtualShopping.components.validationsUtil.client.ClientValidationUtil;
import com.shopingOnline.virtualShopping.entity.Client;
import com.shopingOnline.virtualShopping.entity.ClientAdress;
import com.shopingOnline.virtualShopping.repository.ClientAdressRepository;
import com.shopingOnline.virtualShopping.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientAdressService {
    @Autowired
    private ClientAdressRepository repository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ModelMapper mapper;

    public ClientAdressDto save(ClientAdressSave data) {
        ClientValidationAdressUtil.validateAdressExist(repository, data.getCep(), data.getClient());
        ClientValidationUtil.validateClientExistById(clientRepository,data.getClient());
        Client getClient = clientRepository.findById(data.getClient()).get();
        ClientAdress instance = new ClientAdress(data, getClient);
        ClientAdress save = repository.save(instance);
        getClient.setAdresses(save);
        ClientDto clientDto = mapper.map(save.getClient(), ClientDto.class);
        ClientAdressDto dto = new ClientAdressDto(save, clientDto);
        return dto;
    }
}
