package Practica_2;

public interface Vuelo {
    public String getCodigo();
    public String getDestino();
    public Double getPrecio();
    public void setPrecio(Double precio);
    public Integer getNumPlazas();
    public Integer getNumPasajeros();
    public void setNumPasajeros(Integer numPasajeros);
    public Persona getPersona();
    public Fecha getFecha();
    public void setPersona(Persona pilot);
}
