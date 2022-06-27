-- -----------------------------------------------------
-- Banco de Dados vendas
-- -----------------------------------------------------
CREATE DATABASE vendas;
\c vendas;
-- -----------------------------------------------------
-- Table endereco
-- -----------------------------------------------------
CREATE TABLE endereco (
  id SERIAL NOT NULL,
  descricao VARCHAR(45) NOT NULL,
  cep  VARCHAR(10) NOT NULL,
  PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table cliente
-- -----------------------------------------------------
CREATE TABLE cliente (
  id SERIAL NOT NULL,
  nome VARCHAR(150) NOT NULL,
  e_mail VARCHAR(45) NOT NULL,
  cpf VARCHAR(45) NOT NULL,
  telefone VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table produto
-- -----------------------------------------------------
CREATE TABLE produto (
  id SERIAL NOT NULL,
  descricao VARCHAR(150) NOT NULL,
  valor_unitario DECIMAL(10,2) NOT NULL,
  qtde_estoque DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table fornecedor
-- -----------------------------------------------------
CREATE TABLE fornecedor (
  id SERIAL NOT NULL,
  nome VARCHAR(150) NOT NULL,
  e_mail VARCHAR(45) NOT NULL,
  telefone VARCHAR(45) NOT NULL,
  cnpj VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table cliente_endereco
-- -----------------------------------------------------
CREATE TABLE cliente_endereco (
  id SERIAL NOT NULL,
  cliente_id INT NOT NULL,
  endereco_id INT NOT NULL,
  CONSTRAINT fk_cliente_endereco_cliente1
    FOREIGN KEY (cliente_id)
    REFERENCES cliente (id),
  CONSTRAINT fk_cliente_endereco_endereco1
    FOREIGN KEY (endereco_id)
    REFERENCES endereco (id),
  PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table pedido
-- -----------------------------------------------------
CREATE TABLE pedido (
  id SERIAL NOT NULL,
  data TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  endereco_entrega VARCHAR(45) NOT NULL,
  observacao VARCHAR(500) NULL,
  cliente_id INT NOT NULL,
  CONSTRAINT fk_pedido_cliente1
    FOREIGN KEY (cliente_id)
    REFERENCES cliente (id),
  PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table item_pedido
-- -----------------------------------------------------
CREATE TABLE item_pedido (
  id SERIAL NOT NULL,
  produto_id INT NOT NULL,
  pedido_id INT NOT NULL,
  qtde FLOAT NOT NULL,
  valor_item DECIMAL(10,2) NOT NULL,
  CONSTRAINT fk_item_pedido_produto1
    FOREIGN KEY (produto_id)
    REFERENCES produto (id),
  CONSTRAINT fk_item_pedido_pedido1
    FOREIGN KEY (pedido_id)
    REFERENCES pedido (id),
  PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table compra
-- -----------------------------------------------------
CREATE TABLE compra (
  id SERIAL NOT NULL,
  data VARCHAR(45) NOT NULL,
  fornecedor_id INT NOT NULL,
  CONSTRAINT fk_compra_fornecedor1
    FOREIGN KEY (fornecedor_id)
    REFERENCES fornecedor (id),
  PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table item_compra
-- -----------------------------------------------------
CREATE TABLE item_compra (
  id SERIAL NOT NULL,
  compra_id INT NOT NULL,
  produto_id INT NOT NULL,
  qtde FLOAT NOT NULL,
  valor DECIMAL(10,2) NOT NULL,
  CONSTRAINT fk_item_compra_compra1
    FOREIGN KEY (compra_id)
    REFERENCES compra (id),
  CONSTRAINT fk_item_compra_produto1
    FOREIGN KEY (produto_id)
    REFERENCES produto (id),
  PRIMARY KEY (id)
);

-- -----------------------------------------------------


