package com.shopingOnline.virtualShopping.controlers;

import com.shopingOnline.virtualShopping.components.dtos.ClientDto;
import com.shopingOnline.virtualShopping.components.serializer.ClientSaving;
import com.shopingOnline.virtualShopping.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping(value = "/save")
    public ClientDto save(@RequestBody ClientSaving data){
        return service.save(data);
    }

    @PutMapping(value = "/update")
    public ClientDto update(@RequestBody ClientSaving data){
        return service.update(data);
    }

    @GetMapping(value = "/getAll")
    public List<ClientDto> getAll(){
        return service.getAll();
    }

    @DeleteMapping(value = "/delete")
    public List<ClientDto> delete(@RequestBody ClientSaving data){
        return service.delete(data);
    }

    @PatchMapping
    public ResponseEntity<ClientDto> patchClient(@RequestBody ClientSaving data) {
        ClientDto updated = service.patch(data);
        return ResponseEntity.ok(updated);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable long id) {
        ClientDto client = service.getById(id);
        return ResponseEntity.ok(client);
    }
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody ClientSaving loginData) {
        ClientDto client = service.login(loginData.getEmail(), loginData.getPassword());

        Map<String, Object> response = new HashMap<>();

        if (client != null) {
            response.put("success", true);
            response.put("message", "Login realizado com sucesso!");
            response.put("data", client);

            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "Email ou senha inválidos!");
            response.put("data", null);

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

}
