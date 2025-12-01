import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> parole = Arrays.asList("luna", "stitch", "miguel", "speedy");
        parole.forEach(s->System.out.println(s));
    }
}
