import java.util.List;

public class Uso_Stream {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(getPares(numeros));
    }
    public static List<Integer> getPares(List<Integer> numeros) {
        return numeros.stream().filter(num -> num % 2 == 0).toList();

    }
}
