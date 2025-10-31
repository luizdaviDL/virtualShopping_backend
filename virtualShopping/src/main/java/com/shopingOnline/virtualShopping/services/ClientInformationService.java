package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.dtos.ClientDto;
import com.shopingOnline.virtualShopping.components.dtos.ClientInformationDto;
import com.shopingOnline.virtualShopping.components.serializer.ClientInformationSave;
import com.shopingOnline.virtualShopping.components.validationsUtil.client.ClientValidationUtil;
import com.shopingOnline.virtualShopping.entity.Client;
import com.shopingOnline.virtualShopping.entity.ClientInformation;
import com.shopingOnline.virtualShopping.repository.ClientInformationRepository;
import com.shopingOnline.virtualShopping.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientInformationService {

    @Autowired
    private ClientValidationUtil clientValidation;
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ClientInformationRepository repository;

    public ClientInformationDto save(ClientInformationSave data) {
        clientValidation.validateClientExistById(data.getUser());
        Client client = clientRepository.findById(data.getUser()).get();
        ClientInformation entity = mapper.map(data, ClientInformation.class);
        entity.setUser(client);
        entity = repository.save(entity);
        ClientDto clientDto = mapper.map(client, ClientDto.class);
        ClientInformationDto dto =  mapper.map(entity, ClientInformationDto.class);
        dto.setUser(clientDto);
        return dto;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


    public ClientInformationDto update(ClientInformationSave data) {
        if (!repository.existsById(data.getId())) {
            throw new RuntimeException("Cliente não encontrado");
        }
        ClientInformation entity = mapper.map(data, ClientInformation.class);
        entity.setId(data.getId());
        entity = repository.save(entity);
        return mapper.map(entity, ClientInformationDto.class);
    }


    public ClientInformationDto patch(Long id, ClientInformationSave data) {
        Optional<ClientInformation> optionalEntity = repository.findById(id);
        if (!optionalEntity.isPresent()) {
            throw new RuntimeException("Cliente não encontrado");
        }

        ClientInformation entity = optionalEntity.get();


        if (data.getFirstName() != null) entity.setFirstName(data.getFirstName());
        if (data.getLastName() != null) entity.setLastName(data.getLastName());
        if (data.getPhoneNumber() != null) entity.setPhoneNumber(data.getPhoneNumber());
        if (data.getDocumentNumber() != null) entity.setDocumentNumber(data.getDocumentNumber());
        if (data.getBirthDate() != null) entity.setBirthDate(data.getBirthDate());
        if (data.getGender() != null) entity.setGender(data.getGender());
        entity = repository.save(entity);
        return mapper.map(entity, ClientInformationDto.class);
    }


    public ClientInformationDto findById(Long id) {
        Optional<ClientInformation> optionalEntity = repository.findById(id);
        if (!optionalEntity.isPresent()) {
            throw new RuntimeException("Cliente não encontrado");
        }
        return mapper.map(optionalEntity.get(), ClientInformationDto.class);
    }

    public List<ClientInformationDto> getAll() {
        List<ClientInformation> clientInformationList = repository.findAll();
        return clientInformationList.stream()
                .map(entity -> {
                    ClientInformationDto dto = mapper.map(entity, ClientInformationDto.class);
                    ClientDto clientDto = mapper.map(entity.getUser(), ClientDto.class);
                    dto.setUser(clientDto);
                    return dto;
                })
                .collect(Collectors.toList());
    }


}
