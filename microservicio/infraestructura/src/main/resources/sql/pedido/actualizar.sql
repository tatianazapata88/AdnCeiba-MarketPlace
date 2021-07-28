update pedido
set
	fecha = :fecha,
	bici = :bici,
	comprador = :comprador,
	ciudad = :ciudad,
	destino = :destino,
	flete = :flete,
	precio = :precio,
	descuento = :descuento,
	total = :total
where id = :id