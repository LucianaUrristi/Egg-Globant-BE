use mi_bd;

-- Crea una tabla llamada "estudiantes" con cinco columnas: "id" de tipo INT como clave primaria, "nombre" de tipo VARCHAR(50),
-- "apellido" de tipo VARCHAR(50), "edad" de tipo INT y "promedio" de tipo FLOAT. Luego, inserta cinco filas en la tabla "estudiantes"
-- con los siguientes datos:

-- ID: 1, Nombre: Juan, Apellido: Pérez, Edad: 22, Promedio: 85.5
-- ID: 2, Nombre: María, Apellido: Gómez, Edad: 21, Promedio: 90.0
-- ID: 3, Nombre: Luis, Apellido: Rodríguez, Edad: 20, Promedio: 88.5
-- ID: 4, Nombre: Ana, Apellido: Martínez, Edad: 23, Promedio: 92.0
-- ID: 5, Nombre: Carlos, Apellido: López, Edad: 22, Promedio: 86.5

CREATE TABLE estudiantes (
    id INT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    edad INT,
    promedio FLOAT);

INSERT INTO estudiantes (id, nombre, apellido, edad, promedio)
    VALUES (1, 'Juan', 'Pérez', 22, 85.5),
            (2, 'María', 'Gómez', 21, 90.0),
            (3, 'Luis', 'Rodríguez', 20, 88.5),
            (4, 'Ana', 'Martínez', 23, 92.0),
            (5, 'Carlos', 'López', 22, 86.5);

TABLE estudiantes;

-- Encuentra la longitud del nombre del estudiante con el nombre "Luis" y apellido "Rodríguez".
SELECT LENGTH(nombre) AS longitud_nombre
FROM estudiantes
WHERE nombre = 'Luis' AND apellido = 'Rodríguez';

-- Concatena el nombre y el apellido del estudiante con el nombre "María" y apellido "Gómez" con un espacio en el medio. 
SELECT CONCAT(nombre, ' ', apellido) AS nombre_completo
FROM estudiantes
WHERE nombre = 'María' AND apellido = 'Gómez';

-- Encuentra la posición de la primera 'e' en el apellido del estudiante con el nombre "Juan" y apellido "Pérez". 
SELECT INSTR(apellido, 'é') AS posicion_e
FROM estudiantes
WHERE nombre = 'Juan' AND apellido = 'Pérez';

-- Inserta la cadena ' García' en la posición 3 del nombre del estudiante con el nombre "Ana" y apellido "Martínez".
SELECT INSERT(nombre, 3, 0, ' García') AS nombre_modificado
FROM estudiantes
WHERE nombre = 'Ana' AND apellido = 'Martínez';

-- Convierte el nombre del estudiante con el nombre "Luis" y apellido "Rodríguez" a minúsculas. (LOWER)
SELECT LOWER(nombre) AS nombre_minusculas
FROM estudiantes
WHERE nombre = 'Luis' AND apellido = 'Rodríguez';

-- Convierte el apellido del estudiante con el nombre "Juan" y apellido "Pérez" a mayúsculas. (UPPER)
SELECT UPPER(apellido) AS apellido_mayusculas
FROM estudiantes
WHERE nombre = 'Juan' AND apellido = 'Pérez';

-- Obtiene los primeros 4 caracteres del apellido del estudiante con el nombre "María" y apellido "Gómez". (LEFT)
SELECT LEFT(apellido, 4) AS primeros_4_caracteres
FROM estudiantes
WHERE nombre = 'María' AND apellido = 'Gómez';

-- Obtiene los últimos 3 caracteres del apellido del estudiante con el nombre "Ana" y apellido "Martínez". (RIGHT)
SELECT RIGHT(apellido, 3) AS ultimos_3_caracteres
FROM estudiantes
WHERE nombre = 'Ana' AND apellido = 'Martínez';

-- Encuentra la posición de la primera 'o' en el nombre del estudiante con el nombre "Carlos" y apellido "López". (LOCATE)
SELECT LOCATE('o', nombre) AS posicion_o
FROM estudiantes
WHERE nombre = 'Carlos' AND apellido = 'López';

-- Encuentra la posición de la primera aparición de la letra 'a' en el nombre de la estudiante con el nombre "María" y apellido "Gómez".
SELECT POSITION('a' IN nombre) AS posicion_a
FROM estudiantes
WHERE nombre = 'María' AND apellido = 'Gómez';

-- Reemplaza 'a' con 'X' en el nombre del estudiante con el nombre "Ana" y apellido "Martínez". 
SELECT REPLACE(LOWER(nombre), 'a', 'X') AS nombre_modificado
FROM estudiantes
WHERE nombre = 'Ana' AND apellido = 'Martínez';

-- Encuentra la subcadena de 3 caracteres de longitud de la columna 'nombre' del estudiante con el nombre "María" y apellido "Gómez", comenzando en la posición 2.
SELECT SUBSTRING(nombre, 2, 3) AS subcadena
FROM estudiantes
WHERE nombre = 'María' AND apellido = 'Gómez';

-- Combina los nombres de todos los estudiantes en una única cadena separada por guiones.
SELECT GROUP_CONCAT(nombre SEPARATOR ' - ') AS nombres_concatenados
FROM estudiantes;

-- Combina los nombres y apellidos de todos los estudiantes en una única cadena separada por un guion vertical (|). 
SELECT GROUP_CONCAT(CONCAT(nombre, ' ', apellido) SEPARATOR ' | ') AS nombres_apellidos_concatenados
FROM estudiantes;

-- Elimina los espacios en blanco iniciales del texto "    … usé muchos espacios    ".
SELECT LTRIM('    … usé muchos espacios    ') AS sin_espacios_iniciales;

-- Elimina los espacios en blanco finales del texto "    … usé muchos espacios    ".
SELECT RTRIM('    … usé muchos espacios    ') AS sin_espacios_finales;

-- Cita el resultado de los dos ejercicios anteriores utilizando la función QUOTE.
SELECT QUOTE(LTRIM('    … usé muchos espacios    ')) AS citado_sin_espacios_iniciales,
       QUOTE(RTRIM('    … usé muchos espacios    ')) AS citado_sin_espacios_finales;
