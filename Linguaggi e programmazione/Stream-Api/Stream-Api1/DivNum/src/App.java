import static java.util.Arrays.asList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<Integer> numbers = asList(1,2,3,4,5);

        Set<Integer> risultato = divnum(numbers);
        System.out.println(risultato);

    }
    public static Set<Integer> divnum(List<Integer> numbers){
                //List.creaStream.n/2inStream.metteNelSet
        return numbers.stream().map(n->n/2).collect(Collectors.toSet());
    }
}
