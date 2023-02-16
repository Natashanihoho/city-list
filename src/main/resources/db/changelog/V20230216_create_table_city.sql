--liquibase formatted sql

--changeset nhardziyevich:1

CREATE TABLE IF NOT EXISTS city
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(64) NOT NULL,
    image_path VARCHAR(1024)
);

--rollback DROP TABLE city