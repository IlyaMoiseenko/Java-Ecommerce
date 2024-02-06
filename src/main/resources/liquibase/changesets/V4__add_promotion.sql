CREATE TABLE IF NOT EXISTS tb_promotion
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    description VARCHAR(255) NOT NULL,
    discount_rate INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL
);

INSERT INTO tb_promotion (name, description, discount_rate, start_date, end_date)
VALUES ('5%', 'Gives a 5% discount', '5', '2024-02-05', '2024-02-20'),
       ('10%', 'Gives a 10% discount', '10', '2024-02-05', '2024-02-20'),
       ('15%', 'Gives a 15% discount', '15', '2024-02-05', '2024-02-20');

ALTER TABLE tb_product_category
ADD COLUMN fk_promotion_id BIGINT;

ALTER TABLE tb_product_category
ADD CONSTRAINT fk_promotion_id
FOREIGN KEY (fk_promotion_id) REFERENCES tb_promotion(id);





