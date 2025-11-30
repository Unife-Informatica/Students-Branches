
import java.util.Arrays;
import java.util.List;

// Utilizzare le Stream API per ordinare una lista di stringhe in ordine alfabetico.

public class Esercizio4 {
    public static void main(String[] args) {
        List<String> listaStringhe = Arrays.asList("a", "c", "b");
        List<String> listaOrdinata = listaStringhe.stream().sorted().toList();

        for(String s : listaOrdinata) {
            System.out.println(s);
        }
    }
}
