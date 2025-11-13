import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Esercizio4 {
  public static void main(String[] args) {
    List<String> parole = Arrays.asList("banana", "mela", "arancia", "kiwi");
    List<String> paroleOrdinate = parole.stream()
                                        .sorted()
                                        .collect(Collectors.toList());
    
    System.out.println(paroleOrdinate);
  }
}
