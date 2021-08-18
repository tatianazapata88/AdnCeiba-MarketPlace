update compra
set
	fecha = :fecha,
	scotter_id = :scotter_id,
	comprador_id = :comprador,
	ciudadDestinoEnvioScotter = :ciudadDestinoEnvioScotter,
	flete = :flete,
	precio = :precio,
	descuento = :descuento,
	total = :total
where id = :id