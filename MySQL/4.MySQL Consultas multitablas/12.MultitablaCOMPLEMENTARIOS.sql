use mi_bd;

-- Encontrar la cantidad de productos vendidos por cada empleado y mostrar el nombre del empleado junto con la cantidad de productos vendidos.
SELECT e.nombre "Nombre del Empleado", COUNT(v.producto_id) "Total de productos vendidos"
FROM empleados e, ventas v
WHERE e.id = v.empleado_id GROUP BY e.nombre;
-- Calcular el monto total de ventas por cada cliente y mostrar el nombre del cliente junto con el monto total de sus compras.
SELECT c.nombre "Nombre del Cliente", SUM(v.monto_total) "Monto Total de Ventas"
FROM clientes c, ventas v
WHERE c.id = v.cliente_id GROUP BY c.nombre;

-- Encontrar el producto más caro vendido y mostrar su nombre y precio.
SELECT p.nombre, v.precio_unitario
FROM productos p, ventas v
WHERE p.id = v.producto_id
ORDER BY v.precio_unitario DESC
LIMIT 1;

-- Calcular el salario promedio de los empleados en cada departamento y mostrar el nombre del departamento junto con el salario promedio.
SELECT d.nombre AS "Nombre del Departamento", AVG(e.salario) AS "Salario Promedio"
FROM departamentos d, empleados e
WHERE d.id = e.departamento_id
GROUP BY d.nombre;

-- Encontrar la cantidad total de ventas realizadas por cada empleado y mostrar el nombre y apellido del empleado junto con la cantidad 
-- total de ventas.
SELECT e.nombre AS "Nombre del Empleado", e.apellido AS "Apellido del Empleado", COUNT(v.id) AS "Total de Ventas"
FROM empleados e, ventas v
WHERE e.id = v.empleado_id
GROUP BY e.nombre, e.apellido;

-- Encuentra la cantidad de ventas realizadas por cada empleado y muestra el nombre y apellido del empleado junto con la cantidad total
--  de ventas. Limita los resultados a mostrar solo a los empleados que hayan realizado más de 5 ventas y ordenarlos de forma descendente
--  con respecto a la cantidad de ventas.
SELECT e.nombre AS "Nombre del Empleado", e.apellido AS "Apellido del Empleado", COUNT(v.id) AS "Total de Ventas"
FROM empleados e, ventas v
WHERE e.id = v.empleado_id
GROUP BY e.nombre, e.apellido
HAVING COUNT(v.id) > 5
ORDER BY "Total de Ventas" DESC;
-- Calcula el monto total vendido por cada empleado y muestra el nombre del empleado junto con el monto total. Usa la cláusula HAVING
--  para filtrar a aquellos empleados que hayan vendido más de 10 productos en total. Muestra el resultado en orden descendente según
--  el monto total vendido.
SELECT e.nombre AS "Nombre del Empleado", SUM(v.monto_total) AS "Monto Total Vendido"
FROM empleados e, ventas v
WHERE e.id = v.empleado_id
GROUP BY e.nombre
HAVING SUM(v.cantidad) > 10
ORDER BY "Monto Total Vendido" DESC;
-- Encuentra el monto total vendido a cada cliente y muestra el nombre del cliente junto con el monto total. Usa la cláusula HAVING 
-- para filtrar a aquellos clientes cuyo monto total promedio en sus compras sea superior a $1500. Muestra el resultado en orden descendente 
-- según el monto total vendido.
SELECT c.nombre AS "Nombre del Cliente", SUM(v.monto_total) AS "Monto Total"
FROM clientes c, ventas v
WHERE c.id = v.cliente_id
GROUP BY c.nombre
HAVING AVG(v.monto_total) > 1500
ORDER BY "Monto Total" DESC;

-- Calcula la cantidad total de ventas realizadas a cada cliente y muestra el nombre del cliente junto con la cantidad total de ventas. 
-- Limita los resultados a mostrar solo a los clientes que hayan realizado más de 3 ventas ordénalos de forma descendente según la cantidad 
-- de ventas.
SELECT c.nombre AS "Nombre del Cliente", COUNT(v.id) AS "Total de Ventas"
FROM clientes c, ventas v
WHERE c.id = v.cliente_id
GROUP BY c.nombre
HAVING COUNT(v.id) > 3
ORDER BY "Total de Ventas" DESC;

-- Encuentra los productos más caros vendidos (precio mayor a 1000), muestra su nombre y precio y ordenarlos de forma descendente por precio.
SELECT p.nombre AS "Nombre del Producto", v.precio_unitario AS "Precio"
FROM productos p, ventas v
WHERE p.id = v.producto_id AND v.precio_unitario > 1000
ORDER BY v.precio_unitario DESC;
