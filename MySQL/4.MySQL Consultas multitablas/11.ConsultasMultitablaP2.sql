use mi_bd;
-- Calcular el monto total de ventas por departamento y mostrar el nombre del departamento junto con el monto total de ventas.
SELECT d.nombre "Nombre del Departamento", SUM(v.monto_total) "Monto Total
de Ventas"
FROM empleados e, ventas v, departamentos d
WHERE e.id = v.empleado_id AND e.departamento_id = d.id GROUP BY d.nombre;


-- Encontrar el empleado más joven de cada departamento y mostrar el nombre del departamento junto con la edad del empleado más joven.
SELECT d.nombre, min(e.edad)
FROM empleados e, departamentos d
WHERE e.departamento_id = d.id group by d.nombre;
-- Calcular el volumen de productos vendidos por cada producto (por ejemplo, menos de 5 “bajo”, menos 8 “medio” y mayor o igual
--  a 8 “alto”) y mostrar la categoría de volumen junto con la cantidad y el nombre del producto.
SELECT p.nombre,
CASE
WHEN SUM(v.cantidad) <= 4 THEN 'Bajo'
WHEN SUM(v.cantidad) <= 7 THEN 'Medio'
ELSE 'Alto' END AS "Categoría de volumen", SUM(v.cantidad)
"Cantidad de Productos Vendidos"
FROM ventas v, productos p
WHERE v.producto_id = p.id GROUP BY p.nombre;
-- Encontrar el cliente que ha realizado el mayor monto total de compras y mostrar su nombre y el monto total.
SELECT c.nombre "Nombre del Cliente", MAX(v.monto_total) "Monto Total de
Compras"
FROM clientes c, ventas v
WHERE c.id = v.cliente_id GROUP BY c.nombre;
-- Calcular el precio promedio de los productos vendidos por cada empleado y mostrar el nombre del empleado junto 
-- con el precio promedio de los productos que ha vendido.
SELECT e.nombre "Nombre del Empleado", AVG(p.precio) "Precio Promedio de
Productos Vendidos"
FROM empleados e, ventas v, productos p
WHERE e.id = v.empleado_id AND v.producto_id = p.id
GROUP BY e.nombre;
-- Encontrar el departamento con el salario mínimo más bajo entre los empleados y mostrar el nombre del departamento junto
--  con el salario mínimo más bajo.
SELECT d.nombre "Nombre del Departamento", MIN(e.salario) "Salario Mínimo"
FROM departamentos d, empleados e
WHERE d.id = e.departamento_id
GROUP BY d.nombre;
-- Encuentra el departamento con el salario promedio más alto entre los empleados mayores de 30 años y muestra el nombre del
--  departamento junto con el salario promedio. Limita los resultados a mostrar solo los departamentos con el salario promedio mayor a 3320.
SELECT d.nombre "Nombre departamento", AVG(e.salario) "Salario promedio"
FROM empleados e, departamentos d
WHERE e.departamento_id = d.id AND e.edad > 30
GROUP BY d.nombre HAVING AVG(e.salario) > 3320;