package Refactorizacion.Ej_2;

/**
 *
 * @author Ivan
 * @version 1.0
 */

public class Player {
    int x, y;

    /**
     * Es el constructor
     * @param x indiccion de las coordenadas horizontales
     * @param y indiccion de las coordenadas verticales
     */
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}