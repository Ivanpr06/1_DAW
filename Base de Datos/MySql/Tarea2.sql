drop database escuderias;
create database escuderias;



use escuderias;



create table escuderias.escuderia(

	id int(10) auto_increment primary key,

	nombre varchar(100) not null,

	fecha_fundacion date

);



create table escuderias.piloto(

	id int(10) auto_increment primary key,

	nombre varchar(100) not null,

	apellidos varchar(100) not null,

	dni varchar(9) not null,

	fecha_fundacion date

);



create table escuderias.gran_premio(

	id int(10) auto_increment primary key,

	fecha_fundacion date,

	ubicacion varchar(255)

);



create table escuderias.coche(

	id int(10) auto_increment primary key,

	modelo varchar(255),

	motor varchar(255),

	id_escuderia int(10)

);



create table escuderias.clasificacion(

	id_gran_premio int(10),

	id_piloto int(10),

	posicion int(2),

	puntos int(2),

	foreign key (id_gran_premio) references escuderias.gran_premio(id),

	foreign key (id_piloto) references escuderias.piloto(id)	

);



create table escuderias.contrato(

	id_piloto int(10),

	id_escuderia int(10),

	id_coche int(10),

	temporada int(4),

	salario double,

	foreign key (id_piloto) references escuderias.piloto(id),

	foreign key (id_escuderia) references escuderias.escuderia(id),

	foreign key (id_coche) references escuderias.coche(id)

);