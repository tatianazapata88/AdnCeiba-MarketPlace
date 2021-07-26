create table persona(
   id INT NOT NULL AUTO_INCREMENT,
   username VARCHAR(10) NOT NULL UNIQUE,
   nombre VARCHAR(100) NOT NULL,
   celular VARCHAR(20) NOT NULL,
   email VARCHAR(200) NOT NULL,
   PRIMARY KEY ( id)
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
  foreign key (vendedor) REFERENCES persona(id)

);

create table pedido (
 id int (4) not null auto_increment,
 fecha datetime not null,
 bici int(4) not null,
 comprador int (4) not null,
 ciudad varchar (45) not null,
 destino varchar (45)  not null,
 flete int (10) not null,
 precio int (10) not null,
 descuento int (10) not null,
 total int (10) not null,
   primary key (id),
  foreign key (bici) REFERENCES scotter(id)

);