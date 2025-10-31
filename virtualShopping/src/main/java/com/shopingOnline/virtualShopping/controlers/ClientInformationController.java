package com.shopingOnline.virtualShopping.controlers;

import com.shopingOnline.virtualShopping.components.dtos.ClientInformationDto;
import com.shopingOnline.virtualShopping.components.serializer.ClientInformationSave;
import com.shopingOnline.virtualShopping.services.ClientInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientInfo")
public class ClientInformationController {

    @Autowired
    private ClientInformationService service;

    @PostMapping(value = "/save")
    public ClientInformationDto save(@RequestBody ClientInformationSave data) {
        return service.save(data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


    @PutMapping("/update")
    public ClientInformationDto update( @RequestBody ClientInformationSave data) {
        return service.update(data);
    }


    @PatchMapping("/{id}")
    public ClientInformationDto patch(@PathVariable Long id, @RequestBody ClientInformationSave data) {
        return service.patch(id, data);
    }

    // Buscar Cliente por ID
    @GetMapping("/{id}")
    public ClientInformationDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/all")
    public List<ClientInformationDto> getAll() {
        return service.getAll();
    }
}
