package Practica_3;

public class Main {
    public static void main(String[] args) {
        Fecha fecha = new FechaImpl(2,12,2009);
        Cancion cancion = new CancionImpl("Que rica tu estas", "Manolo", 120, fecha,"Rap", 10000000, 10.00, true);

        System.out.println(cancion);
        System.out.println(fecha);
    }
}
