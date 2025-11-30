
import java.util.Arrays;
import java.util.List;

// Utilizzare le Stream API per filtrare una lista di numeri e ottenere solo i numeri pari.

public class Esercizio1 {

    public static void main(String[] args) {
        List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numeriPari = numeri.stream().filter(n -> n % 2 == 0).toList();

        System.out.println("Numeri pari: " + numeriPari);
    }
}
