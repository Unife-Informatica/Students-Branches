
import java.util.Arrays;
import java.util.List;

// Utilizzare le Stream API per contare il numero di elementi in una lista di stringhe che iniziano con una lettera specifica.

public class Esercizio6 {
    public static void main(String[] args) {
        List<String> listaStringhe = Arrays.asList("apple", "banana", "avocado", "cherry", "apricot");
        final String iniziale = "a";

        List<String> listaConIniziale = listaStringhe.stream().filter(s -> s.startsWith(iniziale)).toList();

        for(String s : listaConIniziale) {
            System.out.println(s);
        }
    }
}
