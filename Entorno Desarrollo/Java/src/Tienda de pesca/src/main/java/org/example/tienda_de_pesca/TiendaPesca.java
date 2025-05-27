package org.example.tienda_de_pesca;

import java.util.Date;

public class TiendaPesca {

    public String modelo;
    public String color;
    public String ojos;
    public String referencia;
    public String tamano;
    public String navegavilidad;
    public Integer peso;
    public String disponibildad;
    public Integer pvp;
    public Date fecha;

    public TiendaPesca(String modelo, String color, String ojos, String referencia, String tamano, String navegavilidad, Integer peso, String disponibildad, Integer pvp, Date fecha) {
        this.modelo = modelo;
        this.color = color;
        this.ojos = ojos;
        this.referencia = referencia;
        this.tamano = tamano;
        this.navegavilidad = navegavilidad;
        this.peso = peso;
        this.disponibildad = disponibildad;
        this.pvp = pvp;
        this.fecha = fecha;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOjos() {
        return ojos;
    }

    public void setOjos(String ojos) {
        this.ojos = ojos;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getNavegavilidad() {
        return navegavilidad;
    }

    public void setNavegavilidad(String navegavilidad) {
        this.navegavilidad = navegavilidad;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getDisponibildad() {
        return disponibildad;
    }

    public void setDisponibildad(String disponibildad) {
        this.disponibildad = disponibildad;
    }

    public Integer getPvp() {
        return pvp;
    }

    public void setPvp(Integer pvp) {
        this.pvp = pvp;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
