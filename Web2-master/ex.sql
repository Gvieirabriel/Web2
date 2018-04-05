create database bd;
use bd;

create table tb_usuario
(
	id integer primary key auto_increment,
	nome_usuario varchar(100) ,
	senha_usuario varchar(50),
    login_usuario varchar(50)
);

insert into tb_usuario(nome_usuario,senha_usuario,login_usuario) values ('Gabriel','1234','vrag');
insert into tb_usuario(nome_usuario,senha_usuario,login_usuario) values ('Daniel','123456','danyhero');
insert into tb_usuario(nome_usuario,senha_usuario,login_usuario) values ('Thiago','12341234','catchoro');
