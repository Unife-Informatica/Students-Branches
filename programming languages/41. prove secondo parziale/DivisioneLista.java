import java.util.*;

public class DivisioneLista {

    public static void main() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers
            .stream()
            .map(n -> n / 2)
            .toList()
            .forEach(e -> System.out.println(e));
    }
}
