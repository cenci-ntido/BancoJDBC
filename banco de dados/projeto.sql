--Aluno(preferido): Tiago Cenci
--RA: 2018101

DROP TABLE materiaprima;

CREATE TABLE materiaprima (
	id serial4 NOT NULL,
	descricao varchar(30) NOT NULL,
	unidade varchar(5) NOT NULL,
	saldo float8 NOT NULL,
	CONSTRAINT pk_materiaprima PRIMARY KEY (id)
);

INSERT INTO public.materiaprima (descricao,unidade,saldo) VALUES
	 ('Bicarbonato de Sódio','G',321.0),
	 ('Óleo','LT',10.0),
	 ('Farofa','g',500.0),
	 ('Ovo','UN',7.0),
	 ('Leite','LT',12.0),
	 ('Prof Andrea','UN',2.0),
	 ('saldo zero','UN',6.0),
	 ('A','RE',4.0),
	 ('Farinha','KG',2.0);
	 
DROP TABLE compra;

CREATE TABLE compra (
	id serial4 NOT NULL,
	"data" date NOT NULL,
	valor float8 NOT NULL,
	materiaprima int4 NOT NULL,
	quantidade float4 NULL,
	CONSTRAINT pk_compra PRIMARY KEY (id),
	CONSTRAINT compra_fk FOREIGN KEY (materiaprima) REFERENCES materiaprima(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO public.compra ("data",valor,materiaprima,quantidade) VALUES
	 ('2022-11-21',13.0,2,15.0),
	 ('2022-11-28',12.0,11,12.0),
	 ('2022-11-22',15.0,2,3.0),
	 ('2022-11-22',16.0,1,3.0);

DROP TABLE producao;

CREATE TABLE producao (
	id serial4 NOT NULL,
	"data" date NOT NULL,
	materiaprima int4 NULL,
	quantidade int4 NULL,
	CONSTRAINT pk_producao PRIMARY KEY (id),
	CONSTRAINT producao_fk FOREIGN KEY (materiaprima) REFERENCES materiaprima(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO public.producao ("data",materiaprima,quantidade) VALUES
	 ('2022-11-16',1,2),
	 ('2022-11-27',11,12),
	 ('2022-11-16',11,65),
	 ('2022-11-29',6,5),
	 ('2022-11-29',6,5),
	 ('2022-11-29',6,5),
	 ('2022-12-04',14,2);