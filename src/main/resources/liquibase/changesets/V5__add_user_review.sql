CREATE TABLE IF NOT EXISTS tb_user_review
(
    id BIGSERIAL PRIMARY KEY,
    fk_user_id BIGINT NOT NULL,
    fk_product_id BIGINT NOT NULL,
    comment VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_user_id FOREIGN KEY(fk_user_id) REFERENCES tb_user(id),
    CONSTRAINT fk_product_id FOREIGN KEY(fk_product_id) REFERENCES tb_product(id)
);