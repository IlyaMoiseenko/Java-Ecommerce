CREATE TABLE IF NOT EXISTS tb_user
(
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone_number VARCHAR(12) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_address
(
    id BIGSERIAL PRIMARY KEY,
    city VARCHAR(255) NOT NULL,
    postal_code INT NOT NULL,
    address_line varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_country
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50)
);

ALTER TABLE tb_user
ADD COLUMN fk_country_id BIGINT;

ALTER TABLE tb_user
ADD CONSTRAINT fk_user_country
FOREIGN KEY (fk_country_id) REFERENCES tb_country(id);

CREATE TABLE IF NOT EXISTS user_address
(
    fk_user_id BIGINT NOT NULL,
    fk_address_id BIGINT NOT NULL,

    PRIMARY KEY (fk_user_id, fk_address_id),
    CONSTRAINT fk_user_address_user FOREIGN KEY (fk_user_id) REFERENCES tb_user(id) ON DELETE CASCADE,
    CONSTRAINT fk_user_address_address FOREIGN KEY (fk_address_id) REFERENCES tb_address(id) ON DELETE CASCADE
)


