# Bibliotecas
import csv
import pandas as pd     # Escribe un alias
import Web_scrapping as ws  # Importamos nuestro archivo de web scrapping
import mysql.connector as mysql

def construir_csv():
    # Crea una variable para usar nuestro archivo anterior
    lista_datos = ws.realizar_web_scraping()

    # Abrir un archivo
    with open("peleadores.csv", "w", newline="", encoding="utf-8") as archivo_peleadores:
        # Ponemos un escritor
        escritor = csv.writer(archivo_peleadores)
        # Primera línea del diccionario = CLAVES
        escritor.writerow(lista_datos[0].keys())
        # Bucle para escribir el resto de líneas = DATOS
        for peleador in lista_datos:
            escritor.writerow(peleador.values())


def convertir_excel():
    # Lee el archivo
    archivo_csv = pd.read_csv("peleadores.csv")
    # Convertir el archivo al Excel
    archivo_excel = archivo_csv.to_excel("peleadores.xlsx",index = False)





def conectar_base_datos():
    # Ponemos los parametros de MySQL
    parametros = {
        "user": "ivan",
        "password": "naceA2Vj",
        "host": "localhost",
        "database": "peleador",
        "port": 3306,
        "charset": "utf8",
        "collation": "utf8_general_ci",
        "use_unicode": True,
        'autocommit': True
    }


    # Devuelve la conexión de la base de datos
    return mysql.connect(**parametros)



def encontrar_datos():

    # Obtenemos datos
    lista_peleadores = ws.realizar_web_scraping()

    # Abrimos conexion con la base de datos
    conexion = conectar_base_datos()

    # Abrimos el cursor
    cursor = conexion.cursor()

    # Sentencia insert
    script_insercion = "insert into peleadores (nombre,apodo,foto,division,record,ultima_pelea) values(%s,%s,%s,%s,%s,%s)"

    # Creamos bucle para recoger la información de cada peleador
    for peleador in lista_peleadores:
        cursor.execute(script_insercion,(peleador['nombre'],peleador['apodo'],peleador['foto'],peleador['division'],peleador['record'],peleador['ultima_pelea']))

    # Cerramos la conexión con la basa de datos
    conexion.close()


def consultar_base_datos():

    # Abrimos conexión
    conexion = conectar_base_datos()

    # Abrimos cursor
    cursor = conexion.cursor(dictionary=True)   # Nos devuelve la información en formato diccionario

    # Lista de elementos
    lista_peleadores = []

    # Script de consulta
    script_consulta = "select * from peleadores"

    # Ejecutar una consulta
    cursor.execute(script_consulta)

    # Traemos los datos a la consulta
    lista_peleadores = cursor.fetchall()



    # Cerramos conexión
    conexion.close()

    return lista_peleadores



def eliminar_base_datos(id):

    # Abrimos conexión
    conexion = conectar_base_datos()

    # Abrimos conexión
    cursor = conexion.cursor()

    # Script Eliminar
    script_eliminar = "delete from peleadores where id =" + str(id)


    # Ejecutar script
    cursor.execute(script_eliminar)

    # Cerramos conexión
    conexion.close()

def crear_dato(peleador):

    lista_peleadores = ws.realizar_web_scraping()

    # Abrimos conexion con la base de datos
    conexion = conectar_base_datos()

    # Abrimos el cursor
    cursor = conexion.cursor()

    # Sentencia insert
    script_insercion = "insert into peleadores (nombre,apodo,foto,division,record,ultima_pelea) values(%s,%s,%s,%s,%s,%s)"

    # Creamos bucle para recoger la información de cada peleador
    cursor.execute(script_insercion, (peleador['nombre'], peleador['apodo'], peleador['foto'], peleador['division'], peleador['record'],peleador['ultima_pelea']))

    # Cerramos la conexión con la basa de datos
    conexion.close()


