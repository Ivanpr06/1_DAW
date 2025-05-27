package org.example.demo4;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Vehiculo {

    private String matricula;
    private String descripcion;
    private String marca;
    private Integer kilometros;
    private Integer precio;

    public Vehiculo() {
    }

    public Vehiculo(String matricula, String descripcion, String marca, Integer kilometros, Integer precio) {
        this.matricula = matricula;
        this.descripcion = descripcion;
        this.marca = marca;
        this.kilometros = kilometros;
        this.precio = precio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getKilometros() {
        return kilometros;
    }

    public void setKm(Integer kilometros) {
        this.kilometros = kilometros;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return matricula;
    }
}
