
import java.util.Arrays;
import java.util.List;

// Utilizzare le Stream API per calcolare la somma di una lista di numeri interi.

public class Esercizio3 {

    public static void main() {
        List<Integer> listaNumeri = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int somma = listaNumeri.stream().reduce(0, Integer::sum);

        System.out.println(somma);
    }
}
