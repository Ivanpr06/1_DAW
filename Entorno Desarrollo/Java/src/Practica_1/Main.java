package Practica_1;

public class Main {
    public static void main(String[] args) {
        Punto p = new PuntoImpl(2,3);

        System.out.println("El valor de x es: " + p.getX());
        System.out.println("El valor de y es: " + p.getY());
        p.setX(7);
        System.out.println("El valor de x es: " + p.getX());
        System.out.println(p);
    }
}
