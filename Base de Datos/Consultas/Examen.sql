-- Ejercicio 1
select apellidos || ', ' || nombre nombre_alumno, max_nota
FROM 
(select a.apellidos, a.nombre, max(aa.nota) max_nota from
alumnos a
join alumnos_asignaturas aa ON a.id = aa.id_alumno
group by a.apellidos, a.nombre)
order by max_nota DESC
FETCH FIRST 5 ROWS only;

-- Ejercicio 2
SELECT upper(a.NOMBRE) nombre, lower(a.APELLIDOS) apellidos, round(MONTHS_BETWEEN(SYSDATE, a.FECHA_NACIMIENTO) / 12) edad
FROM ALUMNOS a
ORDER BY a.APELLIDOS asc ;

/*SELECT upper(a.NOMBRE) nombre, lower(a.APELLIDOS) apellidos, round(datediff(current_date(), a.FECHA_NACIMIENTO)) edad
 * FROM ALUMNOS a
 * ORDER BY a.APELLIDOS asc ;
 */

-- Ejercicio 3
SELECT c.TITULO, REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(c.ARTISTA,'a','A'),'e','E'),'i','I'),'o','O'),'u','U') artista
FROM CANCIONES c 
left JOIN ALUMNOS_CANCIONES ac on ac.ID_CANCION = c.ID 
left JOIN ALUMNOS a ON a.ID = ac.ID_ALUMNO
WHERE ac.ID_CANCION IS NULL
ORDER BY reverse(c.TITULO) asc;

-- Ejercicio 4
SELECT p.NOMBRE, replace(p.TITULACION,' ', '_') titulacion, a2.nombre asignatura,CASE WHEN aa.nota > 5 THEN 1 
ELSE 0 END aprobados
FROM PROFESORES p
inner JOIN PROFESORES_CENTROS_ASIGNATURAS pca ON p.id = pca.id_profesor
inner JOIN CENTROS c ON pca.id_centro = c.id
inner JOIN ALUMNOS a ON c.id = a.id_centro
inner JOIN ALUMNOS_ASIGNATURAS aa ON a.id = aa.id_alumno
inner JOIN ASIGNATURAS a2 ON aa.id_asignatura = a2.id and a2.id = pca.id_asignatura 
ORDER BY p.NOMBRE ASC;

-- Ejercicio 5
CREATE OR REPLACE VIEW vista_profesor AS
SELECT p.nombre, p.titulacion
FROM PROFESORES p
WHERE p.titulacion LIKE 'Doctor%'
EXCEPT 
SELECT p.nombre, p.titulacion
FROM PROFESORES p 
INNER JOIN PROFESORES_CENTROS_ASIGNATURAS pca ON pca.id_profesor = p.id
INNER JOIN CENTROS c ON pca.id_centro = c.id
WHERE c.localidad like 'Madrid'
ORDER BY 1 asc;

SELECT * FROM vista_profesor;

-- Ejercicio 6
SELECT  a2.NOMBRE || ' ' || a2.APELLIDOS alumno, c.TITULO 
FROM ASIGNATURAS a 
INNER JOIN ALUMNOS_ASIGNATURAS aa ON a.ID = aa.ID_ASIGNATURA 
INNER JOIN ALUMNOS a2 ON aa.ID_ALUMNO = a2.ID 
INNER JOIN ALUMNOS_CANCIONES ac ON a2.ID = ac.ID_ALUMNO 
INNER JOIN CANCIONES c ON c.ID = ac.ID_CANCION 
ORDER BY a2.NOMBRE ASC;

