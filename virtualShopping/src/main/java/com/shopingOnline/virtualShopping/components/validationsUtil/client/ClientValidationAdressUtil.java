package com.shopingOnline.virtualShopping.components.validationsUtil.client;

import com.shopingOnline.virtualShopping.components.exceptions.BusinessException;
import com.shopingOnline.virtualShopping.entity.Client;
import com.shopingOnline.virtualShopping.entity.ClientAdress;
import com.shopingOnline.virtualShopping.repository.ClientAdressRepository;
import com.shopingOnline.virtualShopping.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
@Component
public class ClientValidationAdressUtil {
    @Autowired
    private ClientAdressRepository repository;

    public  void validateAdressAlreadyExist(String cep, Long client){
        String cepAdress = repository.findByCep(cep,client);
        if(Objects.equals(cepAdress, cep)){
            throw new BusinessException("this adress already exists to this user: " + cep);
        }
    }

    public  void validateAdressExist(Long id){
        Optional<ClientAdress> adress = repository.findById(id);
        if(adress.isEmpty()){
            throw new BusinessException("this adress not exists in the data base: " + id);
        }
    }
}
