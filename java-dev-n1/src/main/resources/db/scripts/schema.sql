CREATE TABLE uf
  (cd_uf int PRIMARY KEY,
   ds_uf_sigla varchar(2),
   ds_uf_nome varchar(25));

CREATE TABLE cidades
  (cd_uf int,
   cd_cidade int PRIMARY KEY,
   ds_cidade_nome varchar(100),
   FOREIGN KEY (cd_uf) REFERENCES uf(cd_uf));

CREATE TABLE bairros
  (cd_bairro int PRIMARY KEY,
   cd_cidade int,
   ds_bairro_nome varchar(100),
   FOREIGN KEY (cd_cidade) REFERENCES cidades(cd_cidade));

CREATE TABLE LOGRADOUROS
  (CD_LOGRADOURO int PRIMARY KEY,
   CD_BAIRRO int,
   CD_TIPO_LOGRADOUROS int,
   DS_LOGRADOURO_NOME varchar(100),
   NO_LOGRADOURO_CEP varchar(8),
   FOREIGN KEY (CD_BAIRRO) REFERENCES bairros(cd_bairro));

CREATE VIEW vw_zipcode AS
    SELECT l.NO_LOGRADOURO_CEP as id,
           l.DS_LOGRADOURO_NOME as street,
           b.ds_bairro_nome as district,
           c.ds_cidade_nome as city,
           u.ds_uf_sigla as state
    FROM   LOGRADOUROS l
    JOIN   bairros b  ON  l.CD_BAIRRO = b.cd_bairro
    JOIN   cidades c  ON  b.cd_cidade = c.cd_cidade
    JOIN   uf u       ON  c.cd_uf = u.cd_uf;