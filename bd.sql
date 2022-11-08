--CLIENTES
CREATE TABLE cliente (
   idcliente SERIAL NOT NULL,
   nomecliente VARCHAR(35) NOT NULL,
   cpf BIGINT NOT NULL,
   genero CHAR(1) NOT NULL,
   datanascimento DATE NOT NULL,
   CONSTRAINT pk_cliente PRIMARY KEY (idcliente)
);
--   CHECK (genero IN ('F', 'M')),

--CARROS
CREATE TABLE carro (
   idcarro SERIAL NOT NULL,
   modelo VARCHAR(35) NOT NULL,
   marca VARCHAR(35) NOT NULL,
   anomodelo INTEGER NOT NULL,
   anofabricacao INTEGER NOT NULL,
   CONSTRAINT pk_carro PRIMARY KEY (idcarro)
);

--LOCACAO
CREATE TABLE locacao (
   idlocacao SERIAL NOT NULL,
   idcliente INTEGER NOT NULL,
   idcarro INTEGER NOT NULL,
   descricao VARCHAR(100) NOT NULL,
   datalocacao DATE NOT NULL,
   datadevolucao DATE NOT NULL,
   preco NUMERIC CHECK(preco>0) NOT NULL,
   ativo BOOLEAN default True,
   CONSTRAINT fk_cliente FOREIGN KEY (idcliente) REFERENCES cliente (idcliente),
   CONSTRAINT fk_carro FOREIGN KEY (idcarro) REFERENCES carro (idcarro),
   CONSTRAINT pk_locacao PRIMARY KEY (idlocacao)
);

--ACESSORIOS
CREATE TABLE acessorio (
   idacessorio SERIAL NOT NULL,
   descricao VARCHAR(100) NOT NULL,
   quantidade INTEGER NOT NULL,
   preco NUMERIC CHECK(preco>0) NOT NULL,
   idcarro INTEGER NOT NULL,
   CONSTRAINT fk_carro FOREIGN KEY (idcarro) REFERENCES carro (idcarro),
   CONSTRAINT pk_acessorio PRIMARY KEY (idacessorio)
);


insert into cliente (idcliente, nomecliente, cpf, genero, datanascimento) VALUES (1, 'João da Silva', 01987655503, 'M', '2000-05-12');
insert into cliente (idcliente, nomecliente, cpf, genero, datanascimento) VALUES (2, 'Fernanda Soares', 01946494503, 'F', '1999-09-21');
