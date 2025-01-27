drop database examen;
create database examen;
use examen;

create table cliente(
id int(10) auto_increment primary key,
nombre varchar(100) not null,
apellido1 varchar(100) not null,
apellido2 varchar(100) not null,
nif varchar(100) not null,
email varchar(100) not null,
movil int(10) not null,
fecha_nacimiento date not null,
nacionalidad varchar(100) not null 
);

create table viaje(
id int(10) auto_increment primary key,
id_cliente int(10) not null,
fecha_salida date not null,
fecha_llegada date not null,
foreign key (id_cliente) references cliente(id)
);

create table lugar( 
id int(10) auto_increment primary key,
nombre varchar(100) not null,
pais varchar(100) not null, 
coste_dia_promedio int(10)
); 

create table hotel(
id int(10) auto_increment primary key,
id_lugar int(10) not null,
nombre varchar(100) not null,
cadena varchar(100),
estrellas varchar(100),
hora_entrada time not null,
hora_salida time not null,
foreign key (id_lugar) references lugar(id)
);

create table estancia(
id int(10) auto_increment primary key,
id_hotel int(10) not null,
id_viaje int(10) not null,
fecha_llegada date not null,
fecha_salida date not null,
coste int(10) not null,
foreign key (id_hotel) references hotel(id),
foreign key (id_viaje) references viaje(id)
);

create table medio_transporte(
id int(10) auto_increment primary key,
tipo varchar(100) not null,
company varchar(100) not null
);

create table transporte(
id int(10) auto_increment primary key,
id_origen int(10) not null,
id_destino int(10) not null,
id_medio_trasporte int(10) not null,
id_viaje int(10) not null,
coste int(10) not null,
fecha_salida datetime not null,
fecha_llegada datetime not null,
lugar_salida varchar(100) not null,
lugar_llegada varchar(100) not null,
foreign key (id_origen) references lugar(id),
foreign key (id_destino) references lugar(id),
foreign key (id_medio_trasporte) references medio_transporte(id),
foreign key (id_viaje) references viaje(id)
);

insert into cliente(nombre,apellido1,apellido2,nif,email,movil,fecha_nacimiento,nacionalidad) values
("ivan","ponti","rubio",12,"ipr@gmail.com","123","2020-12-9","español");

insert into viaje(id_cliente,fecha_salida,fecha_llegada) values
(1,"2020-12-29","2020-12-9");

insert into lugar(nombre,pais,coste_dia_promedio) values
("hundria","hungria","40");

insert into hotel(id_lugar,nombre,hora_entrada,hora_salida) values
(1,"hunrria","12","13");

insert into estancia(id_hotel,id_viaje,fecha_llegada,fecha_salida,coste) values
(1,1,"2020-12-29","2020-12-9",30);

insert into medio_transporte(tipo,company) values
("12","si");

insert into transporte(id_origen,id_destino,id_medio_trasporte,id_viaje,fecha_salida,fecha_llegada,lugar_salida,lugar_llegada,coste) values
(1,1,1,1,"2020-12-29","2020-12-9","hungria","españa",30);

create index indice_nif_cilente on cliente(nif);

/*drop table cliente;
alter table viaje 
drop column id_cliente
;