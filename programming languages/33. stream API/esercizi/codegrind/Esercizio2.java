
import java.util.Arrays;
import java.util.List;

// Utilizzare le Stream API per mappare una lista di stringhe alla loro lunghezza.

public class Esercizio2 {
    public static void main(String[] args) {
        List<String> listaStringhe = Arrays.asList("ciao", "come", "va");
        List<Integer> listaLunghezze = listaStringhe.stream().map(String::length).toList();

        for (Integer n : listaLunghezze) {
            System.out.println(n);
        }
    }
}
