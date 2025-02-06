
def ej_2():
   lista_vacia = []
   lista_numeros = [4.5, 6, 10.3, 12.4, 15.0, 18, 24]

   for numero in lista_numeros:
      if numero % 2 == 0 and numero % 3 == 0 and numero.is_integer():
         lista_vacia.append(numero)
   print(lista_vacia)



def ej_4():
   lista_palabras = ["hola", "como", "estas"]
   lista_numeros = [3, 1, 1]
   print(lista_palabras[0] * lista_numeros[0])
   print(lista_palabras[1] * lista_numeros[1])
   print(lista_palabras[2] * lista_numeros[2])
ej_4()
