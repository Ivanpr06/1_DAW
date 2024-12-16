def palabras_encadenadas():
    print("Bienvenidos al juego de Palabras Encadenadas")
    # Instrucción 2
    jugador1 = input("Ingresa el nombre del Jugador 1: ")
    jugador2 = input("Ingresa el nombre del Jugador 2: ")
    # Instrucción 3
    palabra_actual = input("Ingresa una palabra inicial para empezar el juego: ").lower()
    palabras_usadas = [palabra_actual]
    turno = 0

    # Instrucción 4
    while True:
        if turno % 2 == 0:
            jugador_actual = jugador1
        else:
            jugador_actual = jugador2

        print(f"Turno de {jugador_actual}.")
        palabra_nueva = input(f"Ingresa una palabra que comience con '{palabra_actual[:2]}': ").lower()
        # Instrucción 5
        if palabra_nueva.startswith(palabra_actual[:2]) and palabra_nueva not in palabras_usadas:
            palabras_usadas.append(palabra_nueva)
            palabra_actual = palabra_nueva
            turno += 1
        # Instrucción 6
        else:
            # Instrucción 7
            print(f"¡{jugador_actual} ha perdido! La palabra '{palabra_nueva}' no es válida.")
            # Instrucción 8
            jugar = input("Quieres volver a jugar? [si/no]: ").lower()
            if jugar == "si":
                palabra_actual = input("Ingresa una palabra inicial para empezar el juego: ").lower()
            elif jugar == "no":
                print("Fin del juego")
                break
            else:
                print("No valido")
                break

palabras_encadenadas()