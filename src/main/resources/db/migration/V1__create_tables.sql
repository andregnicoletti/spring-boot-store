-- Tabela de Produtos
CREATE TABLE tb_produto (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE PRECISION
);

-- Tabela de Categorias
CREATE TABLE tb_categoria (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Tabela de Associação Produto-Categoria (ManyToMany)
CREATE TABLE tb_produto_categoria (
    product_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    PRIMARY KEY (product_id, category_id),
    CONSTRAINT fk_produto FOREIGN KEY (product_id) REFERENCES tb_produto(id),
    CONSTRAINT fk_categoria FOREIGN KEY (category_id) REFERENCES tb_categoria(id)
);

-- Inserts iniciais de Categorias
INSERT INTO tb_categoria (name) VALUES ('Eletrônicos');
INSERT INTO tb_categoria (name) VALUES ('Roupas');
INSERT INTO tb_categoria (name) VALUES ('Livros');

-- Inserts iniciais de Produtos
INSERT INTO tb_produto (name, price) VALUES ('Notebook', 3500.00);
INSERT INTO tb_produto (name, price) VALUES ('Camisa Polo', 120.00);
INSERT INTO tb_produto (name, price) VALUES ('Java: A Bíblia', 199.90);

-- Associação Produto-Categoria
-- Notebook -> Eletrônicos
INSERT INTO tb_produto_categoria (product_id, category_id) VALUES (1, 1);

-- Camisa Polo -> Roupas
INSERT INTO tb_produto_categoria (product_id, category_id) VALUES (2, 2);

-- Java: A Bíblia -> Livros
INSERT INTO tb_produto_categoria (product_id, category_id) VALUES (3, 3);

-- Java: A Bíblia -> Eletrônicos (por exemplo, versão digital)
INSERT INTO tb_produto_categoria (product_id, category_id) VALUES (3, 1);
