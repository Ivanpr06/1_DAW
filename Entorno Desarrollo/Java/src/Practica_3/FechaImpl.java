package Practica_3;

public class FechaImpl implements Fecha {

    private Integer dia;
    private Integer mes;
    private Integer anyo;

    // Constructor
    public FechaImpl(Integer dia, Integer mes, Integer anyo) {
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }

    // Get
    public Integer getDia() {
        return dia;
    }

    public Integer getMes() {
        return mes;
    }

    public Integer getAnyo() {
        return anyo;
    }

    //toString

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anyo;
    }
}
