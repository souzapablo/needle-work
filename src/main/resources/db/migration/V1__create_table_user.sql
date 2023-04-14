CREATE TABLE user
(
    id    INT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255)       NOT NULL,
    email VARCHAR(255)       NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);