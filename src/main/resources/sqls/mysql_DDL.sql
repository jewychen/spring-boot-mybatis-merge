--user table DDL
create table user
  (id bigint not null auto_increment,
  username varchar(64),
  password varchar(64),
  PRIMARY KEY (`id`)
)

--test insert values
INSERT INTO user  VALUES (1,'jerry','123456') , (2,'tom', '123456');