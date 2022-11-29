-- public.materiaprima definition

-- Drop table

-- DROP TABLE materiaprima;

CREATE TABLE materiaprima (
	id serial4 NOT NULL,
	descricao varchar(30) NOT NULL,
	unidade varchar(5) NOT NULL,
	saldo float8 NOT NULL,
	CONSTRAINT pk_materiaprima PRIMARY KEY (id)
);

INSERT INTO public.materiaprima (descricao,unidade,saldo) VALUES
	 ('Ovo','UN',0.0),
	 ('Farinha','KG',1.0),
	 ('Açúcar','KG',3.0),
	 ('Aveia','G',500.0),
	 ('Leite','LT',10.0),
	 ('Bicarbonato de Sódio','G',321.0),
	 ('Óleo','LT',8.0);
-- public.compra definition

-- Drop table

-- DROP TABLE compra;

CREATE TABLE compra (
	id serial4 NOT NULL,
	"data" date NOT NULL,
	valor float8 NOT NULL,
	materiaprima int4 NOT NULL,
	quantidade float4 NULL,
	CONSTRAINT pk_compra PRIMARY KEY (id),
	CONSTRAINT compra_fk FOREIGN KEY (materiaprima) REFERENCES materiaprima(id)
);

INSERT INTO public.compra ("data",valor,materiaprima,quantidade) VALUES
	 ('2022-11-16',10.0,2,30.0),
	 ('2022-11-21',12.0,1,15.0),
	 ('2022-11-22',15.520000457763672,2,3.0),
	 ('2022-11-22',6.670000076293945,1,3.0),
	 ('2022-11-22',6.0,9,3.0),
	 ('2022-11-22',445.0,1,7.0);

-- public.producao definition

-- Drop table

-- DROP TABLE producao;

CREATE TABLE producao (
	id serial4 NOT NULL,
	"data" date NOT NULL,
	materiaprima int4 NULL,
	quantidade int4 NULL,
	CONSTRAINT pk_producao PRIMARY KEY (id),
	CONSTRAINT producao_fk FOREIGN KEY (materiaprima) REFERENCES materiaprima(id)
);

INSERT INTO public.producao ("data",materiaprima,quantidade) VALUES
	 ('2022-11-16',1,2),
	 ('2022-11-16',11,0),
	 ('2022-11-16',9,4),
	 ('2022-11-27',11,12);