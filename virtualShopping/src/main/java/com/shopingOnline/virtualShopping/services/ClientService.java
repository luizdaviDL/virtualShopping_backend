package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.client.ClientComponents;
import com.shopingOnline.virtualShopping.components.dtos.ClientDto;
import com.shopingOnline.virtualShopping.components.serializer.ClientSaving;
import com.shopingOnline.virtualShopping.components.validationsUtil.client.ClientValidationUtil;
import com.shopingOnline.virtualShopping.entity.Client;
import com.shopingOnline.virtualShopping.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ClientComponents component;

    public ClientDto save(ClientSaving data) {
        ClientValidationUtil.validateEmailExist(repository, data.getEmail());
        Client instance = mapper.map(data, Client.class);
        Client save = repository.save(instance);
        return mapper.map(save, ClientDto.class);
    }

    public ClientDto update(ClientSaving data) {
        ClientValidationUtil.validateClientExistById(repository, data.getId());
        Client clientGet = repository.findById(data.getId()).get();
        clientGet.setName(data.getName());
        clientGet.setEmail(data.getEmail());
        clientGet.setPhone(data.getPhone());
        Client save = repository.save(clientGet);
        return mapper.map(save, ClientDto.class);
    }

    public List<ClientDto> getAll() {
        List<Client> clients = repository.findAll();
        return component.listClientDto(clients);
    }

    public List<ClientDto> delete(@RequestBody ClientSaving data) {
        ClientValidationUtil.validateClientExistById(repository,data.getId());
        repository.deleteById(data.getId());
        return getAll();
    }
}
