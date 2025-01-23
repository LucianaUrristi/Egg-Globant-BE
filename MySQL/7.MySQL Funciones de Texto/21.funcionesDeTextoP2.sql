use mi_bd;

-- Repite el nombre y apellido del estudiante con el nombre "Juan" y apellido "Pérez" tres veces. 
SELECT REPEAT(CONCAT(nombre, ' ', apellido), 3) AS nombre_repetido
FROM estudiantes
WHERE nombre = 'Juan' AND apellido = 'Pérez';

-- Invierte el nombre del estudiante con el nombre "Ana" y apellido "Martínez". 
SELECT REVERSE(nombre) AS nombre_invertido
FROM estudiantes
WHERE nombre = 'Ana' AND apellido = 'Martínez';

-- Devuelve una cadena que contenga 8 caracteres de espacio usando la función SPACE y muéstrala con la función QUOTE.
SELECT QUOTE(SPACE(8)) AS cadena_espacios;

-- Extrae una subcadena que contiene el nombre del estudiante con el nombre "María" y apellido "Gómez" antes de la segunda
-- a utilizando SUBSTRING_INDEX.
SELECT SUBSTRING_INDEX(nombre, 'a', 2) AS subcadena
FROM estudiantes
WHERE nombre = 'María' AND apellido = 'Gómez';

-- Combina las edades de todos los estudiantes en una única cadena separada por comas y orden descendente.
SELECT GROUP_CONCAT(edad ORDER BY edad DESC SEPARATOR ', ') AS edades
FROM estudiantes;

-- Elimina las ‘a’ del nombre' del estudiante con el nombre "Ana" y apellido "Martínez" usando la función REPLACE. 
SELECT REPLACE(nombre, 'a', '') AS nombre_sin_a
FROM estudiantes
WHERE nombre = 'Ana' AND apellido = 'Martínez';

-- Rellena a la derecha el promedio del estudiante con el nombre "Luis" y apellido "Rodríguez" con asteriscos hasta una longitud total de 10 caracteres. 
SELECT LPAD(promedio, 10, '*') AS promedio_relleno
FROM estudiantes
WHERE nombre = 'Luis' AND apellido = 'Rodríguez';

-- Obtén el promedio del estudiante con nombre 'Carlos' y apellido 'López', formateado con dos decimales y utilizando la configuración regional 'es_AR'.
SELECT FORMAT(promedio, 2, 'es_AR') AS promedio_formateado
FROM estudiantes
WHERE nombre = 'Carlos' AND apellido = 'López';
