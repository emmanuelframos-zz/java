CREATE DATABASE studies WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default;

CREATE TABLE employee (
  id bigint NOT NULL,
  firstname character varying(40) NOT NULL,
  lastname character varying(40) NOT NULL,
  CONSTRAINT employee_pkey PRIMARY KEY (id)
);