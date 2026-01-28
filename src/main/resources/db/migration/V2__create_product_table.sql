CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    image VARCHAR(255),
    price DOUBLE,
    description VARCHAR(255),
    title VARCHAR(255),
    category_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES category(id)
);
