use mi_bd;

INSERT INTO empleados (nombre, apellido, edad, salario) VALUES ('Juan', 'Pérez', 30, 2500.50);

UPDATE empleados SET salario = 2700.00 WHERE nombre = 'Juan';
SELECT * FROM empleados;
DELETE FROM empleados WHERE nombre = 'Juan';

INSERT INTO departamentos (nombre) VALUES ('Ventas');
SELECT * FROM departamentos;
INSERT INTO departamentos (nombre) VALUES ('Recursos Humanos');

INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id) 
    VALUES ('Ana', 'Rodríguez', 28, 3000.00, 'anarodriguez@mail.com', 1);

INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id) 
    VALUES ('Carlos', 'López', 32, 3200.50, 'carloslopez@mail.com', 2),
            ('Laura', 'Pérez', 26, 2800.75, 'lauraperez@mail.com', 1), 
            ('Martín', 'González', 30, 3100.25, 'martingonzalez@mail.com', 2);

UPDATE empleados SET salario = salario + (salario*0.1) WHERE nombre = 'Ana';
INSERT INTO departamentos (nombre) VALUES ('Contabilidad');
UPDATE empleados SET departamento_id = 3 WHERE nombre = 'Carlos';
DELETE FROM empleados WHERE nombre = 'Laura';

UPDATE empleados SET id = 4 WHERE nombre = 'Martín';
SELECT * FROM empleados;

-- Para que la tabla empleados quede igual a la del material, cambiamos los ids

UPDATE empleados SET id = 1 WHERE nombre = 'Ana';
UPDATE empleados SET id = 2 WHERE nombre = 'Carlos';

SELECT * FROM empleados;
SELECT * FROM departamentos;
