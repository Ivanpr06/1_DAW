#Creación de Variables
def variables():
    variable1 = "Luis"
    variable2 = 12
    variable3 = 35.12
#Operadores
    suma = variable3 + variable2
    resta = variable3 - variable2
    multiplicacion = variable3 * variable2
    dividir = variable3 / variable2
    par = variable3 % variable2   #Cuidao porque % es para dividir pero te da el resto


#Conversiones
def conversiones():
    #Texto
    texto_1 = "Hola"
    texto_2 = "578"
    #Texto --> str
    #Numeros --> int(enteros) o float(decimales)
    #Boleanos --> bool
    print(bool(texto_1))  #Si tiene algo es TRUE sino tiene nada es FALSE

#Operadores Lógicos
def operadores():
    text1 ="Hola"
    text2 ="Hola"
    num1 = 1
    num2 = 2
    print(not (text1 == text2 and num1 == num2)) # not = inversa
    print(text1 != text2)   # != --> No igual

#Funciones
def suma(num_1, num_2):
    print(num_1 + num_2)
    suma(5, 2)

#Cadena
def cadena():
    texto = input("Escribe lo que quieras: ")
    texto_en_mayusculas = texto.upper()
    print(texto_en_mayusculas)

