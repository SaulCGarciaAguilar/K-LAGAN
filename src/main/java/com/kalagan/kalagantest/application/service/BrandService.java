package com.kalagan.kalagantest.application.service;

import com.kalagan.kalagantest.infraestructure.entity.Brand;
import com.kalagan.kalagantest.infraestructure.repository.BrandRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand getBrandById(Long id) {
        return brandRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Brand not found with id: " + id));
    }
}
