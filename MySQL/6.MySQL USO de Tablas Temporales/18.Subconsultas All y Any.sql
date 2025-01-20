use mi_bd;

-- Encuentra los nombres de los clientes que han realizado compras de productos con un precio superior a la media de precios de todos los productos.

SELECT c.nombre "Nombre del cliente" FROM clientes c
WHERE c.id = ANY(
    SELECT DISTINCT v.cliente_id FROM ventas v WHERE v.precio_unitario > (
        SELECT AVG(precio) FROM productos
    )
);
-- Encuentra los empleados cuyo salario sea mayor que al menos uno de los salarios de los empleados del departamento de "Ventas".
SELECT CONCAT(e.nombre, " ", e.apellido) "Nombre del empleado"
FROM empleados e
WHERE e.salario > ANY(
    SELECT salario 
    FROM empleados e2
        INNER JOIN departamentos d ON e2.deparamento_id = d.id
    WHERE d.nombre = 'Ventas'
);
-- Encuentra los productos cuyos precios sean mayores que todos los precios de los productos con la palabra "Móvil" en su nombre.
SELECT p.nombre "Nombre del Producto"
FROM productos p
WHERE p.precio > ALL (
SELECT precio
FROM productos
WHERE nombre LIKE '%Móvil%'
);
-- Muestra la información de los clientes que realizaron la compra con el monto total más alto, incluyendo su nombre, dirección y el monto total de compra.
SELECT c.nombre "Nombre del Cliente", c.direccion "Dirección",
MAX(v.monto_total) "Monto Total de Compra"
FROM clientes c INNER JOIN ventas v ON c.id = v.cliente_id
GROUP BY c.nombre, c.direccion
ORDER BY "Monto Total de Compra" DESC
LIMIT 1;
-- Para cada departamento, encuentra el empleado con el salario más alto. Muestra el nombre del departamento junto con el nombre del empleado y su salario
SELECT d.nombre "Departamento", e1.nombre "Nombre del Empleado",
e1.salario "Salario"
FROM departamentos d
JOIN empleados e1 ON d.id = e1.departamento_id
WHERE e1.salario = (
SELECT MAX(e2.salario)
FROM empleados e2
WHERE e2.departamento_id = d.id
);


-- Encuentra los empleados que ganan más que el salario promedio de los empleados del departamento de "Contabilidad".
SELECT e.nombre, e.apellido
FROM empleados e
WHERE e.salario > (
SELECT AVG(e2.salario)
FROM empleados e2
INNER JOIN departamentos d
ON e2.departamento_id = d.id
WHERE d.nombre = 'Contabilidad');
-- Encuentra los productos que tienen un precio superior al precio de al menos uno de los productos vendidos al cliente con nombre "Juan Pérez".
SELECT p.nombre
FROM productos p
WHERE precio > ANY (SELECT precio_unitario FROM ventas v
JOIN clientes c ON v.cliente_id = c.id
WHERE c.nombre = 'Juan Pérez');
-- Encuentra los departamentos en los que al menos hay un empleado menor de 30 años.
SELECT d.nombre
FROM departamentos d
WHERE 0 < (
SELECT COUNT(*)
FROM empleados e
WHERE e.departamento_id = d.id
AND e.edad < 30
);
-- Muestra la información del empleado más joven, que esté entre los 3 empleados con más cantidad de productos vendidos, incluyendo su nombre, apellido y edad.
CREATE TEMPORARY TABLE top_3_empleados_con_mas_productos_vendidos (SELECT
v.empleado_id FROM ventas v GROUP BY v.empleado_id ORDER BY
SUM(v.cantidad) desc limit 3);
SELECT e.nombre, e.apellido, e.edad
FROM empleados e
WHERE e.id = ANY (SELECT empleado_id FROM
top_3_empleados_con_mas_productos_vendidos)
ORDER BY e.edad
LIMIT 1;
-- Para cada cliente, encuentra el empleado que realizó la venta con el monto total más alto. Muestra el nombre del cliente junto con el nombre del empleado y el monto total.
SELECT DISTINCT c.nombre "Nombre cliente", CONCAT(e.nombre,' ',
e.apellido) "Nombre empleado", v.monto_total
FROM clientes c
INNER JOIN ventas v
ON c.id = v.cliente_id
INNER JOIN empleados e
ON v.empleado_id = e.id
WHERE (v.cliente_id, v.monto_total) = (
SELECT v2.cliente_id, MAX(v2.monto_total)
FROM ventas v2
WHERE v2.cliente_id = v.cliente_id
GROUP BY v2.cliente_id) ;



