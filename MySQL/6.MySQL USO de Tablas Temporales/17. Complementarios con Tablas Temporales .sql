use mi_bd;

-- Agrega un cliente nuevo con el nombre “Ana Rodríguez” y con dirección en “San Martín 2515, Mar del Plata”.
--  Luego realiza la intersección entre la tabla temporal de empleados y clientes.
TABLE clientes_temporal;
INSERT INTO clientes (id, nombre, direccion)
VALUES (10, 'Ana Rodríguez', 'San Martín 2515, Mar del Plata');

-- En MySQL, la función INTERSECT no está soportada de manera nativa, a diferencia de otros sistemas de bases de 
-- datos como PostgreSQL o SQL Server. Sin embargo, puedes lograr el mismo efecto utilizando un INNER JOIN o utilizando 
-- una consulta con DISTINCT en combinación con UNION ALL y un conteo para simular el comportamiento de INTERSECT.


SELECT e.nombre, e.apellido FROM empleados e
INNER JOIN clientes c
ON CONCAT(e.nombre, " ", e.apellido) = c.nombre;

-- Realiza la excepción entre la tabla temporal de clientes y la de empleados.
-- Usamos * para seleccionar todas las columnas de esa tabla en vez de nombrarlas una por una.
SELECT c.*
FROM clientes c
LEFT JOIN empleados e
ON CONCAT(e.nombre, " ", e.apellido) = c.nombre
WHERE e.id IS NULL;


-- Crea una tabla temporal escuela secundaria que tenga las siguientes columnas: id(int), 
-- nombre(varchar), apellido(varchar), edad(int) y grado(int). Y que tenga los siguientes valores:
-- ID: 1, Nombre: Eduardo, Apellido: Sánchez, Edad: 16, Grado: 10
-- ID: 2, Nombre: Camila, Apellido: Martín, Edad: 17, Grado: 11
-- ID: 3, Nombre: Manuel, Apellido: Gutiérrez, Edad: 15, Grado: 9
-- ID: 4, Nombre: Laura, Apellido: García, Edad: 16, Grado: 10
-- ID: 11, Nombre: Pablo, Apellido: Ortega, Edad: 17, Grado: 11
-- ID: 12, Nombre: Carmen, Apellido: Ramírez, Edad: 15, Grado: 9
-- ID: 13, Nombre: Carlos, Apellido: Molina, Edad: 16, Grado: 10
-- ID: 14, Nombre: Ana, Apellido: Ruiz, Edad: 17, Grado: 11
-- ID: 15, Nombre: Luis, Apellido: Fernández, Edad: 15, Grado: 9
-- ID: 16, Nombre: María, Apellido: López, Edad: 16, Grado: 10
DROP TEMPORARY TABLE IF EXISTS escuela_secundaria;
CREATE TEMPORARY TABLE escuela_secundaria (id INT, nombre VARCHAR(50), apellido VARCHAR(50), edad INT, grado INT);
INSERT INTO escuela_secundaria(id, nombre, apellido, edad, grado) 
    VALUES (1, 'Eduardo', 'Sánchez', 16, 10),
            (2, 'Camila', 'Martín', 17, 11),
            (3, 'Manuel', 'Gutiérrez', 15, 9),
            (4, 'Laura', 'García', 16, 10),
            (5, 'Pablo', 'Ortega', 17, 11),
            (6, 'Carmen', 'Ramírez', 15, 9),
            (7, 'Carlos', 'Molina', 16, 10),
            (8, 'Ana', 'Ruiz', 17, 11),
            (9, 'Luis', 'Fernández', 15, 9),
            (10, 'María', 'López', 16, 10),
            (11, 'Diego', 'Torres', 17, 11);

TABLE escuela_secundaria;

-- Realiza la intersección de la escuela primaria y escuela secundaria con el nombre y apellido de los alumnos para saber quienes fueron a ambas escuelas.
SELECT ep.nombre "Nombre", ep.apellido "Apellido"
FROM escuela_primaria ep
UNION SELECT es.nombre, es. apellido FROM escuela_secundaria es;

-- Realiza la excepción de la escuela primaria con la secundaria para saber quienes no siguieron cursando en dicha escuela secundaria.
-- En MySQL, no existe el operador EXCEPT directamente como en otros sistemas de bases de datos como SQL Server o PostgreSQL. Para lograr el mismo efecto, 
-- puedes usar una consulta con una combinación de LEFT JOIN y WHERE para encontrar los registros de la tabla escuela_primaria que no están en la tabla escuela_secundaria.
-- TABLE escuela_primaria EXCEPT TABLE escuela_secundaria;
SELECT p.*
FROM escuela_primaria p
LEFT JOIN escuela_secundaria s
ON p.nombre = s.nombre and p.apellido = s.apellido
WHERE s.id IS NULL;

-- Realiza la excepción de la escuela secundaria con la primaria para saber quienes no siguieron cursando en dicha escuela secundaria.
SELECT s.*
FROM escuela_secundaria s
LEFT JOIN escuela_primaria p
ON s.nombre = p.nombre AND s.apellido = p.apellido
WHERE p.id IS NULL;

-- Realiza la unión de la escuela primaria y secundaria con la columna grado para saber cuáles son los grados que abarcan ambas escuelas, y ordénalos de forma descendente.
SELECT grado
FROM escuela_primaria
UNION
SELECT grado
FROM escuela_secundaria
ORDER BY grado DESC;
