package com.kalagan.kalagantest.application.service;

import com.kalagan.kalagantest.infraestructure.entity.Price;
import com.kalagan.kalagantest.infraestructure.repository.PriceRepository;
import com.kalagan.kalagantest.model.dto.PriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class PriceService {
    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
    public PriceDto getPriceByData(LocalDateTime applicationDate, Long productId, Long brandId) {

        List<Price> prices = priceRepository.findByAndStartDateAndProductIdAndBrandId(applicationDate, productId, brandId);


        Price selectedPrice = selectPrice(prices);

        PriceDto resultDTO = new PriceDto();
        if (selectedPrice != null) {
            resultDTO.setProductId(selectedPrice.getProductId());
            resultDTO.setBrandId(selectedPrice.getBrand().getId());
            resultDTO.setPriceList(selectedPrice.getPriceList());
            resultDTO.setStartDate(selectedPrice.getStartDate());
            resultDTO.setEndDate(selectedPrice.getEndDate());
            resultDTO.setFinalPrice(selectedPrice.getPrice());
            resultDTO.setCurrency(selectedPrice.getCurr());
        }

        return resultDTO;
    }

    private Price selectPrice(List<Price> prices) {
        prices.sort(Comparator.comparingInt(Price::getPriority).reversed());

        return prices.stream().findFirst().orElse(null);
    }
}
