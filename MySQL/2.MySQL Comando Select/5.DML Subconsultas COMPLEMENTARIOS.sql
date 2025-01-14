use mi_bd;

--  Inserta una venta en la tabla "ventas" donde el cliente "Juan Pérez" compra una "Laptop" con una cantidad de 2 
-- y el vendedor tiene el nombre "Ana" y apellido "Rodríguez".
SELECT * FROM clientes WHERE nombre = "Juan Pérez";
SELECT * FROM productos WHERE nombre = "Laptop";
SELECT * FROM empleados WHERE nombre = "Ana" AND apellido = "Rodriguez";
INSERT INTO ventas (cliente_id, producto_id, cantidad, empleado_id) 
    VALUES (1, 1, 2, 1);

-- Inserta una venta en la tabla "ventas" donde el cliente "María García" compra un "Teléfono móvil" con una cantidad
--  de 3 y el vendedor tiene el nombre "Carlos" y apellido "López".
INSERT INTO ventas (cliente_id, producto_id, cantidad, precio_unitario, empleado_id) 
    VALUES ((SELECT id FROM clientes WHERE nombre = "María García" LIMIT 1),
            (SELECT id FROM productos WHERE nombre = "Teléfono móvil" LIMIT 1),
            3,
            (SELECT precio FROM productos WHERE nombre = "Teléfono móvil" LIMIT 1),
            (SELECT id FROM empleados WHERE nombre = "Carlos" AND apellido = "López" LIMIT 1));

-- Crea una venta en la tabla "ventas" donde el cliente "Carlos Sánchez" compra una "Impresora" con una cantidad de 1
--  y el vendedor tiene el nombre "Marta" y apellido "Ramírez".

INSERT INTO ventas (cliente_id, producto_id, cantidad, precio_unitario, empleado_id) 
    VALUES ((SELECT id FROM clientes WHERE nombre = "Carlos Sánchez" LIMIT 1),
            (SELECT id FROM productos WHERE nombre = "Impresora" LIMIT 1),
            1,
            (SELECT precio FROM productos WHERE nombre = "Impresora" LIMIT 1),
            (SELECT id FROM empleados WHERE nombre = "Marta" AND apellido = "Ramírez" LIMIT 1));

-- Inserta una venta en la tabla "ventas" donde el cliente "Ana López" compra una "Laptop" con una cantidad de 1 y el
--  vendedor tiene el nombre "Carlos" y apellido "López".
INSERT INTO ventas (cliente_id, producto_id, cantidad, precio_unitario, empleado_id) 
    VALUES ((SELECT id FROM clientes WHERE nombre = "Ana López" LIMIT 1),
            (SELECT id FROM productos WHERE nombre = "Laptop" LIMIT 1),
            1,
            (SELECT precio FROM productos WHERE nombre = "Laptop" LIMIT 1),
            (SELECT id FROM empleados WHERE nombre = "Carlos" AND apellido = "López" LIMIT 1));

-- Crea una venta en la tabla "ventas" donde el cliente "Juan Pérez" compra una "Tablet" con una cantidad de 2 y el 
-- vendedor tiene el nombre "Luis" y apellido "Fernández".
INSERT INTO ventas (cliente_id, producto_id, cantidad, precio_unitario, empleado_id) 
    VALUES ((SELECT id FROM clientes WHERE nombre = "Juan Pérez" LIMIT 1),
            (SELECT id FROM productos WHERE nombre = "Tablet" LIMIT 1),
            2,
            (SELECT precio FROM productos WHERE nombre = "Tablet" LIMIT 1),
            (SELECT id FROM empleados WHERE nombre = "Luis" AND apellido = "Fernández" LIMIT 1));

-- Inserta una venta en la tabla "ventas" donde el cliente "María García" compra un "Teléfono móvil" con una cantidad
--  de 1 y el vendedor tiene el nombre "Marta" y apellido "Ramírez".
INSERT INTO ventas (cliente_id, producto_id, cantidad, precio_unitario, empleado_id) 
    VALUES ((SELECT id FROM clientes WHERE nombre = "María García" LIMIT 1),
            (SELECT id FROM productos WHERE nombre = "Teléfono móvil" LIMIT 1),
            1,
            (SELECT precio FROM productos WHERE nombre = "Teléfono móvil" LIMIT 1),
            (SELECT id FROM empleados WHERE nombre = "Marta" AND apellido = "Ramírez" LIMIT 1));

-- Crea una venta en la tabla "ventas" donde el cliente "Carlos Sánchez" compra una "Impresora" con una cantidad de 2
--  y el vendedor tiene el nombre "Lorena" y apellido "Guzmán".
INSERT INTO ventas (cliente_id, producto_id, cantidad, precio_unitario, empleado_id) 
    VALUES ((SELECT id FROM clientes WHERE nombre = "Carlos Sánchez" LIMIT 1),
            (SELECT id FROM productos WHERE nombre = "Impresora" LIMIT 1),
            2,
            (SELECT precio FROM productos WHERE nombre = "Impresora" LIMIT 1),
            (SELECT id FROM empleados WHERE nombre = "Lorena" AND apellido = "Guzmán" LIMIT 1));

