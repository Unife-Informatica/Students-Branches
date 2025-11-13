import java.util.Arrays;
import java.util.List;

public class Esercizio6 {
  public static void main(String[] args) {
    List<String> parole = Arrays.asList("apple", "banana", "avocado", "cherry", "apricot");
    long conteggio = parole.stream()
                           .filter(parola -> parola.startsWith("a"))
                           .count();

    System.out.println(conteggio);
  }
}
