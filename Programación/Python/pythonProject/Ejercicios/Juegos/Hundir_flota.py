import random

#Instrucción 2
def generar_barcos():
    posiciones_disponibles = list(range(1, 11))  # Posiciones de 1 a 10
    barcos = {}

    # Asignar posiciones para cada barco, asegurándose que no se superpongan
    barcos['Transatlántico'] = random.sample(posiciones_disponibles, 1)
    for pos in barcos['Transatlántico']:
        posiciones_disponibles.remove(pos)

    barcos['Acorazado'] = random.sample(posiciones_disponibles, 1)
    for pos in barcos['Acorazado']:
        posiciones_disponibles.remove(pos)

    barcos['Submarino'] = random.sample(posiciones_disponibles, 1)
    for pos in barcos['Submarino']:
        posiciones_disponibles.remove(pos)

    return barcos


#Instrucción 5
def jugar_ronda(jugador, barcos, puntajes):
    print(f"\nTurno de {jugador}.")
    intento = int(input(f"{jugador}, elige una posición (1-10): "))

    #Instrucción 6
    acierto = False
    for barco, posiciones in barcos.items():
        if intento in posiciones:
            #Instrucción 7
            if barco == 'Transatlántico':
                puntajes[jugador] += 3
            elif barco == 'Acorazado':
                puntajes[jugador] += 4
            elif barco == 'Submarino':
                puntajes[jugador] += 5
            print(f"¡Acertaste! Hundiste el {barco} y ganaste puntos.")
            barcos[barco].remove(intento)
            acierto = True
            break

    if not acierto:
        print("Fallaste. No hay un barco en esa posición.")

    print(f"Puntaje actual de {jugador}: {puntajes[jugador]} puntos.")


# Función principal del juego
def hundir_barcos():
    #Instrucción 1 y 3
    jugador1 = input("Ingresa el nombre del Jugador 1: ")
    jugador2 = input("Ingresa el nombre del Jugador 2: ")

    # Inicializar los puntajes
    puntajes = {jugador1: 0, jugador2: 0}

    # Generar los barcos aleatoriamente
    barcos = generar_barcos()
    print("\nLos barcos han sido colocados en posiciones aleatorias.")

    #Instrucción 4 y 8
    for ronda in range(1, 4):
        print(f"\n--- Ronda {ronda} ---")

        # Turno del Jugador 1
        jugar_ronda(jugador1, barcos, puntajes)

        # Turno del Jugador 2
        jugar_ronda(jugador2, barcos, puntajes)

    #Instrucción 9
    print("\n--- Fin del juego ---")
    print(f"Puntaje final de {jugador1}: {puntajes[jugador1]} puntos.")
    print(f"Puntaje final de {jugador2}: {puntajes[jugador2]} puntos.")

    #Instrucción 9
    if puntajes[jugador1] > puntajes[jugador2]:
        print(f"¡{jugador1} es el ganador!")
    elif puntajes[jugador1] < puntajes[jugador2]:
        print(f"¡{jugador2} es el ganador!")
    else:
        print("¡Es un empate!")


# Ejecutar el juego
hundir_barcos()