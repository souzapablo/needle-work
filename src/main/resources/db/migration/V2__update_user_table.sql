ALTER TABLE user
    ADD CONSTRAINT uc_user_email UNIQUE (email);

ALTER TABLE user
    ADD COLUMN is_active BIT(1) DEFAULT 1 NOT NULL;