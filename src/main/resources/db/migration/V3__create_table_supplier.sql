CREATE TABLE supplier
(
    id        INT AUTO_INCREMENT NOT NULL,
    name      VARCHAR(255)       NOT NULL,
    contact   VARCHAR(255)       NOT NULL,
    user_id   INT                NULL,
    is_active BIT(1) DEFAULT 1   NOT NULL,
    CONSTRAINT pk_supplier PRIMARY KEY (id)
);

ALTER TABLE supplier
    ADD CONSTRAINT FK_SUPPLIER_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);