CREATE DATABASE javaDemoDB;
USE javaDemoDB;

CREATE TABLE Employees
(
	id int auto_increment primary key,
    Name varchar(60),
    Salary decimal,
    Region varchar(30)
);

SELECT * FROM Employees;

USE classfiles;
SELECT firstname, lastname, title
FROM person p JOIN employee e
ON p.id = e.id
WHERE city = 'Denver';

show tables
select * from person

select * from employee

use contactsdb;
show tables

select * from contact

select * from contact where first_name like 'Andrew';
select * from country

insert into contact
 values
 
 SELECT country.country_id  from country where country.name like 'wales';
 
 
 SELECT country.country_id  from country where country.name like parcountry into parcountryid;
	INSERT into contact (first_name, last_name, phone, email, country_id)
    VALUES (parfirstname, parlastname, parphone, paremail, (SELECT country.country_id  from country where country.name like "England"));
    
    
    
    
    select * from contact
    
select first_name, last_name, phone, email, name from contact c join country co ON c.country_id = co.country_id where name = 'Wales';

CREATE PROCEDURE `contactsInCountry` ()
BEGIN
	select first_name, last_name, phone, email, name 
    from contact c join country co 
    ON c.country_id = co.country_id 
    where name = '';
END
