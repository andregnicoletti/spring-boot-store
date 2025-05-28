-- Novas Categorias
INSERT INTO tb_categoria (name) VALUES ('Acessórios');
INSERT INTO tb_categoria (name) VALUES ('Casa & Cozinha');

-- Novos Produtos
INSERT INTO tb_produto (name, price) VALUES ('Fone Bluetooth JBL', 299.90);
INSERT INTO tb_produto (name, price) VALUES ('Liquidificador Arno', 179.00);
INSERT INTO tb_produto (name, price) VALUES ('Relógio Casio Vintage', 249.99);
INSERT INTO tb_produto (name, price) VALUES ('Camiseta Oversized', 89.90);
INSERT INTO tb_produto (name, price) VALUES ('Panela de Pressão', 210.50);

-- Associações Produto-Categoria
-- Fone Bluetooth -> Eletrônicos, Acessórios
INSERT INTO tb_produto_categoria (product_id, category_id) VALUES (4, 1);
INSERT INTO tb_produto_categoria (product_id, category_id) VALUES (4, 4);

-- Liquidificador -> Casa & Cozinha
INSERT INTO tb_produto_categoria (product_id, category_id) VALUES (5, 5);

-- Relógio Casio -> Acessórios
INSERT INTO tb_produto_categoria (product_id, category_id) VALUES (6, 4);

-- Camiseta Oversized -> Roupas
INSERT INTO tb_produto_categoria (product_id, category_id) VALUES (7, 2);

-- Panela de Pressão -> Casa & Cozinha
INSERT INTO tb_produto_categoria (product_id, category_id) VALUES (8, 5);
