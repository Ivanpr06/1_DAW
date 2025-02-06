package Prueba_Examen;

public class FestivoImpl implements Festivo {

    private String nombreFiesta;
    private String mes;

    public FestivoImpl(String nombreFiesta, String mes) {
        this.nombreFiesta = nombreFiesta;
        this.mes = mes;
    }

    public String getnombreFiesta() {
        return nombreFiesta;
    }

    public String getmes() {
        return mes;
    }

    public void setmes(String mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return getnombreFiesta() + " , en " + getmes() ;
    }
}
