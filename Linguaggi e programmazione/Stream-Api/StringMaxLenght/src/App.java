import static java.util.Arrays.asList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> strings=asList("Lorem","Cavoletti","Cannocchiali","Supercalifragilistichespiralidosi");

        Optional<Integer> risultato = stringMaxLength(strings);
        System.out.println(risultato.orElse(0));
    }
    public static Optional<Integer> stringMaxLength(List<String> strings){
        return strings.stream().map(String::length).reduce(Math::max);
    }
}
