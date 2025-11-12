import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listaCollegata = new LinkedList<>();

        // Le liste collegate usano gli stessi parametri delle liste aggiungendo:
        // - addFirst()
        // - addLast()
        // - removeFirst()
        // - removeLast()
        // - getFirst()
        // - getLast()
        listaCollegata.addLast(2);
        listaCollegata.addFirst(3);

        for(Integer i : listaCollegata) {
            System.out.println(i);
        }
    }
}
