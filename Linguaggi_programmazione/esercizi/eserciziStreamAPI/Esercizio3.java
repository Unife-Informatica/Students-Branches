import java.util.Arrays;
import java.util.List;

public class Esercizio3 {
 public static void main(String[] args) {
    List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5);
    int somma = numeri.stream()
                      .reduce(0, Integer::sum);
    System.out.println(somma);
 } 
}
