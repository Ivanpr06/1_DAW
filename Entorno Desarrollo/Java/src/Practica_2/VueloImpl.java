package Practica_2;

public class VueloImpl implements Vuelo {

    // Atributos
    private String codigo;
    private String destino;
    private Double precio;
    private Integer num_plazas;
    private Integer num_pasajeros;
    private Persona piloto;
    private Fecha fecha;



    // Constructor
    public VueloImpl(String cod, String dest, Persona pilot, Fecha f) {
        codigo = cod;
        destino = dest;
        piloto = pilot;
        fecha = f;
    }


    // Consultables y Modificables

    public String getCodigo() {return codigo;}
    public String getDestino() {return destino;}
    public Double getPrecio() {return precio;}
    public void setPrecio(Double p) {precio = p;}
    public Integer getNumPlazas() {return num_plazas;}
    public Integer getNumPasajeros() {return num_pasajeros;}
    public void setNumPasajeros(Integer pasajeros) {num_pasajeros = pasajeros;}
    public Persona getPersona() {return piloto;}
    public void setPersona(Persona pilot) {piloto = pilot;}
    public Fecha getFecha() {return fecha;}
    public Double recaudacion() {return precio*num_pasajeros;}

    // ToString
    public String toString() {return getCodigo() + " (" + getDestino() + ") - " + getPersona() + " " + getFecha() ;}

}