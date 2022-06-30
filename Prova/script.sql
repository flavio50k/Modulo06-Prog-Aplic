-- -----------------------------------------------------
-- Banco de Dados base_200820
-- -----------------------------------------------------

DROP DATABASE [IF EXISTS] base_200820;

CREATE DATABASE base_200820;
\c base_200820;
-- -----------------------------------------------------
-- Table endereco
-- -----------------------------------------------------
CREATE TABLE marca (
  id SERIAL NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table cliente
-- -----------------------------------------------------
CREATE TABLE veiculo (
  id SERIAL NOT NULL,
  modelo VARCHAR(100) NOT NULL,
  ano INT NOT NULL,
  cor VARCHAR(45) NOT NULL,
  marca_id INT NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO marca VALUES (DEFAULT, 'Marca 1');
INSERT INTO marca VALUES (DEFAULT, 'Marca 2');
INSERT INTO marca VALUES (DEFAULT, 'Marca 3');
