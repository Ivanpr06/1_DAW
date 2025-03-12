package Refactorizacion.Ej_2;

/**
 *
 * @author Ivan
 * @version 1.0
 */

public class Game {
    Player p;

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }

    public void movement(String m) {
        if (m.equalsIgnoreCase("Derecha")) {
            p.setX(p.getX() + 1);
        }
        if (m.equalsIgnoreCase("Izquierda")) {
            p.setX(p.getX() - 1);
        }
        if (m.equalsIgnoreCase("Arriba")) {
            p.setY(p.getY() + 1);
        }
        if (m.equalsIgnoreCase("Abajo")) {
            p.setY(p.getY() - 1);
        }
    }
}