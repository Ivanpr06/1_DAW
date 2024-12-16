# BUCLES
import random
# BUCLES FINITOS

# FOR (Cláscio) --> Range / Indices / Posiciones
lista = ["Sol", "Luna", "Planeta"]
def FOR():

    for var in range(len(lista)):
        print(var)
        print(lista[var])

# FOR EACH (for var in lista)
def FOR_EACH():
    for elemento in lista:
        print(elemento)

# BUCLES INDETERMINADOS

# WHILE
def WHILE():
    lista_numeros_divisibles_2_3 = []
    num_ejecutado = 0

    while len(lista_numeros_divisibles_2_3) < 30:
        numero_aleatorio = random.randint(1, 999)
        num_ejecutado += 1
        if numero_aleatorio % 2 == 0 and numero_aleatorio % 3 == 0:
            lista_numeros_divisibles_2_3.append(numero_aleatorio)


    print(lista_numeros_divisibles_2_3)

    print(num_ejecutado)
WHILE()