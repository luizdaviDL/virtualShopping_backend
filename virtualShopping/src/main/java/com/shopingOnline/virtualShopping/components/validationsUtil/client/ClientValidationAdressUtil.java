package com.shopingOnline.virtualShopping.components.validationsUtil.client;

import com.shopingOnline.virtualShopping.components.exceptions.BusinessException;
import com.shopingOnline.virtualShopping.entity.Client;
import com.shopingOnline.virtualShopping.repository.ClientAdressRepository;
import com.shopingOnline.virtualShopping.repository.ClientRepository;

import java.util.Objects;
import java.util.Optional;

public class ClientValidationAdressUtil {
    public static void validateAdressExist(ClientAdressRepository repository, String data){
        String cepAdress = repository.findByCep(data);
        if(Objects.equals(cepAdress, data)){
            throw new BusinessException("this adress already exists to this user: " + data);
        }
    }
}
