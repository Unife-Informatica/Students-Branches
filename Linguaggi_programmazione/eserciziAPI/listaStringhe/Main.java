import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<String> parole = Arrays.asList("luna", "stitch", "miguel", "speedy");

    List<String> paroleMaiuscole = parole.stream().map(String::toUpperCase).collect(Collectors.toList());

    System.out.println("Parole maiuscole: " + paroleMaiuscole);
  }
}
