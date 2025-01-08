# Bibliotecas
import requests
from bs4 import BeautifulSoup

#  Obtenemos páguina web
def obtener_url():
    url = "https://www.ufcespanol.com/athletes"
    contenido = requests.get(url)
    return contenido

# Convertimos el html en una sopa
def convertir_sopa():
    contenido = obtener_url()
    sopa = BeautifulSoup(contenido.content, "html.parser")
    return sopa

# Empezamos el web scraping
def realizar_web_scraping():
    sopa = convertir_sopa()
    lista_peleadores = []
    # Hacemos nuestra biblioteca
    peleadores = {
        "nombre": "",
        "apodo": "",
        "foto": "",
        "division": "",
        "record": "",
        "ultima_pelea": "",
    }
    # Contenedor principal
    contenedores = sopa.find_all("div", {"class": "athlete-titleholder-wrp"})

    # Empezamos bucle
    for contenedor in contenedores:
        # Copiamos los datos em la lista
        nueva_lista = peleadores.copy()
        # Nombre peleador
        nombre_peleador = contenedor.find("div", {"class": "ath-n ath-lf-fl"}).text.replace("\n", "")
        nueva_lista["nombre"] = nombre_peleador
        # Apodos peleador
        if contenedor.find("div", {"class": "field field--name-nickname field--type-string field--label-hidden"}) is not None:
            apodo_peleador = (contenedor.find("div", {"class": "field field--name-nickname field--type-string field--label-hidden"}).text
            .replace("\n", ""))
            nueva_lista["apodo"] = apodo_peleador
        # Foto peleador
        foto_peleador = contenedor.find("div", {"class": "atm-thumbnail"}).img["src"]
        nueva_lista["foto"] = foto_peleador
        # División peleador
        division_peleador = contenedor.find("div", {"class": "ath-wlcass"}).text
        nueva_lista["division"] = division_peleador
        # Record peleador
        record_peleador = contenedor.find("div", {"class": "ath--records ath-lf-fl"}).text.replace("\n", "").strip()
        nueva_lista["record"] = record_peleador
        # Última pelea peleador
        ultima_pelea_peleador = (contenedor.find("div", {"class": "ath-lf ath-lf-fl"}).text.replace("\n", "").replace("Última pelea:","").strip())
        nueva_lista["ultima_pelea"] = ultima_pelea_peleador
        # Añadimos valores en lista
        lista_peleadores.append(nueva_lista)

    return lista_peleadores
# Imprimir lista





