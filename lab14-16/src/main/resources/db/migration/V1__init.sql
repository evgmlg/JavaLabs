-- SET search_path TO boot;
CREATE TABLE products (id serial, title varchar(100), price int, counter int);

INSERT INTO products (title, price, counter) VALUES ('Bread', 40,0), ('Milk', 80,0);

CREATE TABLE users (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled boolean NOT NULL,
    PRIMARY KEY (username)
);

INSERT INTO users
VALUES
('user1', '{noop}123', true),
('user2', '{noop}123', true);

CREATE TABLE authorities (
    username varchar(50) NOT NULL,
    authority varchar(50) NOT NULL,

    CONSTRAINT authorities_idx UNIQUE (username, authority),

    CONSTRAINT authorities_ibfk_1
    FOREIGN KEY (username)
    REFERENCES users (username)
);

INSERT INTO authorities
VALUES
('user1', 'ROLE_ADMIN'),
('user1', 'ROLE_USER'),
('user2', 'ROLE_USER');