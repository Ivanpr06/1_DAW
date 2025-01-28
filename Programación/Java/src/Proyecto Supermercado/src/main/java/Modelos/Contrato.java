package Modelos;

import java.awt.*;
import java.util.Objects;

public class Contrato {

    Integer identificacion;
    Double salarioBase;
    TipoContrato tipoContrato;

    public Contrato() {
    }

    public Contrato(Integer identificacion, Double salarioBase, TipoContrato tipoContrato) {
        this.identificacion = identificacion;
        this.salarioBase = salarioBase;
        this.tipoContrato = tipoContrato;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "identificacion=" + identificacion +
                ", salarioBase=" + salarioBase +
                ", tipoContrato=" + tipoContrato +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return Objects.equals(identificacion, contrato.identificacion) && Objects.equals(salarioBase, contrato.salarioBase) && tipoContrato == contrato.tipoContrato;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificacion, salarioBase, tipoContrato);
    }
}
