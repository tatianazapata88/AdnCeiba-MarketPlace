create table persona(
   id INT NOT NULL AUTO_INCREMENT,
   username VARCHAR(10) NOT NULL UNIQUE,
   nombre VARCHAR(100) NOT NULL,
   celular VARCHAR(20) NOT NULL,
   email VARCHAR(200) NOT NULL,
   PRIMARY KEY ( id));

create table scotter (
 id int (4) not null auto_increment,
 marca varchar(30) not null,
 modelo varchar(10) not null,
 precio double not null,
 ciudad varchar (45) not null,
 vendedor int (4)  not null,
 estado varchar (10) not null,
 foto varchar (600) not null,
  primary key (id),
  foreign key (vendedor) REFERENCES persona(id));

create table compra (
 id int (4) not null auto_increment,
 fecha date not null,
 scotterId int(4) not null,
 compradorId int (4) not null,
 ciudadDestinoEnvioScotter varchar (45)  not null,
 flete double not null,
 precio double not null,
 descuento double not null,
 total double not null,
   primary key (id),
   foreign key (scotterId) REFERENCES scotter(id),
   foreign key (compradorId) REFERENCES persona(id));
