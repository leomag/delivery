CREATE TABLE product_entity
(
    id                  SERIAL PRIMARY KEY,
    name_product        VARCHAR(50) NOT NULL,
    price               INT         NOT NULL,
    product_group_id    SERIAL      NOT NULL,
    product_discount_id SERIAL,
    creation_date       TIMESTAMP  DEFAULT now() NOT NULL
);
CREATE TABLE product_discount
(
    id            SERIAL PRIMARY KEY,
    name_discount VARCHAR(50) NOT NULL,
    enabled       BOOLEAN     NOT NULL,
    creation_date TIMESTAMP  DEFAULT now() NOT NULL
);
CREATE TABLE product_group
(
    id            SERIAL PRIMARY KEY,
    product_group VARCHAR(50)             NOT NULL,
    creation_date TIMESTAMP DEFAULT now() NOT NULL
);
