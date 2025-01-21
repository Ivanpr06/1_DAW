package Practica_2;

public class Main {
    public static void main(String[] args) {
        Fecha fecha = new FechaImpl(4,6,2025);
        Persona piloto = new PersonaImpl("Fernando", "Alonso", "Ponti", "12345678H", 33);
        Vuelo vuelo = new VueloImpl("IB2349", "Madrid", piloto, fecha);

        System.out.println(vuelo);
    }
}
