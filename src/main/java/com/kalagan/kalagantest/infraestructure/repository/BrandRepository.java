package com.kalagan.kalagantest.infraestructure.repository;

import com.kalagan.kalagantest.infraestructure.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
