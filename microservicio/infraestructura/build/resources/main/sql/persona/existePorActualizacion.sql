SELECT count(1)
FROM persona
WHERE username = :username and id <> :id;