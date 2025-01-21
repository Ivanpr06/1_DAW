package Aprendizaje;

import java.util.List;

public class Explicacion_intro_java {

    // Funciones (van a fuera del main)
    // Se usa void cuanodo no devuelve nada
    public static void sumar(int numero1, int numero2){
        System.out.println(numero1+numero2);
    }

    // Abreviatura main
    public static void main(String[] args) {
        // Abreviatura sout
        System.out.println("Hola");

        // Tipos de datos

        // Numéros Enteros
        // Python num = 15
        int num = 15;
        // Integer es orientado a objetos y puede tener diferentes funciones
        Integer num2 = 20;

        // Números Decimales
        double num3 = 3.14;
        float num4 = 5.6f;

        // Texto
        String texto = "Hola";
        char letra = 'a';

        // Boleano
        boolean afirmacion = true;
        boolean negacion = false;

        // Variable Vacía
        String palabra;

        // Condicionales
        // && = and
        // || = or
        // ! = not
        if (num != num2 && num != num3 || num != num4) {
        }

        boolean condicion = num > num2;
        if (condicion) {
            System.out.println("Se cumple");
        }else{
            System.out.println("No se cumple");
        }

        // Calificación de notas
        double nota = 7.5;
        if(nota < 5){
            System.out.println("Suspenso");
        }else if(nota <= 7){
            System.out.println("Aprovado");
        }else{
            System.out.println("Muy bien");
        }

        // Enumerado

        Dias_Semana dia = Dias_Semana.Lunes;

        // Es como un if muy específico
        switch (dia) {
            case Lunes -> System.out.println("Inicio semana");
            case Sabado -> System.out.println("Fin semana");
            case Domingo -> System.out.println("Se acaba la semana");
        }

        // Bucle while
        int contador = 10;

        while (contador > 0) {
            System.out.println(contador);
            contador--;
        }

        // Bucle do while (Mínimo se hace una vez el print)
        do{
            System.out.println("Patata");
            contador--;
        }while (contador > 0);

        // Bucle For
        for(int numero = 1; numero <= 10; numero++) {
            System.out.println(numero);
        }

        // Bucle foreach
        // Creación de lista
        List<String> lista = List.of("Lunes", "Martes", "Miercoles");
        for(String diaSemana : lista){
            System.out.println(diaSemana);
        }

    }
}