package com.kalagan.kalagantest.controller;

import com.kalagan.kalagantest.adapter.web.controller.PriceController;
import com.kalagan.kalagantest.application.service.PriceService;
import com.kalagan.kalagantest.model.dto.PriceDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ControllerTest {

    @Mock
    private PriceService priceService;

    @InjectMocks
    private PriceController priceController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(priceController).build();
    }

    /**
     * Method that executes the tests to obtain the prices
     * @throws Exception
     */

    @Test
    public void testGetPricesOne() throws Exception {
        PriceDto priceDto = new PriceDto();
        priceDto.setProductId(35455L);
        priceDto.setBrandId(1L);
        priceDto.setPriceList(1);
        priceDto.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
        priceDto.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        priceDto.setFinalPrice(new BigDecimal("35.50"));
        priceDto.setCurrency("EUR");


        LocalDateTime requestTime = LocalDateTime.of(2020, 6, 14, 10, 0);
        when(priceService.getPriceByData(requestTime, 35455L, 1L))
                .thenReturn(priceDto);


        mockMvc.perform(get("/api/prices")
                        .param("startDate", "2020-06-14T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.finalPrice").value(35.50))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    void testGetPricesTwo() throws Exception {

        PriceDto priceDto = new PriceDto();
        priceDto.setProductId(35455L);
        priceDto.setBrandId(1L);
        priceDto.setPriceList(4);
        priceDto.setStartDate(LocalDateTime.of(2020, 6, 14, 15, 0));
        priceDto.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        priceDto.setFinalPrice(new BigDecimal("25.45"));
        priceDto.setCurrency("EUR");

        LocalDateTime requestTime = LocalDateTime.of(2020, 6, 14, 16, 0);
        when(priceService.getPriceByData(requestTime, 35455L, 1L))
                .thenReturn(priceDto);

        mockMvc.perform(get("/api/prices")
                        .param("startDate", "2020-06-14T16:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T15:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.finalPrice").value(25.45))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    void testGetPricesThree() throws Exception {

        PriceDto priceDto = new PriceDto();
        priceDto.setProductId(35455L);
        priceDto.setBrandId(1L);
        priceDto.setPriceList(4);
        priceDto.setStartDate(LocalDateTime.of(2020, 6, 14, 18, 0));
        priceDto.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        priceDto.setFinalPrice(new BigDecimal("30.50"));
        priceDto.setCurrency("EUR");

        LocalDateTime requestTime = LocalDateTime.of(2020, 6, 14, 21, 0);
        when(priceService.getPriceByData(requestTime, 35455L, 1L))
                .thenReturn(priceDto);

        mockMvc.perform(get("/api/prices")
                        .param("startDate", "2020-06-14T21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T18:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.finalPrice").value(30.50))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    void testGetPricesFour() throws Exception {

        PriceDto priceDto = new PriceDto();
        priceDto.setProductId(35455L);
        priceDto.setBrandId(1L);
        priceDto.setPriceList(4);
        priceDto.setStartDate(LocalDateTime.of(2020, 6, 15, 0, 0));
        priceDto.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        priceDto.setFinalPrice(new BigDecimal("38.95"));
        priceDto.setCurrency("EUR");

        LocalDateTime requestTime = LocalDateTime.of(2020, 6, 15, 10, 0);
        when(priceService.getPriceByData(requestTime, 35455L, 1L))
                .thenReturn(priceDto);

        mockMvc.perform(get("/api/prices")
                        .param("startDate", "2020-06-15T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.startDate").value("2020-06-15T00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.finalPrice").value(38.95))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    void testGetPricesFive() throws Exception {

        PriceDto priceDto = new PriceDto();
        priceDto.setProductId(35455L);
        priceDto.setBrandId(1L);
        priceDto.setPriceList(4);
        priceDto.setStartDate(LocalDateTime.of(2020, 6, 15, 18, 0));
        priceDto.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        priceDto.setFinalPrice(new BigDecimal("38.95"));
        priceDto.setCurrency("EUR");

        LocalDateTime requestTime = LocalDateTime.of(2020, 6, 15, 21, 0);
        when(priceService.getPriceByData(requestTime, 35455L, 1L))
                .thenReturn(priceDto);

        mockMvc.perform(get("/api/prices")
                        .param("startDate", "2020-06-15T21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.startDate").value("2020-06-15T18:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.finalPrice").value(38.95))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }
}
