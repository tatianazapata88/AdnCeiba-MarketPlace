update pedido
set id = :id,
	fecha = :fecha,
	bici = :bici,
	comprador = :comprador,
	ciudad = :ciudad,
	destino = :destino,
	flete = :flete
where id = :id