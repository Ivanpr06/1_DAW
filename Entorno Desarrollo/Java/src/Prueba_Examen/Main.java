package Prueba_Examen;

public class Main {
    public static void main(String[] args) {
        Festivo festivo = new FestivoImpl("Feria de Sevilla", "abril");
        Poblacion poblacion = new PoblacionImpl("Sevilla", 1942389, 14036, 100000, 5000, festivo);

        System.out.println(poblacion);
    }
}


