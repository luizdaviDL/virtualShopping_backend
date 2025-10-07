package com.shopingOnline.virtualShopping.components.validationsUtil.client;

import com.shopingOnline.virtualShopping.components.exceptions.BusinessException;
import com.shopingOnline.virtualShopping.entity.Client;
import com.shopingOnline.virtualShopping.repository.ClientAdressRepository;
import com.shopingOnline.virtualShopping.repository.ClientRepository;

import java.util.Objects;
import java.util.Optional;

public class ClientValidationAdressUtil {
    public static void validateAdressExist(ClientAdressRepository repository, String cep, Long client){
        String cepAdress = repository.findByCep(cep,client);
        if(Objects.equals(cepAdress, cep)){
            throw new BusinessException("this adress already exists to this user: " + cep);
        }
    }
}
