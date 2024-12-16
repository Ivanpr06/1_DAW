# EJERCICIOS 1
def ej_1(num1, num2, num3):
    if num1 > num2 and num1 > num3:
        print("El número mayor es", num1)
    elif num2 > num1 and num2 > num3:
        print("El número mayor es", num2)
    elif num3 > num1 and num3 > num2:
        print("El número mayor es", num3)
    else:
        print("Los números son iguales")


# EJERCICIO 2
def ej_2(word):
    if len(word) <= 8:
        print("Tu palabra tiene menos de 8 caracteres")
    elif word == "":
        print("Tu palabra no tiene nada")
    else:
        print(word)


# EJERCICIO 3
def ej_3(word1, word2, word3, word4):
    if len(word1) > len(word2) and len(word1) > len(word3) and len(word1) > len(word4):
        print("La palabra más larga es", word1)
    elif len(word2) > len(word1) and len(word2) > len(word3) and len(word2) > len(word4):
        print("La palabra más larga es", word2)
    elif len(word3) > len(word1) and len(word3) > len(word2) and len(word3) > len(word4):
        print("La palabra más larga es", word3)
    elif len(word4) > len(word1) and len(word4) > len(word2) and len(word4) > len(word3):
        print("La palabra más larga es", word4)
    else:
        print("Son igual de largas")

    if len(word1) < len(word2) and len(word1) < len(word3) and len(word1) < len(word4):
        print("La palabra más corta es", word1)
    elif len(word2) < len(word1) and len(word2) < len(word3) and len(word2) < len(word4):
        print("La palabra más corta es", word2)
    elif len(word3) < len(word1) and len(word3) < len(word2) and len(word3) < len(word4):
        print("La palabra más corta es", word3)
    elif len(word4) < len(word1) and len(word4) < len(word2) and len(word4) < len(word3):
        print("La palabra más corta es", word4)
    else:
        print("Son igual de cortas")


# EJERCICIO 4
def ej_4(num1, num2, num3, num4, num5):
    if num1 % num5 == 0:
        print("El", num1, "se puede dividir por", num5)
    else:
        print("El", num1, "no se puede dividir por", num5)

    if num2 % num5 == 0:
        print("El", num2, "se puede dividir por", num5)
    else:
        print("El", num2, "no se puede dividir por", num5)

    if num3 % num5 == 0:
        print("El", num3, "se puede dividir por", num5)
    else:
        print("El", num3, "no se puede dividir por", num5)

    if num4 % num5 == 0:
        print("El", num4, "se puede dividir por", num5)
    else:
        print("El", num4, "no se puede dividir por", num5)

    if num5 % num5 == 0:
        print("El", num5, "se puede dividir por", num5)
    else:
        print("El", num1, "no se puede dividir por", num5)


# EJERCICIO 5

def ej_5(word1, word2, word3):
    if word1.count("a" or "e" or "i" or "o" or "u" ) > 3:
        print(word1)
    else:
        print(word1,"no tiene 3 vocales")

    if word2.count("a" or "e" or "i" or "o" or "u" ) > 3:
        print(word2)
    else:
        print(word2, "no tiene 3 vocales")

    if word3.count("a" or "e" or "i" or "o" or "u" ) > 3:
        print(word3)
    else:
        print(word3, "no tiene 3 vocales")
