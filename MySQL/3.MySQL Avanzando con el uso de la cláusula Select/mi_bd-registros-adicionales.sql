INSERT INTO empleados (nombre, apellido, edad, salario, departamento_id)
VALUES ('Laura', 'Sánchez', 27, 3300.00, 1),
    ('Javier', 'Pérez', 29, 3100.00, 1),
    ('Camila', 'Gómez', 26, 3000.00, 1),
    ('Lucas', 'Fernández', 28, 3200.00, 1),
    ('Valentina', 'Rodríguez', 30, 3500.00, 1);

INSERT INTO productos (nombre, precio)
VALUES ('Cámara Digital', 420.00),
    ('Smart TV 55 Pulgadas', 1200.00),
    ('Auriculares Bluetooth', 80.00),
    ('Reproductor de Blu-ray', 120.00),
    ('Lavadora de Ropa', 550.00),
    ('Refrigeradora Doble Puerta', 800.00),
    ('Horno de Microondas', 120.00),
    ('Licuadora de Alta Potencia', 70.00),
    ('Silla de Oficina Ergonómica', 150.00),
    ('Escritorio de Madera', 200.00),
    ('Mesa de Comedor', 250.00),
    ('Sofá de Tres Plazas', 350.00),
    ('Mochila para Portátil', 30.00),
    ('Reloj de Pulsera Inteligente', 100.00),
    ('Juego de Utensilios de Cocina', 40.00),
    ('Set de Toallas de Baño', 20.00),
    ('Cama King Size', 500.00),
    ('Lámpara de Pie Moderna', 70.00),
    ('Cafetera de Goteo', 40.00),
    ('Robot Aspirador', 180.00);

INSERT INTO clientes (nombre, direccion)
VALUES (
        'Alejandro López',
        'Calle Rivadavia 123, Buenos Aires'
    ),
    (
        'Sofía Rodríguez',
        'Avenida San Martín 456, Rosario'
    ),
    ('Joaquín Pérez', 'Calle Belgrano 789, Córdoba'),
    ('Valeria Gómez', 'Calle Mitre 101, Mendoza'),
    (
        'Diego Martínez',
        'Avenida 9 de Julio 654, Buenos Aires'
    );

INSERT INTO ventas (
        producto_id,
        cliente_id,
        cantidad,
        precio_unitario,
        empleado_id
    )
VALUES (1, 6, 3, 1350.00, 1),
    (5, 8, 5, 420.00, 9),
    (10, 2, 2, 800.00, 6),
    (14, 7, 1, 200.00, 5),
    (20, 4, 4, 20.00, 6),
    (4, 5, 5, 280.00, 1),
    (9, 5, 3, 550.00, 1),
    (13, 3, 4, 150.00, 5),
    (19, 6, 2, 40.00, 1),
    (2, 9, 5, 480.00, 1);

INSERT INTO ventas (
        producto_id,
        cliente_id,
        cantidad,
        precio_unitario,
        empleado_id
    )
VALUES (3, 9, 1, 350.00, 1),
    (6, 7, 4, 1200.00, 1),
    (7, 6, 3, 80.00, 1),
    (12, 9, 5, 70.00, 1),
    (16, 8, 2, 350.00, 6),
    (23, 9, 4, 180.00, 1),
    (18, 4, 3, 100.00, 7),
    (11, 3, 2, 120.00, 5),
    (15, 5, 4, 250.00, 6),
    (8, 8, 1, 120.00, 7);

INSERT INTO ventas (
        producto_id,
        cliente_id,
        cantidad,
        precio_unitario,
        empleado_id
    )
VALUES (17, 3, 2, 30.00, 5),
    (21, 9, 5, 500.00, 6),
    (22, 2, 3, 70.00, 6),
    (24, 9, 2, 180.00, 1),
    (5, 1, 2, 1350.00, 1),
    (9, 6, 4, 550.00, 9),
    (13, 8, 3, 150.00, 7),
    (3, 1, 5, 350.00, 1),
    (18, 9, 1, 100.00, 6),
    (10, 5, 2, 800.00, 1);

INSERT INTO ventas (
        producto_id,
        cliente_id,
        cantidad,
        precio_unitario,
        empleado_id
    )
VALUES (7, 4, 3, 80.00, 6),
    (2, 5, 1, 480.00, 6),
    (8, 7, 4, 120.00, 7),
    (1, 3, 5, 1350.00, 5),
    (4, 6, 2, 280.00, 5),
    (12, 1, 1, 70.00, 1),
    (19, 4, 3, 40.00, 6),
    (15, 3, 4, 250.00, 5),
    (6, 8, 2, 1200.00, 7),
    (11, 2, 3, 120.00, 5);