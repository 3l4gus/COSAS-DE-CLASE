CREATE database empresa;

use empresa;

CREATE table departamento(
    id_departamento int primary key auto_increment,
    nombre_departamento varchar(25) not null
    );

CREATE table empleado (
    id_empleado int primary key auto_increment,
    nombre varchar(20) not null,
    apellido1 varchar (20) not null,
    apellido2 varchar(20),
    Salario DECIMAL (10,2),
    edad INT,
    id_departamento int,
    FOREIGN KEY (id_departamento) REFERENCES departamento (id_departamento)
);

ALTER TABLE empleado add COLUMN fecha_na DATE default '1990-01-01';

insert into departamento (nombre_departamento) VALUES
('informatica'),
('Marketing'),
('Ventas'),
('Recursos humanos'),
('Administracion');
-- inserta datos tabla empleados
insert into empleado(nombre,apellido1,apellido2,salario,edad,id_departamento) VALUES
('Alejandro','Salgado','Oliveira',1200,20,1),
('Victor','Mosquera','Puchades',2000,25,5),
('kim','Arias','Labrea',1500,21,4),
('Daniel','Chen','',5500,23,1),
('Lili','Ortega','Arteaga',3500,25,2),
('kim','Arias','Labrea',2500,21,1);

-------------------------------------------------------------

USE empresa;

select * from empleado;

-- Reducir el salario del empleado con identificador 5 hasta 2,300

UPDATE empleado
SET salario = 2300
WHERE id_empleado = 5;

-- el empleado con identificador 4 pasa a trabajar en el departamento cuyo identificador es 3

UPDATE empleado
SET id_departamento = 3
where id_empleado = 4;

-- Filtrar empleados con un sueldo igual o mayor a 3000

select * from empleado where salario >= 3000;
-- Busca empleados cuyo primer apellido sea ortega
select * from empleado where apellido1 = 'Ortega';
-- cuando el salario esta entre 4000 y 6000
SELECT * FROM empleado WHERE salario >= 4000 and Salario <= 6000;
-- Busca los empleados q nacieron despues de 1 de enero de 1995 
SELECT * from  empleado WHERE fecha_na > '1985-01-01';
-- empleados cuyo nombre empieza por A
select * from empleado where nombre like 'A%';
-- añadimos los campos t_movil
alter table empleado add column t_movil varchar(20) ,add column t_fijo varchar (15) not null default '981 000 000';
-- filtrar empleados cullo primer apellido no sea ortega
select * from empleado where apellido1 not like 'Ortega';
-- seleccionar empleados que tienen un sueldo mayor a 7000 y que nacieron despues del 1 de enero de 1985
select * from empleado where salario > 7000 and fecha_na > '1985-01-01';
-- seleccionar todos los empleados que tienen un sueldo superior a 5000 o cuyo apellido es 'Ortega'
select*from empleado where salario > 5000 or apellido1 like 'Ortega';
-- seleccionar los empleados cuyo nombre comienza con "M" o cuyo primer apellido comienza con "S"
select*from empleado where nombre like 'M%' or apellido1 like 'S%';
-- ordenar empleados por primer apellido en orden ascendente (orden alfabetico)
select*from empleado order by apellido1;
-- ordenar empleados por sueldo en orden descendente
select*from empleado order by salario desc;
-- ordenar empleados por la diferencia entre sueldo y un valor fijo (por ejemplo, 3000) de manera descendente
select nombre, (salario - 4000) as diferencia from empleado 
order by diferencia desc;
-- ordenar empleados por apellido usando su posicion (2) en la lista de seleccion
select*from empleado
order by 2;
-- ordenar emplados por sueldo de mayor a menor usando su posicion (3) en la lista de seleccion
select nombre, apellido1, salario from empleado order by 3 desc;
-- calcular el promedio de sueldos de los empleados de cada departamento
select avg(salario) as promedio, id_departamento from empleado group by id_departamento;
-- contar el numero de empleados de cada departamento y ordenarlas por numero de empleados
select id_departamento, count(nombre) as numEmpleados from empleado 
group by id_departamento
order by count(id_departamento) desc;
-- calcular sueldo anual de cada empleado
select nombre, (salario * 12) as salarioAnual from empleado;
-- calcular la suma de los sueldos en toda la empresa
select sum(salario) as salarioTotal from empleado;
-- calcular un aumento de sueldo del 10% para cada empleado
select nombre, salario, (salario * 1.1) as aumentoSueldo from empleado;
-- muestrame los departamentos con salario promedio superior a 2000
select*from empleado;
select*from departamento;
-- -------
select d.nombre_departamento, avg(e.salario) as media
from empleado e, departamento d 
where e.id_departamento = d.id_departamento
group by e.id_departamento having media > 2000;
-- ---------RECOMENDADO USAR JOIN ON
select d.nombre_departamento, avg(e.salario) as media
from empleado e join departamento d 
on e.id_departamento = d.id_departamento
group by e.id_departamento having media > 2000;
-- --------
select d.nombre_departamento, avg(e.salario) as media
from empleado e natural join departamento d 
group by e.id_departamento having media > 2000;
-- concatenar el nombre y apellido para obtener el nombre completo
select concat(nombre,' ',apellido1) as nombreCompleto from empleado;
-- selecciona los nombres y apellidos de los empleados cuyo id es el 1, 3, 5 o 7
select id_empleado, nombre, apellido1, apellido2 from empleado where id_empleado in (1, 3, 5, 7);
-- selecciona los nombres y apellidos de los empleados cuyda edad es diferente de 30
select nombre, apellido1, apellido2 from empleado where edad not like 30; -- != <>
-- selecciona los empleados cuyo nombre completo (nombre y apellido concatenado con un espacio)
-- coincide exactamente con "Victor Mosquera"
select * from empleado where concat(nombre,' ',apellido1) like 'Victor Mosquera';

insert into departamento (nombre_departamento) values ('Mantenimiento');

-- muestra todos los departamentos que no tengan empleados
select d.nombre_departamento from departamento d left join empleado e
on d.id_departamento = e.id_departamento
where nombre is null; 