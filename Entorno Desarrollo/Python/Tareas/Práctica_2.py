def ej_1():
    password = input("Introduce la contraseña: ")
    if password in ("sesamo"):
        print('Pasa')
    else:
        print("No pasa")

def ej_2():
    def aplica_iva(base):
        iva = 21
        base = base + (base * iva / 100)
        print(base)
        return base

    base = int(input('Introduce la base imponible de la factura: '))
    aplica_iva(base)

def ej_3():
    u = (1, 2, 3)
    v = (4, 5, 6)
    def producto_escalar(u, v):
        producto = 0
        for i in range(len(u)):
            producto += u[i+1] * v[i+1]
        return producto
    print(producto_escalar(u, v))

def ej_4():
    listin = {'Juan': 123456789, 'Pedro': 987654321}

    def elimina(listin, usuario):
        del listin[usuario]
        return listin
    print(elimina(listin, 'Pedro'))

def ej_5():
    a = ((1, 2, 3),
         (3, 2, 1))

    b = ((1, 2),
         (3, 4),
         (5, 6))

    def producto(a, b):
        producto = []
        for i in range(len(a)):
            fila = []
            for j in range(len(b[0])):
                suma = 0
                for k in range(len(a[0])):
                    suma += a[i][k] * b[k][j]
                fila.append(suma)
            producto.append(tuple(fila))
        return tuple(producto)
    print(producto(a, b))

def ej_6():
    def procesar_datos(datos):
        resultados = []
        for dato in datos:
            if dato > 0:
                resultados = dato * 2
            elif dato == 0:
                resultados = 0
            else:
                resultados = abs(dato / 2)
                resultados.append(dato)
                promedio = sum(resultados) / len(datos)
                return promedio, resultados
    lista_datos = [10, -3, 0, 5, 'a', -8]
    promedio, resultados = procesar_datos(lista_datos)
    print("Promedio de los resultados:", promedio)
    print("Lista de resultados procesados:", resultados)

ej_6()