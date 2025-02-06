package Prueba_Examen;

public class PoblacionImpl implements Poblacion {

    private String nombre;
    private Integer numhabitantes;
    private Integer superficie;
    private Integer personastrabajando;
    private Integer personasempleadas;
    private Festivo festivo;

    public PoblacionImpl(String nombre, Integer numhabitantes, Integer superficie, Integer personastrabajando, Integer personasempleadas, Festivo festivo) {
        this.nombre = nombre;
        this.numhabitantes = numhabitantes;
        this.superficie = superficie;
        this.personastrabajando = personastrabajando;
        this.personasempleadas = personasempleadas;
        this.festivo = festivo;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNumhabitantes() {
        return numhabitantes;
    }

    @Override
    public void setNumhabitantes(String numhabitantes) {

    }

    public Integer getSuperficie() {
        return superficie;
    }

    @Override
    public void setSuperficie(Integer superficie) {

    }

    public Integer getPersonastrabajando() {
        return personastrabajando;
    }

    @Override
    public void setPersonastrabajadando(Integer personasTrabajadando) {

    }

    public Integer getPersonasempleadas() {
        return personasempleadas;
    }

    public Festivo getFestivo() {
        return festivo;
    }


    @Override
    public void setPersonasempleadas(Integer personasempleadas) {
        this.personasempleadas = personasempleadas;
    }

    @Override
    public void setFestivo(Festivo festivo) {
        this.festivo = festivo;
    }

    public Double getPorcentajeDesempleo(){
        return ((getNumhabitantes() - getPersonasempleadas()) / getPersonasempleadas()) * 100.0;
    }

    public Double getDensidad(){
        return (double) (getNumhabitantes()/getSuperficie());
    }

    @Override
    public String toString() {
        return getNombre() + " posee una densidad de población de " + getDensidad() + " hab/km2. Una de sus fiestas más famosas es la " + getFestivo();
    }
}
