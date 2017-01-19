--GP means GreenPlum DB (a database based on PostgreSQL)

--person table DDL
CREATE TABLE cjh_test_person (
    id integer,
    name character varying(64)
) DISTRIBUTED BY (id);

--test insert values
insert into cjh_test_person values (1,'jerry'), (2, 'tom');