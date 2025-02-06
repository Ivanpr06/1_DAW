package Practica_3;

public class CancionImpl implements Cancion {

    // Variables
    private String nombre;
    private String interprete;
    private Integer duracion;
    private Fecha fechalanzamineto;
    private String genero;
    private Integer numreproducciones;
    private Double calificacion;
    private Boolean reproducir;

    // Constructor
    public CancionImpl(String nombre, String interprete, Integer duracion, Fecha fechalanzamineto, String genero, Integer numreproducciones, Double calificacion, Boolean reproducir) {
        this.nombre = nombre;
        this.interprete = interprete;
        this.duracion = duracion;
        this.fechalanzamineto = fechalanzamineto;
        this.genero = genero;
        this.numreproducciones = numreproducciones;
        this.calificacion = calificacion;
        this.reproducir = reproducir;
    }

    // Get and Set

    public String getNombre() {
        return nombre;
    }

    public String getInterprete() {
        return interprete;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public Fecha getFechaLanzamiento() {
        return fechalanzamineto;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getNumReproducciones() {
        return numreproducciones;
    }

    public void setNumReproducciones(Integer numreproducciones) {
        this.numreproducciones = numreproducciones;
    }

    public Double getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Boolean getReproducir() {
        return reproducir;
    }

    public void setReproducir(Boolean reproducir) {
        this.reproducir = reproducir;
    }

    //To String
    public String toString() {
        return "[" + nombre + ", " + interprete + "]";
    }
}
