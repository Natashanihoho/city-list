--liquibase formatted sql

--changeset nhardziyevich:1

CREATE TABLE IF NOT EXISTS users
(
    id         BIGSERIAL PRIMARY KEY,
    username   VARCHAR(64) UNIQUE NOT NULL,
    password   VARCHAR(256) NOT NULL,
    role       VARCHAR(16)
);

--rollback DROP TABLE users
