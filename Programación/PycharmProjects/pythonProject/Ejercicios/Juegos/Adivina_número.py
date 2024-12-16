def adivina_numero():
    # Instrucción 2
    import random
    numero_secreto = random.randint(1, 10)

    # Instrucción 3
    nombre_jugador = input("¿ Cuál es tu nombre?: ")

    # Instrucción 4
    print("Bienvenido",nombre_jugador, "a mi juego, estoy pensando un número del 1 al 10 y tienes 3 intentos para adivinarlo")

    # Instrucción 6
    numero_valido = False
    numero = di_numero("", numero_valido)
    contador = 0

    # Instrucción 5
    while contador < 3:
        contador += 1
    # Instrucción 7
        if numero == numero_secreto:
            print("Ehnorabuena ",nombre_jugador," has adivinado el número que estaba pensando y lo has conseguido en",contador, "intentos")
            break
        elif numero > numero_secreto:
            print("Te pasaste, el número en el que pienso es más bajo")

        elif numero < numero_secreto:
            print("Frío frío, el número en el que pienso es más alto")
        else:
            print("Ingrese un número")

    # Instrucción 8
        if contador < 3:
            numero = di_numero(numero, numero_valido)

    if numero != numero_secreto:
        print("Lo siento mucho",nombre_jugador,"pero se te acabaron los intentos, el número es", numero_secreto)


def di_numero(numero, numero_valido):
    while not numero_valido:
        numero = input("¿Cuál es tu suposición?: ")
        if numero.isnumeric():
            numero = int(numero)
            numero_valido = True
    return numero


adivina_numero()