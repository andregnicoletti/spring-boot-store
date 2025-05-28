-- Tabela de Estados
CREATE TABLE tb_state (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Tabela de Cidades
CREATE TABLE tb_city (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    state_id BIGINT NOT NULL,
    CONSTRAINT fk_state FOREIGN KEY (state_id) REFERENCES tb_state(id)
);

-- Inserts de Estados Brasileiros
INSERT INTO tb_state (name) VALUES
('Acre'), ('Alagoas'), ('Amapá'), ('Amazonas'), ('Bahia'),
('Ceará'), ('Distrito Federal'), ('Espírito Santo'), ('Goiás'), ('Maranhão'),
('Mato Grosso'), ('Mato Grosso do Sul'), ('Minas Gerais'), ('Pará'), ('Paraíba'),
('Paraná'), ('Pernambuco'), ('Piauí'), ('Rio de Janeiro'), ('Rio Grande do Norte'),
('Rio Grande do Sul'), ('Rondônia'), ('Roraima'), ('Santa Catarina'), ('São Paulo'),
('Sergipe'), ('Tocantins');

-- Inserts de Cidades (coerentes com seus estados)
-- São Paulo
INSERT INTO tb_city (name, state_id) VALUES ('São Paulo', 25);
INSERT INTO tb_city (name, state_id) VALUES ('Campinas', 25);
INSERT INTO tb_city (name, state_id) VALUES ('Santos', 25);

-- Rio de Janeiro
INSERT INTO tb_city (name, state_id) VALUES ('Rio de Janeiro', 19);
INSERT INTO tb_city (name, state_id) VALUES ('Niterói', 19);

-- Minas Gerais
INSERT INTO tb_city (name, state_id) VALUES ('Belo Horizonte', 13);
INSERT INTO tb_city (name, state_id) VALUES ('Uberlândia', 13);

-- Paraná
INSERT INTO tb_city (name, state_id) VALUES ('Curitiba', 16);
INSERT INTO tb_city (name, state_id) VALUES ('Londrina', 16);

-- Rio Grande do Sul
INSERT INTO tb_city (name, state_id) VALUES ('Porto Alegre', 21);

-- Bahia
INSERT INTO tb_city (name, state_id) VALUES ('Salvador', 5);
INSERT INTO tb_city (name, state_id) VALUES ('Feira de Santana', 5);

-- Pernambuco
INSERT INTO tb_city (name, state_id) VALUES ('Recife', 17);

-- Ceará
INSERT INTO tb_city (name, state_id) VALUES ('Fortaleza', 6);

-- Distrito Federal
INSERT INTO tb_city (name, state_id) VALUES ('Brasília', 7);

-- Pará
INSERT INTO tb_city (name, state_id) VALUES ('Belém', 14);

-- Amazonas
INSERT INTO tb_city (name, state_id) VALUES ('Manaus', 4);
