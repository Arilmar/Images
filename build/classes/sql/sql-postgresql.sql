CREATE DATABASE projeto_imagens
  WITH OWNER = postgres
       TABLESPACE = pg_default
       CONNECTION LIMIT = -1;


	   
CREATE SEQUENCE sequence_img
INCREMENT 3 
MINVALUE 1
MAXVALUE 200000 
START 1
CYCLE;	   

CREATE TABLE imagens (
  id bigint NOT NULL  default nextval('sequence_img'),
  produto VARCHAR(500) NULL,
  fornecedor VARCHAR(500) NULL,
  miniatura VARCHAR(200) NULL,
  urlimagem  text ,
  urlminiimg text ,
  PRIMARY KEY (id));