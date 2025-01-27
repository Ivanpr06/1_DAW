CREATE TABLE título ( 
id INT PRIMARY KEY,
nombre VARCHAR(50) NOT NULL,
genero varchar(50) not null,
idioma_original varchar(50) not null
);

CREATE TABLE usuario ( 
id INT PRIMARY KEY,
nombre varchar(50) NOT NULL
);

CREATE TABLE RelacionTitulo ( 
id_titulo INT,
id_tituloRelacionado int,
primary key (id_titulo, id_tituloRelacionado),
foreign key (id_titulo) references título(id),
foreign key (id_tituloRelacionado) references título(id)
);

CREATE TABLE serie ( 
id INT PRIMARY KEY,
temporadas int(10) not null,
foreign key (id) references título(id)
);

CREATE TABLE episodio ( 
id INT primary key,
id_series int,
titulo varchar(50) not null,
duracion int not null,
numero int not null,
foreign key (id_series) references serie(id)
);

CREATE TABLE doblajetitulo ( 
id_titulo INT,
doblaje int,
esPublica varchar(5) not null,
foreign key (id_titulo) references título(id)
);

CREATE TABLE pelicula ( 
id INT PRIMARY KEY,
duracion time NOT null,
foreign key (id) references título(id)
);

CREATE TABLE valoracionesusuariotitulo ( 
id_titulo INT,
id_usuario int,
calificacion int not null,
fecha date not null,
primary key (id_titulo, id_usuario),
foreign key (id_titulo) references título(id),
foreign key (id_usuario) references usuario(id)
);

CREATE TABLE usuariosigueausuario ( 
id_usu_seguidor INT,
id_usu_seguido int,
fecha_seguimiento date not null,
primary key (id_usu_seguidor, id_usu_seguido),
foreign key (id_usu_seguidor) references usuario(id),
foreign key (id_usu_seguido) references usuario(id)
);


CREATE TABLE valoracionesusuariotitulo ( 
id_titulo INT,
id_usuario int,
calificacion int not null,
fecha date not null,
primary key (id_titulo, id_usuario )
);

CREATE TABLE tituloenlista ( 
id_titulo int,
id_lista INT,
primary key (id_titulo, id_lista),
foreign key (id_titulo) references título(id)
);

CREATE TABLE visualizacionlistausuario ( 
id_usuario int,
id_lista INT,
primary key (id_usuario, id_lista),
foreign key (id_usuario) references usuario(id)
);

CREATE TABLE listareproduccion ( 
id INT primary key,
id_usuario int,
esPublica varchar(5) not null,
foreign key (id_usuario) references usuario(id),
foreign key (id) references visualizacionlistausuario(id_lista),
foreign key (id) references tituloenlista(id_lista)
);