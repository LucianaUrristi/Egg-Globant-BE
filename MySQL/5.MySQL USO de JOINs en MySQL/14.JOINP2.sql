-- Calcula la cantidad de ventas por departamento, incluso si el departamento no tiene ventas.
SELECT d.nombre Departamento, COUNT(v.id) as "Cantidad de Ventas"
FROM departamentos d
LEFT JOIN empleados e
ON d.id = e.departamento_id
LEFT JOIN ventas v
ON e.id = v.empleado_id
GROUP BY d.nombre;
-- Encuentra el nombre y la dirección de los clientes que han comprado más de 3 productos y muestra la cantidad de productos comprados.
SELECT c.nombre AS Cliente, c.direccion AS Direccion, COUNT(DISTINCT
v.producto_id) AS "Cantidad de Productos Comprados"
FROM clientes c
LEFT JOIN ventas v
ON c.id = v.cliente_id
GROUP BY c.nombre, c.direccion
HAVING COUNT(DISTINCT v.producto_id) > 3;
-- Calcula el monto total de ventas realizadas por cada departamento y muestra el nombre del departamento junto con el monto total de ventas.
SELECT d.nombre Departamento, SUM(v.monto_total) "Monto Total de Ventas"
FROM departamentos d
LEFT JOIN empleados e
ON d.id = e.departamento_id
LEFT JOIN ventas v
ON e.id = v.empleado_id
GROUP BY d.nombre;