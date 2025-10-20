package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.dtos.ColorsDto;
import com.shopingOnline.virtualShopping.components.serializer.ColorProductSave;
import com.shopingOnline.virtualShopping.components.validationsUtil.colorProduct.ColorProductValidation;
import com.shopingOnline.virtualShopping.entity.ColorProduct;
import com.shopingOnline.virtualShopping.repository.ColorProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorProductService {
    @Autowired
    private ColorProductRepository repository;
    @Autowired
    private ColorProductValidation validation;
    @Autowired
    private ModelMapper mapper;

    public ColorsDto save(ColorProductSave data) {

        validation.validateColorExist(data);

        ColorProduct instance = new ColorProduct(data);
        ColorProduct save = repository.save(instance);
        return mapper.map(save, ColorsDto.class);
    }

    public List<ColorsDto> findAll() {
        List<ColorProduct> list = repository.findAll();
        List<ColorsDto> result = new ArrayList<>();
        for (ColorProduct color : list) {
            result.add(mapper.map(color, ColorsDto.class));
        }
        return result;
    }

    public ColorsDto findById(Long id) {
        ColorProduct color = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Color not found with id: " + id));
        return mapper.map(color, ColorsDto.class);
    }

    public ColorsDto update(ColorProductSave data) {
        ColorProduct color = repository.findById(data.getId())
                .orElseThrow(() -> new RuntimeException("Color not found with id: " + data.getId()));

        color.setName(data.getName());
        color.setValue(data.getValue());

        ColorProduct updated = repository.save(color);
        return mapper.map(updated, ColorsDto.class);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Color not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public ColorsDto patchColor(ColorProductSave data) {
        if (data.getId() == null) {
            throw new RuntimeException("ID da cor é obrigatório para o patch.");
        }

        ColorProduct color = repository.findById(data.getId())
                .orElseThrow(() -> new RuntimeException("Cor não encontrada com ID: " + data.getId()));

        if (data.getName() != null) {
            color.setName(data.getName());
        }

        if (data.getValue() != null) {
            color.setValue(data.getValue());
        }

        ColorProduct updated = repository.save(color);
        return mapper.map(updated, ColorsDto.class);
    }


}
