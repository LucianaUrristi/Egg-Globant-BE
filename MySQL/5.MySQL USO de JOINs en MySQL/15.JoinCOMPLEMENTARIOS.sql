use mi_bd;
-- Muestra el nombre y apellido de los empleados que pertenecen al departamento de "Recursos Humanos" y han realizado más de 5 ventas.
SELECT e.nombre AS "Nombre", e.apellido AS "Apellido"
FROM empleados e
JOIN ventas v ON e.id = v.empleado_id
JOIN departamentos d ON e.departamento_id = d.id
WHERE d.nombre = 'Ventas'
GROUP BY e.nombre, e.apellido
HAVING COUNT(v.id) > 5;

-- Muestra el nombre y apellido de todos los empleados junto con la cantidad total de ventas que han realizado, incluso si no han realizado ventas.
SELECT e.nombre AS "Nombre", e.apellido AS "Apellido", COUNT(v.id) AS "Total de Ventas"
FROM empleados e
LEFT JOIN ventas v ON e.id = v.empleado_id
GROUP BY e.nombre, e.apellido;
-- Encuentra el empleado más joven de cada departamento y muestra el nombre del departamento junto con el nombre y la edad del empleado más joven.
SELECT d.nombre AS "Nombre del Departamento", 
       e.nombre AS "Nombre del Empleado", 
       e.apellido AS "Apellido del Empleado", 
       e.edad AS "Edad"
FROM empleados e
JOIN departamentos d ON e.departamento_id = d.id
JOIN (
    SELECT departamento_id, MIN(edad) AS edad_minima
    FROM empleados
    GROUP BY departamento_id
) e_min ON e.departamento_id = e_min.departamento_id AND e.edad = e_min.edad_minima;

-- Calcula el volumen de productos vendidos por cada producto (por ejemplo, menos de 5 como "bajo", entre 5 y 10 como "medio", y más de 10 como
--  "alto") y muestra la categoría de volumen junto con la cantidad y el nombre del producto.
SELECT p.nombre AS "Nombre del Producto", 
       SUM(v.cantidad) AS "Cantidad Total Vendida",
       CASE
           WHEN SUM(v.cantidad) < 5 THEN 'Bajo'
           WHEN SUM(v.cantidad) BETWEEN 5 AND 10 THEN 'Medio'
           ELSE 'Alto'
       END AS "Categoría de Volumen"
FROM productos p
JOIN ventas v ON p.id = v.producto_id
GROUP BY p.nombre;
