#EJERCICIO 1
def ej_1():
    name = input("Escribe el nombre del usuario: ")
    print(name)


#EJERCICIO 2
def ej_2():
    texto = "Lolo es la caña"
    texto_en_mayusculas = texto.upper()
    print(texto_en_mayusculas)


#EJERCICIO 3
def ej_3():
    cadena_texto = input("Que opinas de Lolo: ")
    cadena_texto_a = cadena_texto.count("a")
    print("En tu hay ",cadena_texto_a, " letras a")


#EJERCICIO 4
def ej_4():
    manoli = "PACO"
    print(manoli[::-1])


#EJERCICIO 5
def ej_5():
    texto_normal = "Pues Lolo ahora si que me parece la caña"
    print(texto_normal.replace(" ", ""))


#EJERCICIO 6
def ej_6():
    vocal = "Naaaa Lolo tampoco es pa tanto"

    vocal =(vocal.replace("a", ""))
    vocal =(vocal.replace("e", ""))
    vocal =(vocal.replace("i", ""))
    vocal =(vocal.replace("o", ""))
    vocal =(vocal.replace("u", ""))
    print(vocal)


#EJERCICIO 7
def ej_7():
    programa = input("Que opinas de Lolo: ")
    programa = (programa.count(" "))
    print("El programa tiene", programa, "espacios")


#EJEERCICIO 8
def ej_8():
    palabra = input("Dime una palabra palíndroma: ")
    palabra_da_la_vuelta = palabra[:: -1]
    print("Palabra oroginal : ", palabra)
    print("Palabra volteada: ", palabra_da_la_vuelta)

    if palabra_da_la_vuelta == palabra:
        print("Esa palabra es un palíndromo")
    else:
        print("Esa palabra no es un palíndromo")


#EJERCICIO 9
def ej_9():
    sin_cambio = input("Que opinas de Lolo: ")
    cambio = input("Que letra quieres cambiar: ")
    cambio_2 = input("Por cual letra quieres cambiar: ")
    print(sin_cambio.replace(cambio, cambio_2))


def ej_10():
    contrasenya = input("Cual es la contrasenya: ")
    for letra in contrasenya:
        if letra.isdigit():
           contrasenya = contrasenya.replace(letra, "")
    print(contrasenya)


def ej_11():
    lista = ["diego", "jesús", "piedras", "pino"]
    for palabra in lista:
        if len(palabra) > 5:
            print(palabra)
ej_11()





