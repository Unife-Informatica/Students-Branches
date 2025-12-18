import static java.util.Arrays.asList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> strings = asList("Lorem", "ipsum", "dolor", "sit", "amet,", "consectetur",
        "adipiscing", "elit.");

        Optional<Integer> risultato = strings.stream().map(String::length).reduce(Math::max);

        System.out.println(risultato);
        
    }
}
