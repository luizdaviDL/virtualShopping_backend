package com.shopingOnline.virtualShopping.controlers;

import com.shopingOnline.virtualShopping.components.dtos.ClientAdressDto;
import com.shopingOnline.virtualShopping.components.serializer.ClientAdressSave;
import com.shopingOnline.virtualShopping.services.ClientAdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/clientAdress")
public class ClientAdressController {

    @Autowired
    private ClientAdressService service;

    @PostMapping(value = "/save")
    public ClientAdressDto save(@RequestBody ClientAdressSave data){
        return service.save(data);
    }

    @GetMapping(value = "/getAll")
    public List<ClientAdressDto> getAll(){
        return service.getAll();
    }

    @PutMapping(value = "/update")
    public ClientAdressDto update(@RequestBody ClientAdressSave data){
        return service.update(data);
    }

    @DeleteMapping(value = "/delete")
    public List<ClientAdressDto> delete(@RequestBody ClientAdressSave data){
        return service.delete(data);
    }

    @GetMapping(value = "/client/{clientId}")
    public ResponseEntity<?> findByClientId(@PathVariable Long clientId) {
        List<ClientAdressDto> addresses = service.findByClientId(clientId);

        Map<String, Object> response = new HashMap<>();

        if (addresses != null && !addresses.isEmpty()) {
            response.put("success", true);
            response.put("message", "Endereços encontrados com sucesso!");
            response.put("data", addresses);
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "Nenhum endereço encontrado para este cliente.");
            response.put("data", List.of());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PatchMapping
    public ClientAdressDto patch( @RequestBody ClientAdressSave data) {
        return service.patch(data);
    }
}
