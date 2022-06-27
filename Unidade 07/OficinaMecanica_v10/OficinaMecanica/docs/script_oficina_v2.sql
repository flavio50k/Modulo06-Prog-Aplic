
-- -----------------------------------------------------
-- Table cidade
-- -----------------------------------------------------
CREATE TABLE cidade (
  id SERIAL NOT NULL,
  descricao VARCHAR(100) NULL,
  PRIMARY KEY (id)
);


-- -----------------------------------------------------
-- Table pessoa
-- -----------------------------------------------------
CREATE TABLE pessoa (
  id SERIAL NOT NULL,
  nome VARCHAR(100) NULL,
  cpf VARCHAR(20) NULL,
  data_nascimento TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  telefone VARCHAR(20) NULL,
  cidade_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_pessoa_cidade
    FOREIGN KEY (cidade_id)
    REFERENCES cidade (id)
);



-- -----------------------------------------------------
-- Table item
-- -----------------------------------------------------
CREATE TABLE item (
  id SERIAL NOT NULL,
  decsricao VARCHAR(100) NULL,
  valor DECIMAL(10,2) NULL,
  tipo VARCHAR(1) NULL,
  PRIMARY KEY (id)
);


-- -----------------------------------------------------
-- Table os
-- -----------------------------------------------------
CREATE TABLE os (
  id SERIAL NOT NULL,
  data_os TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  situacao VARCHAR(1) NULL,
  pessoa_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_os_pessoa1
    FOREIGN KEY (pessoa_id)
    REFERENCES pessoa (id)
);


-- -----------------------------------------------------
-- Table os_item
-- -----------------------------------------------------
CREATE TABLE os_item (
  id SERIAL NOT NULL,
  qtde DECIMAL(3,2) NULL,
  os_itenscol DECIMAL(10,2) NULL,
  os_id INT NOT NULL,
  item_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_os_itens_os1
    FOREIGN KEY (os_id)
    REFERENCES os (id),
  CONSTRAINT fk_os_itens_item1
    FOREIGN KEY (item_id)
    REFERENCES item (id)
);


-- -----------------------------------------------------
-- Table financeiro
-- -----------------------------------------------------
CREATE TABLE financeiro (
  id SERIAL NOT NULL,
  data_prevista TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  valor_previsto DECIMAL(10,2) NULL,
  data_pagamento TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  valor_pagamento DECIMAL(10,2) NULL,
  os_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_financeiro_os1
    FOREIGN KEY (os_id)
    REFERENCES os (id)
);

CREATE TABLE usuario (
  id SERIAL NOT NULL,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  senha VARCHAR(100) NOT NULL,
  situacao VARCHAR(1) NOT NULL
);

insert into usuario values (default, 'Juca Bala', 'juca@email.com', md5('teste123'), 'a');


