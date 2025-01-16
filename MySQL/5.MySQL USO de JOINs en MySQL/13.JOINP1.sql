use mi_bd;
-- Encuentra el nombre y apellido de los empleados junto con la cantidad total de ventas que han realizado.
SELECT e.nombre, e.apellido, SUM(v.cantidad) as "Cantidad Total de Ventas"
FROM empleados e
INNER JOIN ventas v
ON e.id = v.empleado_id
GROUP BY e.nombre, e.apellido;
-- Calcula el monto total vendido a cada cliente y muestra el nombre del cliente, su dirección y el monto total.
SELECT c.nombre, c.direccion , SUM(v.monto_total) as "Monto Total"
FROM clientes c
LEFT JOIN ventas v
ON c.id = v.cliente_id
GROUP BY c.nombre, c.direccion;
-- Encuentra los productos vendidos por cada empleado en el departamento de "Ventas" y muestra el nombre del empleado junto con el nombre de los productos que han vendido.
SELECT e.nombre empleado, p.nombre producto
FROM empleados e
INNER JOIN ventas v
ON e.id = v.empleado_id
INNER JOIN productos p
ON v.producto_id = p.id
INNER JOIN departamentos d
ON e.departamento_id = d.id WHERE d.nombre = "Ventas";
-- Encuentra el nombre del cliente, el nombre del producto y la cantidad comprada de productos con un precio superior a $500.
SELECT c.nombre Cliente, p.nombre Producto, SUM(v.cantidad) "Cantidad
Comprada"
FROM clientes c
INNER JOIN ventas v
ON c.id = v.cliente_id
INNER JOIN productos p
ON v.producto_id = p.id WHERE p.precio > 500
GROUP BY p.nombre, c.nombre;