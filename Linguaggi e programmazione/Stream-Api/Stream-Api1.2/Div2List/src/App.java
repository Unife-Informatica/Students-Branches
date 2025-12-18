import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        Set<Integer> risultato = numbers.stream().map(n->n/2).collect(Collectors.toSet());
        System.out.println(risultato);
    }
}
