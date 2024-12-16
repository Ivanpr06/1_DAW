# CONDICIONALES

# Método comparación si dos números sean iguales
def comparar_numeros(numero1, numero2): #Recuerda poner los valores en el def
    if numero1 == numero2:
        print("Los números son iguales")
    else:
        print("Los números son diferentes")


# Función para ver si un número es mayor que otro
def dame_el_num_mayor(numero1, numero2):
    if numero1 > numero2:
        print(numero1, "es mayor que",numero2)
    elif numero1 < numero2:
        print(numero1, "es menor que",numero2)
    else:
        print("Los números son iguales")


# LISTAS
def hacer_lista():
    lista = ["manzana", "plátano", "sandía", "melón"]
    print(lista[1:3]) #Sirve para buscar la ubicación   #[n:n] --> desde el número n hasta el otro número
    print(lista[::-1]) # ::n --> del principio hace un salto n y con -1 invierte lista
hacer_lista()

