def act_1():
    # Creamos una lista para las asignaturas
    lista_asignaturas = ["Informática", "Francés", "Filosofía", "Ética", "Álgebra"]
    # Gracias al bucle (for) cada elemento de la lista puede hacer la accion deseada
    for asignatura in lista_asignaturas:
        # Imprime el mensaje pedido
        print(f"Yo estudio {asignatura}")


def act_2():
    a = [1, 2, 3]
    b = [-1, 0, 2]
    product = 0
    # El fallo estaba en el +1 porque no se puede sumar un entero (int) en una lista y al quitarlo se soluciona
    for i in range(len(a)):
        product += a[i-1] * b[i-1]
    print("El producto de los vectores " + str(a) + " y " + str(b) + " es " + str(product))


def act_3():
    def count_words(text):

        text = text.split()
        words = {}
        for i in text:
            if i in words:
                # El error estaba en el 2 porque usaba este número para contar las veces que sale y por eso era el doble
                words[i] += 1
                # El error estaba en el 2 porque usaba este número para contar las veces que sale y por eso era el doble
            else:
                words[i] = 1
        return words

    def most_repeated(words):
        max_word = ""
        max_freq = 0
        for word, freq in words.items():
            # El error estaba en el signo porque si no imprimiria la palabra que menos se utiliza que sería el espacio
            if freq < max_freq:
                max_word = word
                max_freq = freq
        return max_word, max_freq

    text = "Como quieres que te quiera si el que quiero que me quiera no me quiere como quiero que me quiera"
    print(count_words(text))
    print(most_repeated(count_words(text)))



def act_4():
    contrasenya = "12345EDD"
    confirma_contrasenya = input("Introduce contraseña: ")  # Preguntamos al usuario por la contraseña
    while confirma_contrasenya != contrasenya:  # Con el bucle hacemos que el programa no pare de preguntar por la contraseña hasta que sea correcta
        print("Contraseña erronea")
        confirma_contrasenya = input("Introduce de nuevo la contraseña: ")
    if confirma_contrasenya == contrasenya:    # Si se introduce la contraseña bien gracias al if se dara el visto bueno
        print("Contraseña Correcta !!!!!")

def act_5():
    frase = input("Introduce frase: ")
    letra = input("Introduce letra: ")
    contador = 0
    for i in frase:
        if i == letra:  # El error estaba en la función porque contaba las palabras que NO estaba en la frase (!=)
            contador += 1   # El error estaba en que al ser el contador 2 la letra al aparecer sumaria más de lo que aparezca
    print("La letra '%s' aparece %2i veces en la frase '%s''." % (letra, contador, frase))


def act_6():
    a = ((1, 2, 3), (4, 5, 6))
    b = ((-1, 0), (0, 1), (1, 1))
    result = [[0, 0], [0, 0]]
    for i in range(len(a)):
        for j in range(len(b[0])):
            for k in range(len(b)):
                result[i][j] += a[j][j] * b[j][i]
    for i in range(len(result)):
        result[i] = tuple(result[i])
    result = tuple(result)
    for i in range(len(result)):
        print(result[i])
act_6()


