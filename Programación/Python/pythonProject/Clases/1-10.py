# CREAR LISTA

def num():
    lista_num = [3, 4, 5, 6, 7]
    elemento = lista_num[2]     # Así no se ven los corchetes
    print(elemento)


def letra():
    lista_num = [3, 435, 5312, 689, 74]
    letras = ["a", "b", "c", "d"]
    elemento = letras[2]
    print(elemento)

    letras.append("e")  # Se usa para añadir un elemento a una lista
    letras[0] = "A"     # Se usa para sustituir elementos a una lista
    letras.append("f")
    letras.extend(["g", "h"])   # Se usa para añadir varios elementos a una lista
    print(letras[0])

    letras.append("b")
    letras.remove("b")  # remove sirve para eliminar lo que tu digas pero hay que poner lo que sea y no la posición
    print(letras)
    print(lista_num)
    lista_num.sort()    # Ordena la lista de menor a mayor
    lista_num.sort(reverse=True)    # Ordena la lista de mayor a menor
    print(lista_num)
    sublista = letras[2:5]
    print(sublista)
    sublista2 = letras[::2]     # Da saltos, en este caso de 2 en 2
    print(sublista2)


def compleja():
    lista_compleja = [[1, 4, 5], [5, 6, 7], [7, 8, 9]]
    print(lista_compleja[0][1])   # En una lista dentro de otra lista hay q especificar doblemente
    for letra in lista_compleja:
        print(letra)
compleja()



