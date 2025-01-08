def ej_1(lista_palabras):
    print("----------RECUENTO DE LETRAS----------")
    lista_1 = []
    lista_2 = []
    lista_3 = []
    lista_4 = []
    lista_5 = []
    lista_6 = []
    lista_7 = []
    lista_8 = []
    lista_9 = []
    lista_10 = []
    lista_11 = []
    lista_12 = []
    lista_13 = []
    lista_14 = []
    lista_15 = []
    lista_16 = []
    lista_17 = []
    lista_18 = []
    lista_19 = []
    lista_20 = []

    for palabra in lista_palabras:
        if len(palabra) == 1:
            lista_1.append(palabra)
        elif len(palabra) == 2:
            lista_2.append(palabra)
        elif len(palabra) == 3:
            lista_3.append(palabra)
        elif len(palabra) == 4:
            lista_4.append(palabra)
        elif len(palabra) == 5:
            lista_5.append(palabra)
        elif len(palabra) == 2:
            lista_6.append(palabra)
        elif len(palabra) == 6:
            lista_2.append(palabra)
        elif len(palabra) == 7:
            lista_7.append(palabra)
        elif len(palabra) == 8:
            lista_8.append(palabra)
        elif len(palabra) == 9:
            lista_9.append(palabra)
        elif len(palabra) == 10:
            lista_10.append(palabra)
        elif len(palabra) == 11:
            lista_11.append(palabra)
        elif len(palabra) == 12:
            lista_12.append(palabra)
        elif len(palabra) == 12:
            lista_12.append(palabra)
        elif len(palabra) == 13:
            lista_13.append(palabra)
        elif len(palabra) == 14:
            lista_14.append(palabra)
        elif len(palabra) == 15:
            lista_15.append(palabra)
        elif len(palabra) == 16:
            lista_16.append(palabra)
        elif len(palabra) == 17:
            lista_17.append(palabra)
        elif len(palabra) == 18:
            lista_18.append(palabra)
        elif len(palabra) == 19:
            lista_19.append(palabra)
        elif len(palabra) == 20:
            lista_20.append(palabra)

    if len(lista_1) != 0:
        print(f"Palabra de 1 letra: {lista_1}")
    if len(lista_2) != 0:
        print(f"Palabra de 2 letra: {lista_2}")
    if len(lista_3) != 0:
        print(f"Palabra de 3 letra: {lista_3}")
    if len(lista_4) != 0:
        print(f"Palabra de 4 letra: {lista_4}")
    if len(lista_5) != 0:
        print(f"Palabra de 5 letra: {lista_5}")
    if len(lista_6) != 0:
        print(f"Palabra de 6 letra: {lista_6}")
    if len(lista_7) != 0:
        print(f"Palabra de 7 letra: {lista_7}")
    if len(lista_8) != 0:
        print(f"Palabra de 8 letra: {lista_8}")
    if len(lista_9) != 0:
        print(f"Palabra de 9 letra: {lista_9}")
    if len(lista_10) != 0:
        print(f"Palabra de 10 letra: {lista_10}")
    if len(lista_11) != 0:
        print(f"Palabra de 11 letra: {lista_11}")
    if len(lista_12) != 0:
        print(f"Palabra de 12 letra: {lista_12}")
    if len(lista_13) != 0:
        print(f"Palabra de 13 letra: {lista_13}")
    if len(lista_14) != 0:
        print(f"Palabra de 14 letra: {lista_14}")
    if len(lista_15) != 0:
        print(f"Palabra de 15 letra: {lista_15}")
    if len(lista_16) != 0:
        print(f"Palabra de 16 letra: {lista_16}")
    if len(lista_17) != 0:
        print(f"Palabra de 17 letra: {lista_17}")
    if len(lista_18) != 0:
        print(f"Palabra de 18 letra: {lista_18}")
    if len(lista_19) != 0:
        print(f"Palabra de 19 letra: {lista_19}")
    if len(lista_20) != 0:
        print(f"Palabra de 20 letra: {lista_20}")


# ej_1(["uña","y","polar","marruecos","chico","Magna","murcielago","ksjhdjshdhkaddddddddd"])

def ej_3(numero,num_multiplos):
    contador_fin = 0
    numero_inicial = 1
    lista_multiplos = []
    while contador_fin < num_multiplos:
        numero_inicio = numero_inicial * numero
        contador_fin += 1
        numero_inicial = numero_inicial + 1
        lista_multiplos.append(numero_inicio)
    print(lista_multiplos)

#ej_3(2,7)

regalos_navidenyos =[{
        "nombre": "Bicicleta",
        "precio": 150.99,
        "edad_recomendada": 8,
        "disponible": True,
        "colores": ["Rojo", "Azul","Verde"],
        "peso": 12.5,
    },
    {
        "nombre": "Muñeca Parlante",
        "precio": 49.99,
        "edad_recomendada": 4,
        "disponible": True,
        "colores": ["Rosa", "Violeta"],
        "peso": 1.2,
    }]

def ej_5_a(regalos_navidenyos):

    for regalo in regalos_navidenyos:
        print(f"{regalo["nombre"]} tiene disponible los colores: {regalo['colores']}")

# ej_5_a(regalos_navidenyos)

def ej_5_b(regalos_navidenyos):

    lista_precio = []
    for regalo in regalos_navidenyos:
        lista_precio.append(regalo["precio"])

    print(f"El promedio de los regalos es {sum(lista_precio)/len(lista_precio)}")

# ej_5_b(regalos_navidenyos)

def ej_5_c(regalos_navidenyos,dinero):

    lista_nombre = []
    lista_precio = []
    if dinero < regalos_navidenyos[0]["precio"]:
        print("No podre comprar nada")
        print(f"Me voy a gastar {sum(lista_precio)}")
        exit()

    for regalo in regalos_navidenyos:
        if dinero > regalo["precio"]:
            lista_nombre.append(regalo["nombre"])
            dinero = dinero - regalo["precio"]
            lista_precio.append(regalo["precio"])

    if len(lista_nombre) != 0:
        print(f"Podre comprar {lista_nombre}")

    print(f"Me voy a gastar {sum(lista_precio)}")

ej_5_c(regalos_navidenyos,100)
