import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) throws Exception {
       List<String> strings = Arrays.asList("Lorem", "ipsum", "dolor", "sit", "amet,", "consectetur","adipiscing", "elit.");
       Optional<Integer> length = strings.stream().map(String::length).reduce(Math::max);
       System.out.println(length.orElse(0));
    }
}
