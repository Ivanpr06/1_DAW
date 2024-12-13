Algoritmo Actividad_1
	vida_goku = 1000
	vida_vegeta = 1000
	Mientras vida_goku <> 0 o vida_vegeta <> 0 Hacer
		Escribir "¿De quien es el turno?"
		Leer turno
		Si turno = "goku" Entonces
			Escribir "¿Cual ataque quieres usar? Fuerte(3),Medio(2) o Leve(1)"
			Leer ataque
			Si ataque = "1" Entonces
				Escribir "La vida de vegeta es ",vida_vegeta-50 
			Fin Si
			Si ataque = "2" Entonces
				Escribir "La vida de vegeta es ",vida_vegeta-100 
			Fin Si
			Si ataque = "3" Entonces
				ataque3 = AZAR(100)
				Si ataque3 >= 30 Entonces
					Escribir "La vida de vegeta es ",vida_vegeta-200 
				SiNo
					Escribir "Fallo"
				Fin Si
			Fin Si
		Fin Si
		
		Si turno = "vegeta" Entonces
			Escribir "¿Cual ataque quieres usar? Fuerte(3),Medio(2) o Leve(1)"
			Leer ataque
			Si ataque = "1" Entonces
				Escribir "La vida de goku es ",vida_goku-50 
			Fin Si
			Si ataque = "2" Entonces
				Escribir "La vida de goku es ",vida_goku-100 
			Fin Si
			Si ataque = "3" Entonces
				ataque3 = AZAR(100)
				Si ataque3 >= 30 Entonces
					Escribir "La vida de goku es ",vida_goku-200 
				SiNo
					Escribir "Fallo"
				Fin Si
			Fin Si
		Fin Si
	Fin Mientras
FinAlgoritmo
