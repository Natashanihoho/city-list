--liquibase formatted sql

--changeset nhardziyevich:1

INSERT INTO users(username, password, role)
VALUES ('user', '{SHA-256}a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'ROLE_READ_ONLY'),
       ('superuser', '{SHA-256}5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 'ROLE_ALLOW_EDIT');

