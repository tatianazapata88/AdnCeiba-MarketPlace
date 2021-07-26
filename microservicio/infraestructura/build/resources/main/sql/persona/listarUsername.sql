SELECT id,
    username
    nombre,
    celular,
    email
FROM persona
WHERE username = :username;