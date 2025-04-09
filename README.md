# T1
# BASE DE DATOS

CREATE DATABASE bd_linares;
USE bd_linares;

CREATE TABLE puesto (
    cod_puesto BIGINT PRIMARY KEY AUTO_INCREMENT, 
    nombre_puesto VARCHAR(100) NOT NULL,
    salario_base DECIMAL(10, 2) NOT NULL
);

CREATE TABLE empleados (
    cod_empleado BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    fecha_ingreso DATE NOT NULL,
    cod_puesto BIGINT, 
    FOREIGN KEY (cod_puesto) REFERENCES puesto(cod_puesto)
);

INSERT INTO puesto (nombre_puesto, salario_base) VALUES 
('Desarrollador', 3000.00),
('Gerente', 5000.00),
('Diseñador', 2500.00);

INSERT INTO empleados (nombre, fecha_ingreso, cod_puesto) VALUES 
('Piero Linares', '2025-04-08', 1),
('Ana Perez', '2025-04-10', 2);  

select * from puesto;
select * from empleados;

SELECT e.cod_empleado, e.nombre, e.fecha_ingreso, p.nombre_puesto, p.salario_base
FROM empleados e
JOIN puesto p ON e.cod_puesto = p.cod_puesto;
