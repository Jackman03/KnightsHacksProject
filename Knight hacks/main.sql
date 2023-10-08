create database sports_cars;

drop table if EXISTS cars;
create table cars(
	ID int not NULL auto_increment,
	make varchar(30),
	model varchar(30),
	color varchar(30),
	makeyear int,
	cost int,
	miles int,
	transmission varchar(30),
	engine varchar(4),

	primary key(ID)


);

insert into cars(make,model,color,makeyear,cost,miles,transmission,engine) values
('Ford','Mustang','Black',2006,12000,75000,'Automatic','V8'),
('Madza','Miata','Red',1994,25000,1000,'Manual','i4'),
('BMW','M5','Jet Black',2020,90000,2000,'Automatic','V10'),
('Chevrolet', 'Corvette','Orange',2015,35000,50000,'Manual','V8'),
('Chevrolet', 'Corvette','Black',2019,75000,40000,'Manual','V8'),
('Porsche','911','Cherry Red',2023,100000,50,'Manual','F6'),
('Porsche','911','White',2022,100000,100,'Manual','F6'),
('Porsche','911','Cherry Red',2023,100000,75,'Manual','F6'),
('BMW','M5','Blue',2022,92000,15000,'Automatic','V10');

insert into cars(make,model,color,makeyear,cost,miles,transmission,engine) values
('Ford','Mustang','Light Blue',2014,25000,20000,'Manual','V8'),
('Ford','Mustang','White',2023,40000,0,'Automatic','V8'),
('Audi','TT','Yellow',2023,50000,3000,'Automatic','i4'),
('Audi','TT','Orange',2023,50000,3000,'Automatic','i4'),
('Ford','Mustang','Green',2020,38000,1500,'Automatic','V8');



insert into cars(make,model,color,makeyear,cost,miles,transmission,engine) values
('Audi','R8','Orange',2019,130000,10000,'Automatic','V8'),
('Audi','R8','Black',2023,150000,40,'Automatic','V8'),
('Audi','R8','Red',2023,150000,3000,'Automatic','V8');


insert into cars(make,model,color,makeyear,cost,miles,transmission,engine) values
('Chevrolet','Camaro','Red',2011,15000,150000,'Automatic','V8'),
('Chevrolet','Camaro','White',2024,100000,0,'Manual','V8'),
('Chevrolet','Camaro','Gray',1997,2500,200000,'Manual','V8');


insert into cars(make,model,color,makeyear,cost,miles,transmission,engine) values
('Toyota','Supra','Jet Black',2020,55000,5000,'Manual','i6');

insert into cars(make,model,color,makeyear,cost,miles,transmission,engine) values
('Toyota','Supra','Jet Black',2020,55000,5000,'Manual','i6'),
('Toyota','Supra','Gray',2024,55000,0,'Manual','i6'),
('Toyota','Supra','Orange',2024,55000,0,'Manual','i6'),
('Toyota','Supra','Red',2024,55000,0,'Manual','i6'),
('Toyota','Supra','Blue',2024,55000,0,'Manual','i6');


insert into cars(make,model,color,makeyear,cost,miles,transmission,engine) values
('Ford','Mustang','Black',2001,35000,2000,'Automatic','V8'),
('Madza','Miata','Red',2004,20000,50000,'Manual','i4'),
('BMW','M5','Green',2024,90000,0,'Automatic','V10'),
('Chevrolet', 'Corvette','Orange',2015,35000,50000,'Manual','V8'),
('Chevrolet', 'Corvette','Black',2019,75000,40000,'Manual','V8'),
('Porsche','911','Jet Black',2023,100000,50,'Manual','F6'),
('Porsche','911','White',2022,100000,100,'Manual','F6'),
('Porsche','911','Cherry Red',2023,100000,75,'Manual','F6'),
('BMW','M5','Blue',2022,92000,15000,'Automatic','V10');


insert into cars(make,model,color,makeyear,cost,miles,transmission,engine) values
('Ford','GT','Black',1995,75000,5000,'Automatic','V8'),
('Madza','Miata','Red',1994,25000,1000,'Manual','i4'),
('Porsche','911','Sky Blue',2023,100000,75,'Manual','F6'),
('BMW','M5','Blue',2022,92000,15000,'Automatic','V10');



insert into cars(make,model,color,makeyear,cost,miles,transmission,engine) values
('Ford','Mustang','Black',2006,12000,75000,'Automatic','V8'),
('Madza','Miata','Red',1994,25000,1000,'Manual','i4'),
('BMW','M5','Jet Black',2020,90000,2000,'Automatic','V10'),
('Chevrolet', 'Corvette','Orange',2015,35000,50000,'Manual','V8'),
('Chevrolet', 'Corvette','Black',2019,75000,40000,'Manual','V8'),
('Porsche','911','Cherry Red',2023,100000,50,'Manual','F6'),
('Porsche','911','White',2022,100000,100,'Manual','F6'),
('Porsche','911','Cherry Red',2023,100000,75,'Manual','F6'),
('BMW','M5','Blue',2022,92000,15000,'Automatic','V10');