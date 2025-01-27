drop database autobuses;

create database autobuses;

use autobuses;



CREATE TABLE autobuses.parada(

    id INT(10) AUTO_INCREMENT PRIMARY KEY,

    ubicacion VARCHAR(150) NOT NULL,

    codigo VARCHAR(150) NOT NULL

   );



CREATE TABLE autobuses.ciudad(

    id INT(10) AUTO_INCREMENT PRIMARY KEY,

    nombre VARCHAR(150) NOT NULL,

    comunidad VARCHAR(150) NOT null,

    codigo_postal INT(1)

);



CREATE TABLE autobuses.linea(

	id INT(10) auto_increment primary key,

    nombre VARCHAR(150) NOT NULL,

    id_ciudad INT(10),

	FOREIGN KEY (id_ciudad) REFERENCES autobuses.ciudad(id)

);



CREATE TABLE autobuses.autobus(

	id INT(10) auto_increment primary key,

	codigo VARCHAR(150) NOT NULL,

    nombre VARCHAR(150) NOT NULL,

    tipo INT(1),

    id_linea INT(10),

	FOREIGN KEY (id_linea) REFERENCES autobuses.linea(id) 

);





CREATE TABLE autobuses.itinerario(

	id_parada INT(10),

	id_autobus INT(10),

	orden INT(10),

 	primary key(id_parada, id_autobus),

 	FOREIGN KEY (id_parada) REFERENCES autobuses.parada(id),

 	FOREIGN KEY (id_autobus) REFERENCES autobuses.autobus(id)

);



CREATE TABLE autobuses.conductor(

    id INT(10) AUTO_INCREMENT PRIMARY KEY,

    nombre VARCHAR(150) NOT NULL,

    comunidad VARCHAR(150) NOT null,

    codigo_carnet VARCHAR(150) NOT null,

    fecha_nacimiento DATE

);



CREATE TABLE autobuses.autobus_conductor(

	id_autobus INT(10),

	id_conductor INT(10),

 	primary key(id_conductor, id_autobus),

 	FOREIGN KEY (id_autobus) REFERENCES autobuses.autobus(id),

 	FOREIGN KEY (id_conductor) REFERENCES autobuses.conductor(id)

 );