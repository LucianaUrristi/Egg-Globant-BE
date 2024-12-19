use mi_bd;

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    direccion VARCHAR(100)
);

CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    precio FLOAT(10,2)
);

CREATE TABLE ventas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    producto_id INT,
    cliente_id INT,
    cantidad INT,
    precio_unitario FLOAT(10,2),
    monto_total FLOAT(10,2),
    empleado_id INT
);

ALTER TABLE ventas ADD FOREIGN KEY (empleado_id)
REFERENCES empleados(id);

INSERT INTO clientes (nombre, direccion) VALUES ('Juan Pérez', 'Libertad 3215, Mar del Plata');
INSERT INTO productos (nombre, precio) VALUES ('Laptop', 1200.00);

SELECT * FROM clientes;
SELECT * FROM ventas;
SELECT * FROM productos;

ALTER TABLE ventas modify monto_total DECIMAL(10,2) 
    GENERATED ALWAYS AS (cantidad * precio_unitario) STORED;

INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
    VALUES (1,1,2,1200.00,1);

