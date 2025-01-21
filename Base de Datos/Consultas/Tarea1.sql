use espanya;

# 1. Obtén todas las comunidades autónomas cuyo nombre en español contiene la palabra "Comunidad".
select ca.nombre
from comunidades_autonomas ca 
where ca.nombre like 'Comunidad%';

# 2. Lista todas las provincias que pertenecen a la comunidad autónoma de "Andalucía".
select p.nombre
from provincias p 
where p.nombre in ('Sevilla', 'Cádiz', 'Almería', 'Huelva', 'Jaén', 'Málaga', 'Cordoba', 'Granada');

# 3. Obtén todas las provincias cuyo nombre comienza con la letra "C".
select p.nombre
from provincias p 
where p.nombre like 'C%';

# 4. Lista las comunidades autónomas ordenadas alfabéticamente por su nombre.
select ca.nombre
from comunidades_autonomas ca 
order by ca.nombre asc;

# 5. Encuentra las 5 provincias con los nombres más largos.
select p.nombre
from provincias p 
order by length (nombre) desc 
limit 5;

# 6. Obtén todos los municipios cuyo nombre contenga la palabra "San".
select m.nombre 
from municipios m 
where m.nombre like '%San%';


# 7. Encuentra todos los municipios cuyo nombre empiece por "Vill" y termine en "o".
select m.nombre 
from municipios m 
where m.nombre like ('Vil%o');


# 8. Lista las provincias con más de 50 municipios.
select * from
(select p.nombre, count(1) numero
from provincias p 
join municipios m on p.id = m.id_provincia 
group by p.id)aux1
where numero > 50;

# 9. Obtén todos los municipios cuyo nombre sea igual a su provincia.
 select p.nombre 
 from municipios m
 join provincias p on (p.id = m.id_provincia)
 where p.nombre = m.nombre ;

# 10. Encuentra todas las provincias que contienen municipios con nombres repetidos.
select nombre
from municipios
group by nombre having count(1) > 1;

# 11. Lista todas las provincias que pertenecen a una comunidad autónoma cuyo nombre comience con "C".
select p.nombre
from provincias p 
join comunidades_autonomas ca on (p.id_com_auto = ca.id)
where ca.nombre like 'C%';

# 12. Obtén los nombres de las provincias que contienen municipios cuyo nombre contenga la palabra "Real".
select p.nombre
from provincias p 
join  municipios m on (p.id = m.id_provincia)
where m.nombre like '%Real%'
group by p.nombre;

# 13. Encuentra todas las provincias donde todos sus municipios tienen nombres de menos de 10 caracteres.
select p.nombre
from provincias p 
join municipios m  on (p.id = m.id_provincia)
where char_length (m.nombre) < 10
group by p.nombre;

# 14. Lista las comunidades autónomas que no contienen la palabra "Comunidad" en su nombre en español.
select ca.nombre_es 
from comunidades_autonomas ca 
where ca.nombre_es not like '%Comunidad%';

# 15. Obtén los municipios que pertenezcan a provincias cuyo nombre termine en "a".
select ca.nombre
from comunidades_autonomas ca 
join provincias p on (p.id_com_auto = ca.id)
where p.nombre like '%a'
group by ca.nombre;

# 16. Lista los nombres de las provincias que tienen al menos 10 municipios cuyo nombre contenga la palabra "Santa".
select p.nombre
from provincias p 
join municipios m on (p.id = m.id_provincia)
where m.nombre like '%Santa%'
group by p.nombre;

# 17. Encuentra todos los municipios que compartan el mismo nombre que otra comunidad autónoma.
select m.nombre 
from municipios m 
join provincias p on (m.id_provincia = p.id)
join comunidades_autonomas ca on (p.id_com_auto = ca.id)
where m.nombre = ca.nombre;

# 18. Lista las comunidades autónomas ordenadas por el número de provincias que contienen.
select ca.nombre, count(2) num_provincias 
from comunidades_autonomas ca 
join provincias p on (ca.id = p.id_com_auto)
group by ca.nombre
order by count(2) desc;

# 19. Encuentra las comunidades autónomas que tengan provincias con nombres que comiencen con vocal.
select ca.nombre
from comunidades_autonomas ca 
join provincias p on (ca.id = p.id_com_auto)
where substr(p.nombre ,1,1) in ('A', 'E', 'I', 'O', 'U') 
group by ca.nombre;

# 20. Lista todos los municipios cuyo nombre contenga exactamente 5 letras.
select m.nombre
from municipios m 
where char_length(m.nombre) = 5;