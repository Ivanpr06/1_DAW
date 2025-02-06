# BUCLE

lista = ["perro", "gato", "cerdo", "león", "tigre", "delfín", "rata"]

def bucle():
    for animal in lista:
        if len(animal) == 4:
            print(animal)

# i lo pones para poder contar del 15 al 35, es una varibale indefinida
def bucle_muchas_veces():
    for i in range(15, 35):  # in range se usa para repetir( cuidado que repite del 15 al 34 porq cuenta el 0 )
        print(i)

# Bucle que separa las letras
def caballo_letra_por_letra():
    for letra in "caballo":
        print(letra)


# Bucle para detectar números(Hay que tener cuidado con la posiciones)
def comprobar_contraseña(contrasenya):

    caracteres_obligatorios = ".-*"
    contador_digitos = 0
    contador_letras_especiales = 0

    for letra in contrasenya:
        if letra.isdigit():  # isdigit = dice si en la palabra hay números
            contador_digitos += 1
        if letra in caracteres_obligatorios:
            contador_letras_especiales += 1

    if contador_digitos == 2 and len(contrasenya) >= 8 and contador_letras_especiales >= 1:
        print("Contraseña correcta")
    else:
        print("Contraseña erronea")

# Se puede comprobar varias simplemente copiando comprobar_contraseña
comprobar_contraseña("aqua23-pol")
