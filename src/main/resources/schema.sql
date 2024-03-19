DROP TABLE IF EXISTS BRAND;

CREATE TABLE BRAND (
    ID INT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL
);


DROP TABLE IF EXISTS PRICES;

CREATE TABLE PRICES (
    id INT PRIMARY KEY,
    brand_id INT,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price_list INT,
    product_id INT,
    priority INT,
    price DECIMAL(10, 2),
    curr VARCHAR(3),
    FOREIGN KEY (brand_id) REFERENCES brand(id)
);