def ahorcado():
    palabra_oculta = input("Ingrese la palabra oculta: ")
    palabra_oculta = palabra_oculta.lower()
    lista_oculta = []

    for letra in palabra_oculta:
        lista_oculta.append("_")
    print("".join(lista_oculta))

    letra_jugador = input("Dime letra:")

    if letra_jugador in palabra_oculta:
        for posicion in range(len(palabra_oculta)):
            letra = palabra_oculta[posicion]
            if letra_jugador == letra:
                lista_oculta[posicion] = letra
    else:
        print("Tu letra no está, has perdido una vida")

    print("".join(lista_oculta))


ahorcado()






