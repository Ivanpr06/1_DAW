package Refactorizacion.Ej_1;

public class Persona {
   String nombre;
   Integer edad;
    String numeroDeTelefono;

    public Persona(String numeroDeTelefono) {
        super();
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }
}

