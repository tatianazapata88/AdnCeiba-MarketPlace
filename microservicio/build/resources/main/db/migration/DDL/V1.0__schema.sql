create table usuario (
 id int(4) not null auto_increment,
 nombre varchar(100) unique not null,
 clave varchar(45) not null,
 fecha_creacion datetime not null,
 primary key (id)
);

create table scotter (
 id int (4) not null auto_increment,
 marca varchar(30) not null,
 modelo varchar(10) not null,
 precio int (10) not null,
 ciudad varchar (45) not null,
 vendedor int (4)  not null,
 estado varchar (10) not null,
 foto varchar (600) not null,
  primary key (id),
  foreign key (vendedor) REFERENCES usuario(id)

);

create table pedido (
 id int (4) not null auto_increment,
 fecha datetime not null,
 bici int(4) not null,
 comprador int (4) not null,
 ciudad varchar (45) not null,
 destino varchar (45)  not null,
 flete int (10) not null,
   primary key (id),
  foreign key (bici) REFERENCES scotter(id)

);