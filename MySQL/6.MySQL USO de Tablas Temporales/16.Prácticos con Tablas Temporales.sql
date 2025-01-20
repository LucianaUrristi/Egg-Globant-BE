use mi_bd;
-- Utiliza TABLE para consultar la tabla productos de manera simple, ordenando los productos de forma descendente por precio y solo 10 filas.
TABLE productos ORDER BY precio DESC LIMIT 10;
-- Crea una tabla temporal de los empleados donde unifiques su nombre y apellido en una sola columna.
DROP TEMPORARY TABLE IF EXISTS empleados_temporal;
CREATE TEMPORARY TABLE empleados_temporal AS SELECT CONCAT(nombre, ' ', apellido) nombre FROM empleados;
TABLE empleados_temporal;
-- Crea una tabla temporal de la tabla clientes donde solo tengas la columna nombre.
DROP TEMPORARY TABLE IF EXISTS clientes_temporal;
CREATE TEMPORARY TABLE clientes_temporal AS SELECT nombre FROM clientes;
TABLE clientes_temporal;

-- Realiza la unión entre las tablas temporales de empleados y clientes usando TABLE.
TABLE empleados_temporal UNION TABLE clientes_temporal;

-- Crea una tabla temporal escuela primaria que tenga las siguientes columnas: id(int), nombre(varchar), apellido(varchar), edad(int) y grado(int). Y que tenga los siguientes valores:
-- ID: 1, Nombre: Alejandro, Apellido: González, Edad: 11, Grado: 5
-- ID: 2, Nombre: Isabella, Apellido: López, Edad: 10, Grado: 4
-- ID: 3, Nombre: Lucas, Apellido: Martínez, Edad: 11, Grado: 5 
-- ID: 4, Nombre: Sofía, Apellido: Rodríguez, Edad: 10, Grado: 4 
-- ID: 5, Nombre: Mateo, Apellido: Pérez, Edad: 12, Grado: 6 
-- ID: 6, Nombre: Valentina, Apellido: Fernández, Edad: 12, Grado: 6
-- ID: 7, Nombre: Diego, Apellido: Torres, Edad: 10, Grado: 4
-- ID: 8, Nombre: Martina, Apellido: Gómez, Edad: 11, Grado: 5
-- ID: 9, Nombre: Joaquín, Apellido: Hernández, Edad: 10, Grado: 4
-- ID: 10, Nombre: Valeria, Apellido: Díaz, Edad: 11, Grado: 5
DROP TEMPORARY TABLE IF EXISTS escuela_primaria;
CREATE TEMPORARY TABLE escuela_primaria (id INT, nombre VARCHAR(50), apellido VARCHAR(50), edad INT, grado INT);
INSERT INTO escuela_primaria(id, nombre, apellido, edad, grado) 
    VALUES (1, 'Alejandro', 'González', 11, 5),
            (2, 'Isabella', 'López', 10, 4),
            (3, 'Lucas', 'Martínez', 11, 5),
            (4, 'Sofía', 'Rodríguez', 10, 4),
            (5, 'Mateo', 'Pérez', 12, 6),
            (6, 'Valentina', 'Fernández', 12, 6),
            (7, 'Diego', 'Torres', 10, 4),
            (8, 'Martina', 'Gómez', 11, 5),
            (9, 'Joaquín', 'Hernández', 10, 4),
            (10, 'Valeria', 'Díaz', 11, 5),
            (11, 'Ana', 'Ruiz', 10, 4);
TABLE escuela_primaria;