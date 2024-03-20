package com.kalagan.kalagantest.dominio.repository;

import com.kalagan.kalagantest.dominio.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findByAndStartDateAndProductIdAndBrandId(
            LocalDateTime startDate, Long productId, Long brandId);
}
