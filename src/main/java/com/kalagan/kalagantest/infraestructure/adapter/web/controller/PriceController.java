package com.kalagan.kalagantest.infraestructure.adapter.web.controller;


import com.kalagan.kalagantest.application.dto.PriceDto;
import com.kalagan.kalagantest.application.service.PriceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private PriceService priceService;

    public PriceController(PriceService priceService){
        this.priceService = priceService;
    }

    /***
     *
     * @param brandId
     * @param productId
     * @param startDate
     * @return
     *
     * getPrices rest services
     */
    @GetMapping
    public ResponseEntity<PriceDto> getPrices(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam Long productId,
            @RequestParam Long brandId) {
        PriceDto prices = priceService.getPriceByData(startDate, productId, brandId);
        return ResponseEntity.ok(prices);
    }
}
