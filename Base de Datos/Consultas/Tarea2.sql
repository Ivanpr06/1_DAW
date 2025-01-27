# 1. Calcular la suma total de escuchas mensuales de todos los cantantes
select sum(escuchas_mensuales) escuchas_sumas
from cantantes;

# 2. Obtener el promedio de escuchas mensuales por cantante
select avg(escuchas_mensuales) escuchas_promedio
from cantantes;

# 3. Listar el cantante con el mayor número de escuchas mensuales.
select nombre, escuchas_mensuales  
from cantantes
order by escuchas_mensuales desc 
limit 1;

select nombre 
from cantantes c 
where
escuchas_mensuales = (select max(escuchas_mensuales)
from cantantes c);

# 4. Mostrar el cantante con el menor número de seguidores en redes sociales
select nombre, seguidores_redes 
from cantantes
order by seguidores_redes asc 
limit 1;

# 5. Contar cuántos cantantes tienen más de 100 millones de seguidores en redes sociales.
select nombre, seguidores_redes
from cantantes
where seguidores_redes > 100000000;

# 6. Calcular la media de seguidores en redes sociales entre todos los cantantes.
select avg(seguidores_redes) seguidores_redes
from cantantes;

# 7. Mostrar el número total de álbums lanzados por los cantantes
select sum(c.albums_lanzados) suma_albunes
from cantantes c 

# 8. Obtener el cantante que ha lanzado el mayor número de álbums.
select nombre, albums_lanzados
from cantantes
order by albums_lanzados desc 
limit 1;

# 9. Listar los cantantes con más de 5 álbums lanzados.
select nombre, albums_lanzados
from cantantes
where albums_lanzados > 5;

# 10. Calcular el promedio de seguidores en redes sociales de los cantantes originarios de Colombia.
select avg(c.seguidores_redes) seguidores_colombia
from cantantes c 
where c.pais_origen = 'Colombia';

# 11. Obtener el cantante más joven
select c.nombre 
from cantantes c 
order by c.fecha_nacimiento desc 
limit 1;

# 12. Mostrar el cantante con la mayor diferencia entre escuchas mensuales y seguidores en redes sociales
select c.nombre, abs(c.escuchas_mensuales - c.seguidores_redes)
from cantantes c 
order by 2
limit 1;

# 13. Contar cuántos cantantes tienen el género 'Pop'
select count(1)
from cantantes c 
where c.genero = 'Pop';

# 14. Obtener el promedio de escuchas mensuales de los cantantes de 'Reggaetón'.
select avg(c.escuchas_mensuales)
from cantantes c 
where c.genero = 'Reggaetón';

# 15. Listar los cantantes que nacieron después de 1990.
select c.nombre 
from cantantes c 
where c.fecha_nacimiento > '1990-01-01';

# 16. Calcular la suma de escuchas mensuales de los cantantes de 'Reggaetón'
select sum(c.escuchas_mensuales)
from cantantes c 
where c.genero = 'Reggaetón';

# 17. Mostrar el cantante con el menor número de álbums lanzados y con más de 500 millones de escuchas mensuales.
select c.nombre 
from cantantes c 
where c.escuchas_mensuales > 500000000
order by c.albums_lanzados asc 
limit 1;

# 18. Obtener el promedio de edad de los cantantes (considerar la fecha de nacimiento para calcular la edad).
select abs(avg(timestampdiff(year, current_date(), fecha_nacimiento)))
from cantantes c;

# 19. Contar cuántos cantantes tienen más de 7 álbums lanzados.
select count(1)
from cantantes c 
where c.albums_lanzados > 7;

# 20. Listar los cantantes con más de 600 millones de escuchas mensuales y más de 200 millones de seguidores en redes sociales.
select c.nombre 
from cantantes c
where c.escuchas_mensuales > 600000000 and c.seguidores_redes > 200000000;

# 21. Contar cuántos cantantes tienen el género 'Pop' y son originarios de España.
select c.nombre
from cantantes c 
where c.genero = 'Pop' and c.pais_origen = 'España';

# 22. Calcular el promedio de escuchas mensuales de los cantantes de España
select avg(c.escuchas_mensuales)
from cantantes c 
where c.pais_origen = 'España';

# 23. Obtener el cantante con más álbums lanzados entre los cantantes de reggaetón.
select c.nombre
from cantantes c 
where c.genero = 'Reggaetón'
order by c.albums_lanzados desc # desc = mayor a menor 
limit 1;

# 24. Mostrar el número total de seguidores en redes sociales de los cantantes colombianos.
select sum(c.seguidores_redes)
from cantantes c 
where c.pais_origen = 'Colombia';

# 25. Listar los cantantes con más de 600 millones de escuchas mensuales que sean originarios de España
select c.nombre
from cantantes c 
where c.escuchas_mensuales > 600000000 and c.pais_origen = 'España';

# 26. Contar cuántos cantantes tienen el género 'Flamenco/Pop' o 'Pop/Rap'.
select count(1)
from cantantes c 
where c.genero = 'Flamenco/Pop' or c.genero = 'Pop/Rap';

# 27. Obtener el promedio de álbums lanzados por los cantantes de 'Reggaetón'
select avg(c.albums_lanzados)
from cantantes c 
where c.genero = 'Reggaetón';

# 28. Listar los cantantes con más de 8 álbums lanzados y con más de 500 millones de escuchas mensuales
select c.nombre
from cantantes c 
where c.albums_lanzados > 8 and c.escuchas_mensuales > 500000000;

# 29. Obtener el cantante más popular (con más seguidores en redes sociales) de los géneros 'Pop' y 'Reggaetón'
select c.nombre
from cantantes c 
where c.genero = 'Pop' and c.genero = 'Reggaetón'
order by c.seguidores_redes desc 
limit 1;

# 30. Mostrar el total de escuchas mensuales de los cantantes que nacieron después de 1990.
select sum(c.escuchas_mensuales)
from cantantes c 
where c.fecha_nacimiento > 1990-01-01;

# 31. Contar cuántos cantantes han lanzado más de 10 álbums
select count(1)
from cantantes c 
where c.albums_lanzados > 10;

# 32. Obtener el promedio de seguidores en redes sociales de los cantantes nacidos en Colombia.
select avg(c.seguidores_redes)
from cantantes c 
where c.pais_origen = 'Colombia';

# 33. Listar los cantantes con menos de 300 millones de escuchas mensuales pero con más de 100 millones de seguidores en redes sociales
select c.nombre
from cantantes c 
where c.escuchas_mensuales < 300000000 and c.seguidores_redes > 100000000;

# 34. Calcular la diferencia promedio de escuchas mensuales entre los cantantes de 'Reggaetón' y los de 'Pop'.
select abs((select avg(c.escuchas_mensuales)
from cantantes c
where c.genero = 'Reggaetón'
group by genero) - (select avg(c.escuchas_mensuales)
from cantantes c
where c.genero = 'Pop'
group by c.genero));



# 35. Obtener el cantante con la mayor edad (más años) entre todos los cantantes.
select c.nombre
from cantantes c 
order by c.fecha_nacimiento asc 
limit 1;

# 36. Contar cuántos cantantes de 'Pop' tienen más de 5 álbums lanzados.
select count(1)
from cantantes c 
where c.genero = 'Pop' and c.albums_lanzados > 5;

# 37. Mostrar el total de seguidores en redes sociales de todos los cantantes de género 'R&B'
select sum(c.seguidores_redes)
from cantantes c 
where c.genero = 'R&B'

# 38. Listar los cantantes con más de 200 millones de seguidores y más de 500 millones de escuchas mensuales.
select c.nombre
from cantantes c 
where c.seguidores_redes > 200000000 and c.escuchas_mensuales > 500000000;

# 39. Obtener el promedio de escuchas mensuales de los cantantes que tienen más de 5 álbums lanzados
select avg(c.escuchas_mensuales)
from cantantes c 
where c.albums_lanzados > 5;

# 40. Listar los cantantes con menos de 5 álbums lanzados, pero con más de 200 millones de seguidores en redes sociales.
select c.nombre 
from cantantes c
where c.albums_lanzados < 5 and c.seguidores_redes > 200000000;