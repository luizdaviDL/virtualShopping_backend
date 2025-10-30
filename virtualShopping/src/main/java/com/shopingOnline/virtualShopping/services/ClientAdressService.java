package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.client.ClientComponents;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientAdressService {
    @Autowired
    private ClientAdressRepository repository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ClientComponents components;
    @Autowired
    private ClientValidationAdressUtil validation;

    public ClientAdressDto save(ClientAdressSave data) {
        validation.validateAdressAlreadyExist(data.getCep(), data.getClient());
        ClientValidationUtil.validateClientExistById(clientRepository,data.getClient());
        Client getClient = clientRepository.findById(data.getClient()).get();
        ClientAdress instance = new ClientAdress(data, getClient);
        ClientAdress save = repository.save(instance);

        getClient.getAdresses().add(save);
        ClientDto clientDto = mapper.map(save.getClient(), ClientDto.class);
        ClientAdressDto dto = new ClientAdressDto(save, clientDto);
        return dto;
    }

    public List<ClientAdressDto> getAll() {
        List<ClientAdress> getAll = repository.findAll();
        return components.lisAdressDto(getAll);
    }

    public ClientAdressDto update(ClientAdressSave data) {
        validation.validateAdressExist( data.getId());
        ClientAdress get = repository.findById(data.getId()).get();
        get.setAdress(data.getAdress());
        get.setCep(data.getCep());
        get.setNumberHome(data.getNumberHome());
        get.setComplementAdress(data.getComplementAdress());
        get.setNeighborhood(data.getNeighborhood());
        get.setCity(data.getCity());
        get.setState(data.getState());

        ClientAdress save = repository.save(get);
        return mapper.map(save, ClientAdressDto.class);

    }

    public List<ClientAdressDto> delete(ClientAdressSave data) {
        validation.validateAdressExist(data.getId());
        repository.deleteById(data.getId());
        return getAll();
    }

    public List<ClientAdressDto> findByClientId(Long clientId) {
        List<ClientAdress> adresses = repository.findByClientId(clientId);
        return components.lisAdressDto(adresses);
    }

    public ClientAdressDto patch(ClientAdressSave data) {
        Optional<ClientAdress> optionalAdress = repository.findById(data.getId());
        if (optionalAdress.isEmpty()) {
            throw new RuntimeException("Address not found with id: " + data.getId());
        }

        ClientAdress adress = optionalAdress.get();

        if (data.getCep() != null) {
            adress.setCep(data.getCep());
        }
        if (data.getCity() != null) {
            adress.setCity(data.getCity());
        }
        if (data.getState() != null) {
            adress.setState(data.getState());
        }
        if (data.getAdress() != null) {
            adress.setAdress(data.getAdress());
        }
        if (data.getNumberHome() != null) {
            adress.setNumberHome(data.getNumberHome());
        }
        if (data.getComplementAdress() != null) {
            adress.setComplementAdress(data.getComplementAdress());
        }
        if (data.getNeighborhood() != null) {
            adress.setNeighborhood(data.getNeighborhood());
        }

        if (data.getCountry() != null) {
            adress.setCountry(data.getCountry());
        }
        if (data.getClient() != null) {
            ClientValidationUtil.validateClientExistById(clientRepository, data.getClient());
            Client client = clientRepository.findById(data.getClient()).get();
            adress.setClient(client);
        }

        ClientAdress updated = repository.save(adress);

        ClientDto clientDto = mapper.map(updated.getClient(), ClientDto.class);
        return new ClientAdressDto(updated, clientDto);
    }
}
