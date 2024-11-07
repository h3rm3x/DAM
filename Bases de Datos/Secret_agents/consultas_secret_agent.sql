-- SALARIO MEDIO DE LOS AGENTES DE LA ORGANIZACION BRITANICA
SELECT  organization, AVG(salary) AS 'sueldo medio'
FROM secret_user
WHERE organization LIKE '%MI%';
-- AGENTES QUE COBRAN MAS QUE EL SUELDO MEDIO
SELECT *
FROM secret_user
WHERE salary > (SELECT  AVG(salary) FROM secret_user);
-- agentes cullo apellido tiene mas que 4 caracteres
SELECT *
FROM secret_user
WHERE CHAR_LENGTH(last_name)>4;
-- borrar agentes con nombres de menos de 3 letras
DELETE
FROM secret_user 
WHERE CHAR_LENGTH(first_name)<3;
--RELLENAR columna fullname con first_name y last_name
UPDATE secret_user
SET full_name = CONCAT(first_name, ' ', last_name)