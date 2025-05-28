-- V4__create_cliente_telefone_endereco.sql

-- CLIENTE
CREATE TABLE tb_cliente (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    document VARCHAR(20),
    client INT
);

-- TELEFONE (coleção de elementos simples)
CREATE TABLE tb_telefone (
    client_id INT NOT NULL,
    phones VARCHAR(20),
    FOREIGN KEY (client_id) REFERENCES tb_cliente(id)
);

-- ENDEREÇO
CREATE TABLE tb_endereco (
    id SERIAL PRIMARY KEY,
    street VARCHAR(100),
    number VARCHAR(20),
    complement VARCHAR(100),
    neighborhood VARCHAR(100),
    postal_code VARCHAR(20),
    city_id INT,
    client_id INT,
    FOREIGN KEY (city_id) REFERENCES tb_city(id),
    FOREIGN KEY (client_id) REFERENCES tb_cliente(id)
);

-- POPULAR CLIENTE
INSERT INTO tb_cliente (name, email, document, client)
VALUES ('João Silva', 'joao@email.com', '12345678901', 1);

-- POPULAR TELEFONES
INSERT INTO tb_telefone (client_id, phones) VALUES (1, '11999990000');
INSERT INTO tb_telefone (client_id, phones) VALUES (1, '11988887777');

-- POPULAR ENDEREÇO
INSERT INTO tb_endereco (street, number, complement, neighborhood, postal_code, city_id, client_id)
VALUES ('Rua das Flores', '123', 'Apto 45', 'Centro', '13000-000', 1, 1);
