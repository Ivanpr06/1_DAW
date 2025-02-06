import random  # Libreria para introducir valores random


def genera_numeros_aleatorios():

    num_aleatorio = random.randint(1, 99)  # Randint genera números random (tu decides cuales)
    return num_aleatorio


def dime_numeros_sin_repetir():
    numeros_dichos = []

    while len(numeros_dichos) < 99:  # Bucle igual a for pero necesita una condición
        num_aleatorios = genera_numeros_aleatorios()

        if num_aleatorios not in numeros_dichos:
            print(num_aleatorios)
            numeros_dichos.append(num_aleatorios)


def genere_carton_jugador():
    carton = []

    while len(carton) < 9:
        num = genera_numeros_aleatorios()
        if num not in carton:
            carton.append(num)

    carton.sort()

    carton_final = [carton[:3], carton[3:7], carton[-3:]]   # Los tres últimos = -3:
    print(carton_final)
    return carton_final


genere_carton_jugador()

