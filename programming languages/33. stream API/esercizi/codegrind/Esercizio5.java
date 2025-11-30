
import java.util.Arrays;
import java.util.List;

// Utilizzare le Stream API per ottenere una lista di numeri distinti.

public class Esercizio5 {

    public static void main(String[] args) {
        List<Integer> listaNumeri = Arrays.asList(1, 4, 66, 3, 4, 21, 3, 4);
        List<Integer> distinctList = listaNumeri.stream().distinct().toList();

        for (Integer n : distinctList) {
            System.out.println(n);
        }
    }
}
