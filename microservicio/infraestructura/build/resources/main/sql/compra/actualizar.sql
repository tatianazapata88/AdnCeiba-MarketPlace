update compra
set
	fecha = :fecha,
	scotter_id = :scotter_id,
	comprador = :comprador,
	ciudadorigen = :ciudadoOrigenUbicacionScotter,
	ciudaddestino = :ciudadDestinoEnvioScotter,
	flete = :flete,
	precio = :precio,
	descuento = :descuento,
	total = :total
where id = :id