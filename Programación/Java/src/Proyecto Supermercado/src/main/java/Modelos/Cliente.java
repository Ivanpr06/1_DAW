package Modelos;

import java.util.Objects;

public class Cliente {

    Integer identificador;
    String dni;
    String nombre;
    String apellidos;
    String direccion;
    Enum TipoCliente;

    // Constructor
    public Cliente() {
    }

    public Cliente(Integer identificador, String dni, String nombre, String apellidos, String direccion, Enum tipoCliente) {
        this.identificador = identificador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        TipoCliente = tipoCliente;
    }

    // Get and Set
    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Enum getTipoCliente() {
        return TipoCliente;
    }

    public void setTipoCliente(Enum tipoCliente) {
        TipoCliente = tipoCliente;
    }

    // ToString
    @Override
    public String toString() {
        return "Cliente{" +
                "identificador=" + identificador +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", TipoCliente=" + TipoCliente +
                '}';
    }

    // Equals and Hashcode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(identificador, cliente.identificador) && Objects.equals(dni, cliente.dni) && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellidos, cliente.apellidos) && Objects.equals(direccion, cliente.direccion) && Objects.equals(TipoCliente, cliente.TipoCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, dni, nombre, apellidos, direccion, TipoCliente);
    }
}
