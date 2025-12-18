import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) throws Exception {
        IntStream numbers = new Random(0).ints().map(Math::abs);

        List<Integer> risultato =  numbers.filter(n->n%17==0).limit(5).mapToObj(n->n).collect(Collectors.toList());

        System.out.println(risultato);


    }
}
