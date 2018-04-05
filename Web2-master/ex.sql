create database bd;
use bd;

create table tb_usuario
(
	id integer primary key auto_increment,
	nome_usuario varchar(100),
	senha_usuario varchar(50),
    login_usuario varchar(50)
);

create table tb_cliente
(
	id_cliente integer primary key auto_increment,
    cpf_cliente char(11),
    nome_cliente varchar(100),
    email_cliente varchar(100),
    cep_cliente char(8),
    rua_cliente varchar(100),
    nr_cliente integer,
    cidade_cliente varchar(100),
    data_cliente date,
	uf_cliente char(2)
);

insert into tb_usuario(nome_usuario,senha_usuario,login_usuario) values ('Gabriel','1234','vrag');
insert into tb_usuario(nome_usuario,senha_usuario,login_usuario) values ('Daniel','123456','danyhero');
insert into tb_usuario(nome_usuario,senha_usuario,login_usuario) values ('Thiago','12341234','catchoro');

insert into tb_cliente(nome_cliente, cpf_cliente, email_cliente, cep_cliente, rua_cliente, nr_cliente, cidade_cliente, data_cliente, uf_cliente) values
('Luiza Helena', '48321228437', 'luiza@gmail.com', '37004808', 'Rua Baena', 123, 'Curitiba', '1998-04-05','PR'),
('Daniela Enzo', '85672612369', 'daniela@gmail.com', '24732590', 'Travessa João', 41, 'Patos', '1997-05-06','PB'),
('Benjamim Emanuel', '97020753272', 'benjamim@gmail.com', '02873280', 'Rua da Mangueira', 612, 'Santo André', '1995-06-07','SP'),
('Telmo Florbela', '78751163500', 'telmo@gmail.com', '82100185', 'Rua Bigorna', 1025, 'São Paulo', '1999-07-08','SP'),
('Rosaura Anabela', '52544286865', 'rosaura@gmail.com', '39803169', 'Rua Carlos', 452, 'Recife', '1997-08-09','PE'),
('Virgolina Alfredo', '40307242560', 'virgolina@gmail.com', '13087100', 'Rua São Paulo', 156, 'Santa Luzia', '1995-04-03','MG'),
('Hermesinda Adélia', '96184752634', 'hermesinda@gmail.com', '56321111', 'Rua Gagi', 541, 'Londrina', '1996-05-02','PR'),
('Miquelina Graciano', '53733242726', 'miquelina@gmail.com', '03449020', 'Rua Antônio', 245, 'Colatina', '1997-06-04','ES'),
('Mariana Matilda', '37330257338', 'mariana@gmail.com', '82700280', 'Rua Ruthe', 613, 'Diadema', '1997-07-03','SP'),
('Leonor Elmira', '60425433340', 'leonor@gmail.com', '13411069', 'Rua Waldemar', 510, 'João Pessoa', '1998-08-05','PB');
