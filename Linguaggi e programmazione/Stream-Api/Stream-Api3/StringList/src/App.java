import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> parole = Arrays.asList("luna", "stitch", "miguel", "speedy");
        List<String> uppCaseParole = parole.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(uppCaseParole);
    }
}
