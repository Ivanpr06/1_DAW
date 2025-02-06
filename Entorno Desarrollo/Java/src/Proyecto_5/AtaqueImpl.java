package Proyecto_5;

public class AtaqueImpl implements Ataque {

    // Atributos
    private String NombreAtaque;
    private Integer Danyo;

    //Constructor
    public AtaqueImpl(String nombreAtaque, Integer danyo) {
        NombreAtaque = nombreAtaque;
        Danyo = danyo;
    }

    // Get && Set
    public String getNombreAtaque() {
        return NombreAtaque;
    }

    public void setNombreAtaque(String nombreAtaque) {
        NombreAtaque = nombreAtaque;
    }

    public Integer getDanyo() {
        return Danyo;
    }

    public void setDanyo(Integer danyo) {
        Danyo = danyo;
    }

    // ToString
    @Override
    public String toString() {
        return NombreAtaque + ", " + Danyo;
    }
}
