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
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ClientComponents component;
    @Autowired
    private ClientValidationUtil clientValidation;

    public ClientDto save(ClientSaving data) {
        clientValidation.validateEmailExist(data.getEmail());
        Client instance = mapper.map(data, Client.class);
        Client save = repository.save(instance);
        return mapper.map(save, ClientDto.class);
    }

    public ClientDto update(ClientSaving data) {
        clientValidation.validateClientExistById(data.getId());
        Client clientGet = repository.findById(data.getId()).get();
        clientGet.setName(data.getName());
        clientGet.setEmail(data.getEmail());
        clientGet.setPassWord(data.getPassword());
        Client save = repository.save(clientGet);
        return mapper.map(save, ClientDto.class);
    }

    public List<ClientDto> getAll() {
        List<Client> clients = repository.findAll();
        return component.listClientDto(clients);
    }

    public List<ClientDto> delete(@RequestBody ClientSaving data) {
        clientValidation.validateClientExistById(data.getId());
        repository.deleteById(data.getId());
        return getAll();
    }

    public ClientDto patch(ClientSaving data) {
        clientValidation.validateClientExistById(data.getId());

        Client existingClient = repository.findById(data.getId()).get();

        if (data.getName() != null && !data.getName().isBlank()) {
            existingClient.setName(data.getName());
        }

        if (data.getEmail() != null && !data.getEmail().isBlank()) {
            clientValidation.validateEmailExist(data.getEmail());
            existingClient.setEmail(data.getEmail());
        }

        if (data.getPassword() != null && !data.getPassword().isBlank()) {
            existingClient.setPassWord(data.getPassword());
        }
        Client saved = repository.save(existingClient);
        return mapper.map(saved, ClientDto.class);
    }

    public ClientDto getById(long id) {
        clientValidation.validateClientExistById(id);
        Client client = repository.findById(id).get();
        return mapper.map(client, ClientDto.class);
    }

    public ClientDto login(String email, String password) {
        clientValidation.validateEmailNotExist( email);
        Optional<Client> clientOpt = repository.findByEmail(email);

        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            if (client.getPassWord().equals(password)) {
                return mapper.map(client, ClientDto.class);
            }
        }

        return null; // login inválido
    }

}
