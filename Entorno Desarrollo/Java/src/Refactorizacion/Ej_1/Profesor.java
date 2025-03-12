package Refactorizacion.Ej_1;

import java.util.List;

public class Profesor extends Persona {

    private List<Prestamo> prestamos;

    public Profesor(String numeroDeTelefono){
        super(numeroDeTelefono);
    }

    public void printInformacionPersonal() {
        extracted(numeroDeTelefono);
    }

    private void extracted(String numeroDeTelefono) {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Teléfono: " + numeroDeTelefono);
    }

    public void printTodaLaInformacion() {
        extracted(this.numeroDeTelefono);
        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }
}

