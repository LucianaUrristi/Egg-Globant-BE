use mi_bd;


-- Ejercicios Función MAX() 
-- Encuentra el salario máximo de todos los empleados.
SELECT MAX(salario) FROM empleados;
-- Encuentra la cantidad máxima de productos vendidos en una sola venta.
SELECT MAX(cantidad) FROM ventas;
-- Encuentra la edad máxima de los empleados.
SELECT MAX(edad) FROM empleados;


-- Ejercicios Función MIN()
-- Encuentra el salario mínimo de todos los empleados.
SELECT MIN(salario) FROM empleados;
-- Encuentra la cantidad mínima de productos vendidos en una sola venta.
SELECT MIN(cantidad) FROM ventas;
-- Encuentra la edad mínima de los empleados.
SELECT MIN(edad) FROM empleados;


-- Ejercicios de la Función COUNT()
-- Cuenta cuántos empleados hay en total.
SELECT COUNT(*) FROM empleados;
-- Cuenta cuántas ventas se han realizado.
SELECT COUNT(*) FROM ventas;
-- Cuenta cuántos productos tienen un precio superior a $500.
SELECT COUNT(*) FROM productos WHERE precio > 500.00;


-- Ejercicios de la Función SUM()
-- Calcula la suma total de salarios de todos los empleados.
SELECT SUM(salario) FROM empleados;
-- Calcula la suma total de montos vendidos en todas las ventas.
SELECT SUM(monto_total) FROM ventas;
-- Calcula la suma de precios de productos con ID par.
SELECT SUM(precio) FROM productos WHERE id % 2 = 0;


-- Ejercicios Función AVG()
-- Calcula el salario promedio de todos los empleados.
SELECT AVG(salario) FROM empleados;
-- Calcula el precio unitario promedio de todos los productos.
SELECT AVG(precio) FROM productos;
-- Calcula la edad promedio de los empleados.
SELECT AVG(edad) FROM empleados;


-- Ejercicios GROUP BY()
-- Agrupa las ventas por empleado y muestra la cantidad total de ventas realizadas por cada empleado.
SELECT empleado_id, COUNT(*) FROM ventas GROUP BY empleado_id;
-- Agrupa los productos por precio y muestra la cantidad de productos con el mismo precio.
SELECT precio, COUNT(*) FROM productos GROUP BY precio;
-- Agrupa los empleados por departamento y muestra la cantidad de empleados en cada departamento.
SELECT departamento_id, COUNT(*) FROM empleados GROUP BY departamento_id;


-- Ejercicios HAVING 
-- Encuentra los departamentos con un salario promedio de sus empleados superior a $3,000.
SELECT departamento_id, AVG(salario) FROM empleados GROUP BY
departamento_id HAVING salario_promedio > 3000;
-- Encuentra los productos que se han vendido al menos 5 veces.
SELECT producto_id, COUNT(*) FROM ventas GROUP BY producto_id HAVING
COUNT(*) >= 5;
-- Selecciona los empleados que tengan una “o” en su nombre o apellido y agrúpalos por departamento y muestra los que tengan el salario máximo.
SELECT departamento_id, MAX(salario) FROM empleados WHERE nombre LIKE
"%o%" OR apellido LIKE "%o%" GROUP BY departamento_id HAVING MAX(salario)
= MAX(salario);