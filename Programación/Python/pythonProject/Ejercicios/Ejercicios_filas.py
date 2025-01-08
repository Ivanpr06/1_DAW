
def ej_1():
    lista_nombres = ["Antonio", "Víctor", "Gonzalo"]
    print(lista_nombres[1])
    lista_nombres.append("Iván")
    print(lista_nombres)


def ej_2():
    lista_numeros = [1, 2, 3, 4, 5]
    lista_numeros[2] = 10
    lista_numeros.pop()     # pop elimina el último
    print(lista_numeros)


def ej_3():
    lista_numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    for numero in lista_numeros:
        print(numero)


def ej_4():
    lista_numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    lista_numeros_pares = []
    for numero in lista_numeros:
        if numero % 2 == 0:
            lista_numeros_pares.append(numero)
    print(lista_numeros_pares)


def ej_5():
    lista_numeros = [1, 2, 3, 4, 5]
    suma = sum(lista_numeros)
    print(suma)


def ej_6():
    matriz_lista = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    lista_total = []
    for lista in matriz_lista:
        print(lista)
    for lista in matriz_lista:
        suma = sum(lista)
        lista_total.append(suma)
    suma_total = sum(lista_total)
    print(suma_total)


def ej_6_1():
    matriz_lista = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    suma = 0
    for fila in matriz_lista:
        for columna in fila:
            suma += columna
    print(suma)


def ej_7(lista):
    suma = sum(lista)
    return suma/len(lista)


def ej_7_mi_media_de_notas_aprobado(lista):
    promedio = ej_7(lista)
    if promedio >= 5:
        print("Aprobado")
    else:
        print("Suspenso")


def ej_8():
    notas = [4, 5, 8, 3, 1, 9, 10]
    aprobada = []
    suspenso = []
    for nota in notas:
        if nota < 5:
            suspenso.append(nota)
        else:
            aprobada.append(nota)
    print("Han aprobado", len(aprobada), "personas")
    print("Han suspendido", len(suspenso), "personas")


def ej_9():
    lista_nombres = ["Manolo", "Luis", "Alejando", "Paco", "Pepe"]
    lista_nombres.sort()
    print(lista_nombres)


def ej_10():
    lista_palabras = ["papelera", "palomino", "palo", "chusta", "loco"]
    programa = input("¿ Esta tu palabra en la lista ? : ")
    if programa in lista_palabras:
        print(programa, "esta en la lista de palabras")
    else:
        print(programa, "no esta en la lista de palabras")








