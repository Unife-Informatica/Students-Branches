import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Esercizio2 {
  public static void main(String[] args) {
    List<String> parole = Arrays.asList("ciao", "mondo", "stream", "api");
    List<Integer> lunghezze = parole.stream()
                                    .map(String::length)
                                    .collect(Collectors.toList());

    System.out.println(lunghezze);
  }
}
