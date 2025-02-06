package Practica_1;

// Imp = Implementación
public class PuntoImpl implements Punto {
    // Estructura

    // 1º atributos
    // Si no se especifica la variable siempre será privado
    private Integer x;
    public Integer y;

    // 2º constructor
    // Te permite acceder a los datos en Práctica_1.Main
    public PuntoImpl(Integer x1, Integer y1) {
        x = x1;
        y = y1;
    }

    // 3º consultables y modificables
    // metodos getters y setters
    // get - consultable de x
    public Integer getX() {
        return x;
    }

    // set - modificable de x
    // x1 nos evita poner this.x = x
    public void setX(Integer x1) {
        x = x1;
    }

    // get - consultable de y
    public Integer getY() {
        return y;
    }

    // set - modificable de y
    // x1 nos evita poner this.y = y
    public void setY(Integer y1) {
        x = y1;
    }

    // 4º toString()
    public String toString() {
        return "El valor de p es (" + getX() + "," + getY()+ ")";
    }


}
