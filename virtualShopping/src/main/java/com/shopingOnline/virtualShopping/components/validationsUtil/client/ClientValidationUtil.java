package com.shopingOnline.virtualShopping.components.validationsUtil.client;

import com.shopingOnline.virtualShopping.components.exceptions.BusinessException;
import com.shopingOnline.virtualShopping.components.serializer.ClientSaving;
import com.shopingOnline.virtualShopping.entity.Client;
import com.shopingOnline.virtualShopping.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class ClientValidationUtil {

    public static void validateClientExist(ClientRepository repository, String name){
        Optional<Client> client = repository.findByName(name);
        if(client.isPresent()){
            throw new BusinessException("Client already exists in the database: " + name);
        }
    }

    public static void validateEmailNotExist(ClientRepository repository, String name){
        Optional<Client> findName = repository.findByEmail(name);
        if(findName.isEmpty()){
            throw new BusinessException("Email not exists in the database: " + name);
        }
    }

    public static void validateClientExistById(ClientRepository repository, Long id) {
        Optional<Client> findCatedory = repository.findById(id);
        if (findCatedory.isEmpty()) {
            throw new BusinessException("Client does not exist in the database: " + id);
        }

    }

    public static void validateEmailExist(ClientRepository repository, String email){
        Optional<Client> client = repository.findByEmail(email);
        if(client.isPresent()){
            throw new BusinessException("Email already exists in the database: " + email);
        }
    }
}
