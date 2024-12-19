use mi_bd;

-- CREATE TABLE empleados (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     nombre VARCHAR(50),
--     apellido VARCHAR(50),
--     edad INT,
--     salario DECIMAL(10, 2),
--     fecha_contratacion DATE
-- );

--si no te deja cambiar el null, dropea la tabla y volve a crearla
--con edad en null
ALTER TABLE empleados MODIFY COLUMN edad INT NOT NULL;
-- Este comando te da una descripcion de los tipos de las variables;

DESCRIBE empleados;

-- DROP TABLE IF EXISTS empleados;

CREATE TABLE empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    edad INT NOT NULL,
    salario DECIMAL(10, 2),
    fecha_contratacion DATE
);

ALTER TABLE empleados MODIFY COLUMN salario INT DEFAULT 0;

ALTER TABLE empleados ADD COLUMN departamento VARCHAR(50);
ALTER TABLE empleados ADD COLUMN correo_electronico VARCHAR(100);

ALTER TABLE empleados DROP COLUMN fecha_contratacion;

ALTER TABLE empleados ADD COLUMN fecha_contratacion DATE DEFAULT (CURRENT_DATE);

CREATE TABLE departamentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
);

ALTER TABLE empleados ADD COLUMN departamento_id INT;
ALTER TABLE empleados ADD FOREIGN KEY (departamento_id) REFERENCES departamentos(id);

ALTER TABLE empleados DROP COLUMN departamento;




