Algoritmo Actividad_10
		Escribir "¿Cual es el valor de a?"
		Leer a 
		Si a = 0 Entonces
			Repetir
				Escribir "¿Cual es el valor de a?"
				Leer a
			Hasta Que a <> 0
		Fin Si
		Si a%2=0 Entonces
			Escribir "El numero es par"
		SiNo
			Escribir "El numero es impar"
		Fin Si
FinAlgoritmo
