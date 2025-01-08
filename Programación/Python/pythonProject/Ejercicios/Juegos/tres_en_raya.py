def tres_en_raya():
    def introducir_tabla(tablero):
        print("--------------------TABLERO---------------------")
        for fila in tablero:
            print(fila)

    def corregir_num(contador, jugador_1, posicion_1, tablero,ficha_1):
        # Instrucción 5
        # Instrucción 9 (números ya marcados)
        while posicion_1.isalpha() or posicion_1 == "" or int(posicion_1) < 0 or int(posicion_1) > 8 or posicion_1 in numeros_marcados:
            print("No disponible")
            posicion_1 = input(f"¿Donde quieres marcar {jugador_1}?: ")
            contador -= 1
        # Instrucción 6
        for i in range(len(tablero)):
            for j in range(len(tablero[i])):
                if int(posicion_1) == tablero[i][j]:
                    tablero[i][j] = ficha_1
                    introducir_tabla(tablero)
                    numeros_marcados.append(posicion_1)

        # Instrucción 7
    def horizontal(contador, jugador_1, tablero):
        for fila in tablero:
            if fila[0] == fila[1] == fila[2]:
                print(f"Has ganado {jugador_1}")
                exit()
        return contador

    def vertical(contador, jugador_1, tablero):
        for i in range(3):
            if tablero[0][i] == tablero[1][i] == tablero[2][i]:
                print(f"Has ganado {jugador_1}")
                exit()
        return contador

    def linea(contador, jugador_1, tablero):
        if tablero[0][0] == tablero[1][1] == tablero[2][2]:
            print(f"Has ganado {jugador_1}")
            exit()
        if tablero[0][2] == tablero[1][1] == tablero[2][0]:
            print(f"Has ganado {jugador_1}")
            exit()
        return contador

    # Instrucción 2
    tablero = [[0, 1, 2], [3, 4, 5], [6, 7, 8]]
    numeros_marcados = []


    # Instrucción 3
    jugador_1 = input("¿ Cuál es tu nombre Jugador 1 ?: ")
    jugador_2 = input("¿ Cuál es tu nombre Jugador 2 ?: ")
    ficha_1 = "X"
    ficha_2 = "O"
    contador = 0


    # Instrucción 4
    introducir_tabla(tablero)

    # Instrucción 5
# Jugador 1
    while contador <= 8:
        posicion_1 = input(f"¿Donde quieres marcar {jugador_1}?: ")
        contador += 1
        corregir_num(contador, jugador_1, posicion_1, tablero, ficha_1)
        # Instrucción 7
        horizontal(contador, jugador_1, tablero)
        vertical(contador, jugador_1, tablero)
        linea(contador, jugador_1, tablero)

        if contador > 8:
            print("Ha sido un empate")
            break

# Jugador 2
        posicion_2 = input(f"¿Donde quieres marcar {jugador_2}?: ")
        contador += 1
        corregir_num(contador, jugador_2, posicion_2, tablero, ficha_2)
        # Instrucción 7
        horizontal(contador, jugador_2, tablero)
        vertical(contador, jugador_2, tablero)
        linea(contador, jugador_2, tablero)

tres_en_raya()