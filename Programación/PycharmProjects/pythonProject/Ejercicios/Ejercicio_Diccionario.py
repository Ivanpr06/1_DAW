# EJERCICIO 1
juguetes = {
    "pelota": 10,
    "muñeca": 15,
    "coche": 20,
    "rompecabezas": 18,
    "peluche": 12,
    "robot": 25,
    "pistola de agua": 8,
    "tren de juguete": 22,
    "oso de peluche": 14,
    "cometa": 10,
    "bloques de construcción": 30,
    "balón de fútbol": 16,
    "patineta": 35,
    "avión de juguete": 24,
    "casa de muñecas": 28,
}


def ej_2():
    elegir_juguete = input("¿De que juguete quieres saber el precio?: ").lower()
    print(f"El precio de el/la {elegir_juguete} es {juguetes[elegir_juguete]} euros")


def ej_3():
    juguetes["pelota"] = 15
    print(juguetes)


def ej_4():
    juguetes["videojuego"] = 38
    print(juguetes)


def ej_5():
    for juguete in juguetes:
        print(juguete, juguetes[juguete])


def ej_6():
    promedio = []
    for juguete in juguetes:
        promedio.append(juguetes[juguete])
    print(sum(promedio) / len(juguetes))


def ej_7():
    eliminar_juguete = input("Que juguete quieres eliminar?: ").lower()
    juguetes.pop(eliminar_juguete)
    for juguete in juguetes:
        print(juguete, juguetes[juguete])


def ej_8():
    precio_limite = int(input("¿Cual precio es tu límite?: "))
    if juguetes[juguetes] <= precio_limite:
        print(juguetes)
    else:
        print("No")

ej_8()
