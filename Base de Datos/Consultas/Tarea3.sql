# 1. Obtener la longitud en caracteres y en bytes del título de cada libro. 
select l.titulo ,length(l.titulo), char_length(l.titulo) 
from libros l;

# 2. Convertir los títulos a mayúsculas.
select upper(l.titulo)
from libros l; 

# 3. Extraer los primeros 10 caracteres del título de cada libro. 
select left(l.titulo, 10)
from libros l; 

# 4. Mostrar los títulos con el autor concatenado en formato: Título - Autor 
select concat(l.titulo, ' - ', l.autor)
from libros l;

# 5. Redondear el precio de los libros a 1 decimal. 
select l.titulo ,round(l.precio,1)
from libros l;

# 6. Eliminar espacios al inicio y final de los títulos. 
select trim(l.titulo)
from libros l;

# 7. Reemplazar "El" en los títulos por "La". 
select replace (trim(l.titulo)),'La', 'El')
from libros l;

# 8. Obtener el precio absoluto al restar 20 del precio de cada libro. 
select l.titulo, abs(l.precio - 20)
from libros l;

# 9. Mostrar la fecha de publicación en formato 'día/mes/año'. 
select l.titulo ,date_format(l.fecha_publicacion, '%d/%m/%Y') 
from libros l;

# 10. Extraer el año de publicación de cada libro. 
select l.titulo , date_format(l.fecha_publicacion, '%Y') 
from libros l;

# 11. Mostrar los títulos que contienen "de" (mayúsculas o minúsculas). 
select l.titulo 
from libros l 
where upper(l.titulo) like '%de%';

# 12. Mostrar los títulos con su longitud y los primeros 5 caracteres en mayúsculas. 
select l.titulo, length(l.titulo), upper(left(l.titulo, 5))
from libros l;

# 13. Obtener los libros con precios mayores al promedio. 
SELECT AVG(l.precio) FROM libros l;
select l.titulo
from libros l  
WHERE l.precio > (SELECT AVG(l.precio) FROM libros l);

# 14. Calcular el tiempo en días desde la fecha de publicación hasta hoy. 
select l.titulo ,datediff(current_date(), l.fecha_publicacion) 
from libros l;

# 15. Redondear y elevar el precio al cuadrado. 
select round(power(l.precio,2))
from libros l; 

# 16. Mostrar el título y precio clasificado como "Caro" (>20) o "Barato". 
select l.titulo , l.precio, case when l.precio > 20 then 'Caro'
else 'Barato' end
from libros l;

# 17. Mostrar la fecha actual y el título de los libros publicados hace más de 50 años. 
select current_date(), l.titulo , l.fecha_publicacion 
from libros l
where date_add(l.fecha_publicacion, interval 50 year) < current_date();  
 
# 18. Mostrar los libros con su precio ajustado a un 10% de descuento. 
select l.titulo , round(l.precio*0.90,2)
from libros l;

# 19. Mostrar títulos y agregar "Edición Especial" si su precio supera los 25. 
select case when l.precio > 25 then concat(l.titulo, ' - Edición especial') 
else l.titulo end
from libros l;

# 20. Extraer los últimos 4 caracteres de cada título. 
select left(l.titulo, 4)
from libros l; 

# 21. Concatenar el título con el año de publicación y pasarlo a mayúsculas. 
select concat(upper(l.titulo),' - ', date_format(l.fecha_publicacion, '%Y')) 
from libros l;

# 22. Mostrar el precio más alto, redondeado hacia abajo, y su diferencia con el precio.
select l.titulo, l.precio, abs(l.precio - aux.precio_mas_alto) diferencia, 
aux.precio_mas_alto
from
(select floor(l.precio) precio_mas_alto 
from libros l 
order by l.precio desc 
limit 1)aux,
libros l;

# 23. Agregar 100 días a la fecha de publicación de cada libro y formatear el resultado. 
select l.fecha_publicacion, adddate(l.fecha_publicacion, interval 100 day) 
from libros l;

# 24. Mostrar los libros cuyo título tiene más de 15 caracteres. 
select  l.titulo 
from libros l 
where char_length(l.titulo) > 15;

# 25. Obtener la hora actual y el título de los libros publicados antes de 1900. 
select extract(hour from now()), l.titulo
from libros l
where l.fecha_publicacion < '1900/01/01';

# 26. Calcular el precio elevado a 3, luego redondeado a 1 decimal. 
select l.titulo, round(power(l.precio,3),1) precio_por_tres
from libros l

# 27. Mostrar los títulos en minúsculas y reemplazar espacios por guiones. 
select l.titulo, lower(replace(l.titulo,' ', '-'))
from libros l;

# 28. Calcular la media de los precios y mostrar los libros por encima de este valor. 
select l.titulo 
from libros l, (select avg(l.precio) media
from libros l) tab_media
where l.precio > tab_media.media;

# 29. Formatear la fecha actual como "día de mes de año". 
select l.titulo, date_format(l.fecha_publicacion, '%d de %m de %Y') 
from libros l;

# 30. Obtener libros cuyo precio al cuadrado es menor a 1000. 
select l.titulo, power(l.precio,2) 
from libros l
where power(l.precio,2) < 1000;

# 31. Concatenar el autor y género de cada libro con formato "Autor (Género)". 
select concat(l.autor, ' (', l.genero, ')')
from libros l;

# 32. Mostrar el precio absoluto de la diferencia entre el precio máximo y cada precio. 
select l.precio, abs((select max(precio) from libros l) - l.precio) 
from libros l ;

# 33. Listar títulos que terminen en "o" o contengan "y" en minúsculas. 
select l.titulo 
from libros l 
where l.titulo like '%o' and l.titulo like '%y%';

# 34. Aplicar descuento del 15% a libros publicados antes de 1950. 
select l.titulo, case when l.fecha_publicacion < '1950/01/01' then l.precio*0.85
else l.precio end
from libros l;

# 35. Mostrar los títulos con espacios recortados y en mayúsculas. 
select upper(trim(l.titulo))
from libros l;

# 36. Extraer el mes de publicación y mostrar libros publicados en verano (junio, julio)
select l.titulo, l.fecha_publicacion 
from libros l
where extract(month from l.fecha_publicacion) = 6 or extract(month from l.fecha_publicacion) = 7;

# 37. Redondear el precio a 0 decimales y elevarlo a la cuarta potencia. 
select l.titulo ,round(power(l.precio,4),0)
from libros l;

# 38. Mostrar los libros clasificados por precio con etiquetas "Barato" (<15), "Normal" (15-25), "Caro" (>25)  
select l.titulo, case when l.precio < 15 then 'Barato'
when l.precio > 15 and l.precio < 25 then 'Normal'
else 'Caro' end
from libros l;

# 39. Formatear el título añadiendo el año entre paréntesis al final. 
select concat(l.titulo, ' - (', extract(year from l.fecha_publicacion),')')
from libros l;

# 40. Obtener el precio redondeado hacia arriba y hacia abajo para cada libro. 
select l.titulo, l.precio, ceil(l.precio) alza, floor(l.precio) baja
from libros l;