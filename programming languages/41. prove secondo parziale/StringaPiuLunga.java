import java.util.*;

public class StringaPiuLunga {

    public static void main() {
        List<String> strings = Arrays.asList(
            "Lorem",
            "ipsum",
            "dolor",
            "sit",
            "amet,",
            "consectetur",
            "adipiscing",
            "elit."
        );

        strings
            .stream()
            .max(Comparator.comparing(String::length))
            .ifPresent(e -> System.out.println(e));
    }
}
