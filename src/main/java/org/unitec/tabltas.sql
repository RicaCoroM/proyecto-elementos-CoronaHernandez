/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  campitos
 * Created: Oct 7, 2016
 */
create table departamento(id integer primary key auto_increment, 
nombre varchar(30));



create table empleado(id integer primary key auto_increment,
id_depto integer, nombre varchar(40), sueldo float,
foreign key(id_depto) references departamento(id));

select * from departamento;
select * from empleado;

