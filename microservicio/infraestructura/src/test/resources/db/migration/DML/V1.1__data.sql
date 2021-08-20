insert into persona(username,nombre,celular,email) values( 'taty','Luz Tatiana Zapata','3135151617', 'tatianazz3@hotmail.com');
insert into persona(username,nombre,celular,email) values( 'tiara','Tiara Enriqueta','3003680128', 'tiara@hotmail.com');

insert into scotter(marca,modelo,precio,ciudad,vendedor,estado,foto) values( 'toyota','2022',4000000.0, 'Medellin',1,'DISPONIBLE','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTxO8c_NQBofFx4kxZ2qTd6CKrCbkRtnqbLA&usqp=CAU');
insert into scotter(marca,modelo,precio,ciudad,vendedor,estado,foto) values( 'bmw','2022',5000000.0, 'Medellin',2,'DISPONIBLE','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTxO8c_NQBofFx4kxZ2qTd6CKrCbkRtnqbLA&usqp=CAU');
insert into scotter(marca,modelo,precio,ciudad,vendedor,estado,foto) values( 'honda','2022',1000000.0, 'Medellin',2,'DISPONIBLE','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTxO8c_NQBofFx4kxZ2qTd6CKrCbkRtnqbLA&usqp=CAU');

insert into compra (fecha,scotterId,compradorId,ciudadDestinoEnvioScotter,flete,precio,descuento,total) values ('2021-07-28',2,1,'Medellin',0.0,5000000.0,0.0,5000000.0)
