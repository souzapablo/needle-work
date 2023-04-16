CREATE TABLE product
(
    id            INT AUTO_INCREMENT NOT NULL,
    `description` VARCHAR(255)       NOT NULL,
    price         DECIMAL(10,2)      NOT NULL,
    supplier_id   INT                NULL,
    is_active     BIT(1) DEFAULT 1   NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_SUPPLIER FOREIGN KEY (supplier_id) REFERENCES supplier (id);