import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long risultato = numeri.stream()
            .filter(n->n%2==0)
            .count();
        System.out.println("Ci sono " + risultato +" numeri pari");
        
    }
}
