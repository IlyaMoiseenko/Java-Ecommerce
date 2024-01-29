CREATE TABLE IF NOT EXISTS tb_product_category
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tb_product
(
    id BIGSERIAL PRIMARY KEY,
    fk_category_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    price DECIMAL NOT NULL,
    qty_in_stock INT NOT NULL,

    CONSTRAINT fk_category_id FOREIGN KEY (fk_category_id) REFERENCES tb_product_category(id)
);

CREATE TABLE IF NOT EXISTS tb_variation
(
    id BIGSERIAL PRIMARY KEY,
    fk_category_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,

    CONSTRAINT fk_category_id FOREIGN KEY (fk_category_id) REFERENCES tb_product_category(id)
);

CREATE TABLE IF NOT EXISTS tb_variation_option
(
    id BIGSERIAL PRIMARY KEY,
    fk_variation_id BIGINT NOT NULL,
    value VARCHAR(255) NOT NULL,

    CONSTRAINT fk_variation_id FOREIGN KEY (fk_variation_id) REFERENCES tb_variation(id)
);

CREATE TABLE IF NOT EXISTS tb_product_configuration
(
    fk_product_id BIGINT NOT NULL,
    fk_variation_option_id BIGINT NOT NULL,

    PRIMARY KEY (fk_product_id, fk_variation_option_id),
    CONSTRAINT fk_product_configuration_product FOREIGN KEY (fk_product_id) REFERENCES tb_product(id),
    CONSTRAINT fk_product_configuration_variation_option FOREIGN KEY (fk_variation_option_id) REFERENCES tb_variation_option(id)
);








INSERT INTO tb_product_category (name)
VALUES ('Одежда'),
       ('Телефон'),
       ('Электроника');

INSERT INTO tb_product (fk_category_id, name, description, price, qty_in_stock)
VALUES (1, 'Майка', 'Какое-то описание майки', 200, 5),
       (1, 'Штаны', 'Какое-то описание штанов', 150, 2),
       (1, 'Куртка', 'Какое-то описание куртки', 1200, 9),
       (2, 'iPhone 15 Pro Max', 'Какое-то описание iPhone', 2200, 3),
       (2, 'Samsung Galaxy S24 Ultra', 'Какое-то описание Samsung Galaxy S24 Ultra', 1570, 3),
       (2, 'Huawei Mate 15 Pro', 'Какое-то описание Huawei Mate 15 Pro', 700, 1),
       (3, 'Микроволновая печь', 'Какое-то описание микроволновой печи', 350, 7),
       (3, 'Стиральная машина', 'Какое-то описание стиральной машины', 400, 4),
       (3, 'Газовая плита', 'Какое-то описание газовой плиты', 600, 2);

INSERT INTO tb_variation (fk_category_id, name)
VALUES (1, 'Размер'),
       (1, 'Цвет'),
       (2, 'Память'),
       (2, 'Баттарея'),
       (3, 'Процессор'),
       (3, 'Bluetooth');

INSERT INTO tb_variation_option (fk_variation_id, value)
VALUES (1, 'S'),
       (1, 'M'),
       (1, 'XS'),
       (2, 'Крастный'),
       (2, 'Желтый'),
       (2, 'Зеленый'),
       (3, '5GB'),
       (3, '10GB'),
       (3, '15GB'),
       (4, '5000 мАч'),
       (4, '3000 мАч'),
       (4, '4000 мАч'),
       (5, 'AMD'),
       (5, 'INTEL'),
       (5, 'M1'),
       (6, '5.0'),
       (6, '3.0'),
       (6, '4.0');

INSERT INTO tb_product_configuration (fk_product_id, fk_variation_option_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (1, 6),
       (2, 2),
       (2, 3),
       (2, 5),
       (3, 2),
       (3, 3),
       (4, 8),
       (4, 9),
       (4, 16),
       (5, 8),
       (5, 9),
       (5, 16),
       (6, 8),
       (6, 9),
       (6, 16),
       (7, 13),
       (8, 14),
       (9, 15);

