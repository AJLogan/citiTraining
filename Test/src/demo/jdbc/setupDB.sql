CREATE DATABASE javaDemoDB;
USE javaDemoDB;

CREATE TABLE Employees
(
	id int auto_increment primary key,
    Name varchar(60),
    Salary decimal,
    Region varchar(30)
);