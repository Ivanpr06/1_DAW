drop database ejercicio5;

create database ejercicio5;

use ejercicio5;

CREATE TABLE ejercicio5.Titulo(

    id INT(10) AUTO_INCREMENT PRIMARY KEY COMMENT 'PK de la tabla TITULO',

    nombre VARCHAR(50) NOT NULL COMMENT 'Nombre del titulo',

    genero VARCHAR(50) NOT NULL COMMENT 'Genero del titulo',

    idioma_original VARCHAR(50) NOT NULL COMMENT 'Idioma original del titulo'

) COMMENT='Tabla donde recoge todos los titulos';



CREATE TABLE ejercicio5.peliculas(

 id INT(10) auto_increment primary key COMMENT 'PK de la tabla peliculas',

 duracion time NOT null COMMENT 'Duración de la peliculas',

 FOREIGN KEY (id) REFERENCES ejercicio5.titulo(id) 

) COMMENT 'Tabla que recoge todas las peliculas';



CREATE TABLE ejercicio5.series(

 id INT(10) auto_increment primary key COMMENT 'PK de la tabla series',

 temporadas INT(10) NOT null COMMENT 'Numero de temporadas de la serie',

 FOREIGN KEY (id) references ejercicio5.titulo(id) 

) COMMENT 'Tabla que recoge todas las series';



CREATE TABLE ejercicio5.episodio(

 id INT(10) auto_increment primary key COMMENT 'PK de la tabla episodio',

 id_series int(10) not null COMMENT 'ID de la serie la cual pertenece el episodio',

 titulo varchar(50) not null COMMENT 'Titulo del episodio',

 duracion time not null COMMENT 'Duracion del episodio',

 numero int(100) not null COMMENT 'Numero del episodio',

 FOREIGN KEY (id_series) REFERENCES ejercicio5.series(id) 

) COMMENT 'Tabla que recoge los episodios de la tabla series';



create table ejercicio5.DoblajeTitulo(

	id_titulo int(10) comment 'FK a la tabla Titulo. Parte de la PK', 

	doblaje int(10) comment 'Parte de la PK.',

	foreign key (id_titulo) references ejercicio5.Titulo(id),

	primary key (id_titulo, doblaje)

)comment='Tabla que relaciona titulos con doblajes';



create table ejercicio5.RelacionTitulo(

	id_titulo int(10) comment 'FK a la tabla Titulo. Parte de la PK', 

	id_tituloRelacionado int(10) comment 'FK a la tabla Titulo. Parte de la PK.',

	foreign key (id_titulo) references ejercicio5.Titulo(id),

	foreign key (id_tituloRelacionado) references ejercicio5.Titulo(id),

	primary key (id_titulo, id_tituloRelacionado)

)comment='Tabla que relaciona titulos con doblajes';



CREATE TABLE ejercicio5.usuario(

 id INT(10) auto_increment PRIMARY key COMMENT 'PK de la tabla usuario',

 nombre VARCHAR(100) NOT null COMMENT 'Nombre de usuario'

)comment='Tabla que recoge todos los usuarios';



create table ejercicio5.ValoracionUsuarioTitulo(

	id_titulo int(10) comment 'FK a la tabla Titulo. Parte de la PK', 

	id_usuario int(10) comment 'FK a la tabla Titulo. Parte de la PK.',

	fecha date not null COMMENT 'fecha de la valoracion',

 	calificacion int(100) not null COMMENT 'calificaion del usuario',

 	foreign key (id_titulo) references ejercicio5.Titulo(id),

	foreign key (id_usuario) references ejercicio5.usuario(id),

	primary key (id_titulo, id_usuario)

)comment='Tabla que relaciona titulos con la valoracion de los usuarios';



create table ejercicio5.UsuarioFollowUsuario(

	id_usu_seguidor int(10) comment 'FK a la tabla Usuario. Parte de la PK', 

	id_usu_seguido int(10) comment 'FK a la tabla Usuario. Parte de la PK.',

	foreign key (id_usu_seguidor) references ejercicio5.usuario(id),

	foreign key (id_usu_seguido) references ejercicio5.usuario(id),

	primary key (id_usu_seguidor, id_usu_seguido)

)comment='Tabla que relaciona cuando un usario sigue a otro';



CREATE TABLE ejercicio5.ListaReproducion(

 id INT(10) auto_increment PRIMARY KEY COMMENT 'PK de la tabla listaReproduccion',

 id_usuario int(10) not null COMMENT 'ID del usuario',

 esPublica varchar(50) not null COMMENT 'Titulo del episodio',

 FOREIGN KEY (id_usuario) REFERENCES ejercicio5.usuario(id) 

) COMMENT 'Tabla que recoge la lista de repodruccion de un usuario';



create table ejercicio5.TituloEnLista(

	id_titulo int(10) comment 'FK a la tabla TituloEnLista. Parte de la PK', 

	id_lista int(10) comment 'FK a la tabla TituloEnLista. Parte de la PK.',

	foreign key (id_titulo) references ejercicio5.Titulo(id),

	foreign key (id_lista) references ejercicio5.ListaReproducion(id),

	primary key (id_titulo, id_lista)

)comment='Tabla que relaciona titulos con lista';



create table ejercicio5.VisualizacionListaUsuario(

	id_usuario int(10) comment 'FK a la tabla Usuario. Parte de la PK', 

	id_lista int(10) comment 'FK a la tabla Lista. Parte de la PK.',

	foreign key (id_usuario) references ejercicio5.usuario(id),

	foreign key (id_lista) references ejercicio5.ListaReproducion(id),

	primary key (id_usuario, id_lista)

);