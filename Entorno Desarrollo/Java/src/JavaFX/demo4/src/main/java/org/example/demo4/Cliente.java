package org.example.demo4;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cliente {

    private String NIF;
    private String NYA;
    private String Direcion;
    private String Poblacion;

    public Cliente() {
    }

    public Cliente(String NIF, String nYA, String direcion, String poblacion) {
        this.NIF = NIF;
        NYA = nYA;
        Direcion = direcion;
        Poblacion = poblacion;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNYA() {
        return NYA;
    }

    public void setNYA(String nYA) {
        NYA = nYA;
    }

    public String getDirecion() {
        return Direcion;
    }

    public void setDireccion(String direcion) {
        Direcion = direcion;
    }

    public String getPoblacion() {
        return Poblacion;
    }

    public void setPoblacion(String poblacion) {
        Poblacion = poblacion;
    }

    @Override
    public String toString() {
        return NYA;
    }
}
