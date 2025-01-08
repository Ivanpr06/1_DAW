# Como NO hacerlo

lista = [1, 2, 3, 4, 5]
lista_palabras = ["azul", "verde", "amarilla"]

lista_alumnos = ["Javi", "Maximo", "Lucía"]

# Como SI hacerlo

alumno1 = {
    "nombre": "Javier",
    "apellidos": "Pacheco",
    "mail": "jpacheco@safaresyes.es",
}

alumno2 = {
    "nombre": "Iván",
    "apellidos": "Ramos",
    "mail": "iramos@safaresyes.es",
}

lista_alumnos_clase = []
lista_alumnos_clase.append(alumno1)
lista_alumnos_clase.append(alumno2)

print(lista_alumnos_clase)
print("--------------------------------------------------------------------")

print(alumno1["nombre"])
print("--------------------------------------------------------------------")

# Como saber SOLO el nombre de los alumnos

for alumno in lista_alumnos_clase:
    print(alumno["nombre"])
print("--------------------------------------------------------------------")

# Sirve para imprimir los CAMPOS del diccionario
lista_claves = alumno1.keys()
for key in lista_claves:
    print(key)
print("--------------------------------------------------------------------")

# Sirve para imprimir la INFORMACIÓN del diccionario
lista_valores = alumno1.values()
for valor in lista_valores:
    print(valor)
print("--------------------------------------------------------------------")

# Añade campos e información al diccionario
alumno1["telefono"] = 9748673467965965
print(alumno1)
print("--------------------------------------------------------------------")

# Sustituye la información de un campo de una biblioteca
alumno1["nombre"] = "Manolo"
print("--------------------------------------------------------------------")

