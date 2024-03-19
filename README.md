# K-LAGAN

### Table of contents

* [Overview](#overview)
* [Guidelines](#guidelines)
* [Technologies](#technologies)
* [Source Code Review](#source-code-review)
* [Code Examples](#code-examples)
* [Disclaimer](#disclaimer-section)

### Overview
This is a test to BCNC about inditest project

### Guidelines
1. Clone this repository
2. Build maven project
3. Run the test with .sql files to create the tables and update the tables with order correct in columns and insert de data
4. Always run in locally, because this is the test

### Technologies
* Java 17
* H2 Database
* Springboot 3.2.3
* Hexagonal Architecture
* Maven

### Source Code Review
* This is the code to consult the data from the database

```java
@GetMapping
    public ResponseEntity<PriceDto> getPrices(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
        @RequestParam Long productId,
        @RequestParam Long brandId) {
        PriceDto prices = priceService.getPriceByData(startDate, productId, brandId);
        return ResponseEntity.ok(prices);
    }
```
### Code Examples

This is the form to consult the data with the @GET Service `http://localhost:8080/api/pices?startDate=2020-06-15T16:00:00&productId=35455&brandId=1`

### Disclaimer Section

* This is a test, but too can a little example to use a hexagonal architecture