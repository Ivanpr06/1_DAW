-- Ejercicio 1: Hola Mundo
BEGIN   
	DBMS_OUTPUT.PUT_LINE('Hola Mundo'); 
END;

-- Ejercicio 2: Variables básicas
DECLARE
	v_nombre varchar2(50) := 'Manolo';
BEGIN 
	DBMS_OUTPUT.PUT_LINE(v_nombre); 
END;

-- Ejercicio 3: Operaciones matemáticas
DECLARE
	v_operador1 number(10,2) := 1;
	v_operador2 number(10,2) := 2;
BEGIN 
	DBMS_OUTPUT.PUT_LINE(v_operador1 + v_operador2); 
	DBMS_OUTPUT.PUT_LINE(v_operador1 - v_operador2); 
	DBMS_OUTPUT.PUT_LINE(v_operador1 * v_operador2); 
END;

-- Ejercicio 4: Concatenación
DECLARE
	v_nombre alumnos.nombre%TYPE;
	v_apellidos alumnos.apellidos%TYPE;
BEGIN 
	SELECT a.nombre, a.apellidos
	INTO v_nombre, v_apellidos
	FROM ALUMNOS a
	FETCH FIRST 1 ROW ONLY;
	DBMS_OUTPUT.PUT_LINE(v_nombre || ' ' || v_apellidos);
END;

-- Ejercicio 5: Fecha actual
DECLARE
	v_edad alumnos.fecha_nacimiento%TYPE;
BEGIN
	SELECT a.fecha_nacimiento
	INTO v_edad
	FROM ALUMNOS a 
	FETCH FIRST 1 ROW ONLY;
	DBMS_OUTPUT.PUT_LINE(months_between(SYSDATE, v_edad) / 12);
END;

-- Ejercicio 6: Edad aproximada


BEGIN
	DBMS_OUTPUT.PUT_LINE(months_between(SYSDATE, )); 
END;

