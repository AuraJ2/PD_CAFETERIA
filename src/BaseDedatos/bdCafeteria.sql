CREATE DATABASE IF NOT EXISTS bdcafeteria;
USE `bdcafeteria`;

CREATE TABLE IF NOT EXISTS gastos ( idGastos INT PRIMARY KEY auto_increment, Fechagastos date DEFAULT NULL, Totalgastos int(100)  DEFAULT NULL);
CREATE TABLE IF NOT EXISTS ventas( idventas INT PRIMARY KEY auto_increment, producto varchar(100) DEFAULT NULL, precio int(100)  DEFAULT NULL);
CREATE TABLE IF NOT EXISTS tbLogin( idLogin INT PRIMARY KEY auto_increment, usuario varchar(100) DEFAULT NULL, contraseña varchar(100) DEFAULT NULL);
CREATE TABLE IF NOT EXISTS bdcafeteria.tbGanancias(idGanancia INT PRIMARY KEY AUTO_INCREMENT, fechaganacia date DEFAULT NULL, GananciaTotal int(100)   DEFAULT NULL);
CREATE TABLE IF NOT EXISTS tbPagoTarjeta(idTarjeta INT PRIMARY KEY AUTO_INCREMENT,NumTarjeta int(100)default null, FechaVencimiento date default null,ClaveSeguridad int(100) default null);
