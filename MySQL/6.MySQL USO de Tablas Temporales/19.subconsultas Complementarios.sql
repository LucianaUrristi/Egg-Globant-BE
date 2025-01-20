use mi_bd;

-- Encuentra los clientes que no han realizado ninguna compra. Muestra el nombre y la dirección de estos clientes.
SELECT c.nombre, c.direccion
FROM clientes c
LEFT JOIN ventas v
ON c.id = v.cliente_id
WHERE v.id IS NULL;

-- Muestra el nombre de los productos que se han vendido más veces que cualquier producto con un precio superior a 500.
SELECT p.nombre
FROM productos p
JOIN ventas v ON p.id = v.producto_id
GROUP BY p.id
HAVING COUNT(v.id) > (
    SELECT COUNT(v2.id)
    FROM productos p2
    JOIN ventas v2 ON p2.id = v2.producto_id
    WHERE p2.precio > 500
);

-- Encuentra los empleados cuya edad sea menor que la edad de al menos un empleado del departamento de "Recursos Humanos".
SELECT e.nombre, e.apellido
FROM empleados e
WHERE e.edad < (SELECT MIN(e2.edad)
                FROM empleados e2
                WHERE e2.departamento_id = (SELECT id FROM departamentos WHERE nombre = 'Recursos Humanos'));

-- Encuentra los productos cuyos precios sean menores o iguales a todos los precios de los productos con la palabra "Cámara" en su nombre.
SELECT nombre
FROM productos
WHERE precio <= ALL (
    SELECT precio
    FROM productos
    WHERE nombre LIKE '%Cámara%'
);

-- Muestra el nombre y el salario de los empleados con salarios superiores al promedio de salarios de todos los empleados.
SELECT nombre, salario
FROM empleados
WHERE salario > (SELECT AVG(salario) FROM empleados);

-- Encuentra el nombre y el salario de los empleados con salarios inferiores al promedio de salarios de todos los empleados del departamento de "Ventas".
SELECT nombre, salario
FROM empleados
WHERE departamento_id = (SELECT id FROM departamentos WHERE nombre = 'Ventas')
AND salario < (SELECT AVG(salario)
                FROM empleados
                WHERE departamento_id = (SELECT id FROM departamentos WHERE nombre = 'Ventas'));

-- Encuentra los clientes que han realizado compras de productos con un precio_unitario inferior al precio promedio de todos los productos.
SELECT c.nombre, c.direccion
FROM clientes c
JOIN ventas v ON c.id = v.cliente_id
JOIN productos p ON v.producto_id = p.id
WHERE v.precio_unitario < (SELECT AVG(p2.precio) FROM productos p2);


-- Encuentra los empleados que tienen un salario igual al salario de al menos un empleado del departamento de "Recursos Humanos".
SELECT nombre, salario
FROM empleados e
WHERE salario = ANY (
    SELECT salario
    FROM empleados
    WHERE departamento_id = (SELECT id FROM departamentos WHERE nombre = 'Recursos Humanos'));


-- Encuentra los productos cuyo precio es mayor o igual a todos los precios de los productos con la palabra "Refrigeradora" en su nombre.
SELECT nombre
FROM productos
WHERE precio >= ALL (
    SELECT precio
    FROM productos
    WHERE nombre LIKE '%Refrigeradora%'
);

-- Muestra el nombre, apellido y salario del empleado con el salario más alto que esté por debajo del promedio salarial de los empleados.
SELECT nombre, apellido, salario
FROM empleados
WHERE salario = (
    SELECT MAX(salario)
    FROM empleados
    WHERE salario < (SELECT AVG(salario) FROM empleados)
);

SELECT version();
SELECT 1
INTERSECT
SELECT 1;

SELECT 1
EXCEPT
SELECT 2;
