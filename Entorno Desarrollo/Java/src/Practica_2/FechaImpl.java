package Practica_2;

public class FechaImpl implements Fecha {

    // Atributo
    private Integer dia;
    private Integer mes;
    private Integer anyo;

    // Constructor
    public FechaImpl(Integer dia_plaza, Integer mes_plaza, Integer anyo_plaza) {
        dia = dia_plaza;
        mes = mes_plaza;
        anyo = anyo_plaza;
    }

    // Consultables y Modificables
    public Integer getDia() {return dia;}
    public Integer getMes() {return mes;}
    public Integer getAnyo() {return anyo;}

    // ToString

    public String toString() {return getDia()+"/"+ getMes() +"/"+getAnyo();}

}
