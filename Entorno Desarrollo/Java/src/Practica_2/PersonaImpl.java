package Practica_2;

public class PersonaImpl implements Persona {
    // Atributos

    private String nombre;
    private String apellido1;
    private String apellido2;
    private Integer edad;
    private String dni;

    // Constructor
    public PersonaImpl(String nombre_piloto, String apellido1_piloto, String apellido2_piloto,String dni_piloto, Integer edad_piloto) {
        nombre = nombre_piloto;
        apellido1 = apellido1_piloto;
        apellido2 = apellido2_piloto;
        edad = edad_piloto;
        dni = dni_piloto;

    }

    // Consultable y Modificable

    public String getNombrePiloto() {return nombre;}
    public void setNombrePiloto(String nombre_piloto) {nombre = nombre_piloto;}
    public String getApellido1Piloto() {return apellido1;}
    public void setApellido1Piloto(String apellido1_piloto) {apellido1 = apellido1_piloto;}
    public String getApellido2Piloto() {return apellido2;}
    public void setApellido2Piloto(String apellido2_piloto) {apellido2 = apellido2_piloto;}
    public Integer getEdadPiloto() {return edad;}
    public void setEdadPiloto(Integer edad_piloto) {edad = edad_piloto;}
    public String getDniPiloto() {return dni;}


    // ToString
    public String toString() {return getNombrePiloto() + " " + getApellido1Piloto() + " " + getApellido2Piloto() +", " + getDniPiloto() + ", " + getEdadPiloto() + " años";}
}
