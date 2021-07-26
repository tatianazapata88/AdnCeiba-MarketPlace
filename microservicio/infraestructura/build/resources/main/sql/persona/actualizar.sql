UPDATE persona
SET
username = :username,
nombre = :nombre,
celular = :celular,
email = :email
WHERE id = :id;