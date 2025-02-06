package Modelos;

import java.util.Objects;

public class Cliente extends Persona {

    TipoCliente tipoCliente;

    // Constructor
    public Cliente() {
    }

    public Cliente(Integer identificador, String dni, String nombre, String apellidos, String direccion, TipoCliente tipoCliente) {
        super(identificador, dni, nombre, apellidos, direccion);
        this.tipoCliente = tipoCliente;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }


    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return tipoCliente == cliente.tipoCliente;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), tipoCliente);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", tipoCliente=" + tipoCliente +
                '}';
    }

}

