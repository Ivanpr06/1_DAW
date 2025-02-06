package Tareas;

import java.util.Scanner;

class HolaMundo {
    public static void main(String[] args) {
        System.out.println("Esto no imprime hola mundo");
    }
}

class TiposDeDatos{
    public static void main(String[] args) {
        int edad = 96;
        double estatura = 1.52;
        char inicial = 'J';
        boolean estudinate = false;
        String nombre = "Jose Facundo";

        System.out.println("Edad : " + edad);
        System.out.println("Estatura : " + estatura);
        System.out.println("Inicial : " + inicial);
        System.out.println("¿Estudinate? : " + estudinate);
        System.out.println("Nombre : " + nombre + " tiene " + edad);
    }
}

class OperacionesMatematicas{
    public static void main(String[] args) {
        double num1 = 20;
        double num2 = 10;

        System.out.println("Suma : " + (num1 + num2));
        System.out.println("Resta :" + (num1 - num2));
        System.out.println("Multiplicacion : " + (num1 * num2));
        System.out.println("Division : " + (num1 / num2));
        System.out.println("Modulo : " + (num2 % num1));

    }
}

class EstructurasControl{
    public static void main(String[] args) {
        int numero = - 5;

        if (numero > 0) {
            System.out.println("El número es positivo");
        }else if (numero < 0) {
            System.out.println("El número es negativo");
        }else{
            System.out.println("El número es 0");
        }

       int contador = 0;
        while ( contador <= 10){
            System.out.println(contador);
            contador++;
        }
    }
}

class Metodos{
    public static void main(String[] args) {
        int resultado = sumar(10,5);
        System.out.println(resultado);
        System.out.println("El resultado es: " + esPar(10));
    }

    public static int sumar(int num1, int num2){
        return num1 + num2;
    }

    public static boolean esPar(int numero){
        if (numero % 2 == 0){
            return true;
        }else{
            return false;
        }
    }
}

class EntradaUsuario{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Ingrese el edad: ");
        int edad = sc.nextInt();

        System.out.println("Hola, " + nombre + " tienes " + edad);
    }
}

class SumaEntradaUsusario{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un número: ");
        int num1 = sc.nextInt();

        System.out.println("Ingrese otro número: ");
        int num2 = sc.nextInt();

        System.out.println("El resultado es: " + (num1 + num2));
    }
}

class SaludoPersonalizado{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();

        System.out.println("¡Hola, " + nombre + " ! Bienvenido a Java");
    }
}

class ConversionTemperaturas{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la temperatura en Celsius: ");
        double Celsius = sc.nextDouble();

        double Fahrenheit = Celsius * (9/5) + 32;

        System.out.println("El temperatura es: " + Fahrenheit);
    }
}

class OperacionesDecimales{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el radio: ");
        double radio = sc.nextDouble();

        double area = Math.PI * Math.pow(radio, 2);
        System.out.println("El área es: " + area);
    }
}

class NumeroMayor{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el numero: ");
        int numero1 = sc.nextInt();

        System.out.print("Ingrese otro numero: ");
        int numero2 = sc.nextInt();

        if (numero1 > numero2){
            System.out.println("El numero mayor es: " + numero1);
        }else if (numero1 < numero2){
            System.out.println("El numero mayor es: " + numero2);
        }else{
            System.out.println("Los numeros son iguales");
        }
    }
}

class Factorial{
    public static void main(String[] args) {
        System.out.println("El factorial es :" + calcularFactorial());
        System.out.println(fact(3));
    }

    public static int calcularFactorial() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el numero: ");
        int numero = sc.nextInt();
        int factorial = 1;

        for (int i = numero; i != 1; i--) {
             factorial *=  i;
        }
        return factorial;
    }

    public static int fact(int num){

        if(num==1){
            return 1;
        }else{
            return num*fact(num-1);
        }

    }
}


class Promedio{
    public static void main(String[] args) {
        Scanner num1 = new Scanner(System.in);
        System.out.print("Ingrese el primer numero: ");
        double numero1 = num1.nextInt();

        System.out.print("Ingrese el segundo numero: ");
        double numero2 = num1.nextInt();

        System.out.print("Ingerese el tercer numero: ");
        double numero3 = num1.nextInt();

        float promedio = (float) ((numero1 + numero2 + numero3) / 3);
        System.out.println("El promedio es: " + promedio);
    }






}