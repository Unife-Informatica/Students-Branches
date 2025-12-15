import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class Main {
  public static void main(String[] args) {
    List<String> strings = asList("Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit");

    Optional<Integer> ris = calcola(strings);
    System.out.println(ris);
  }

  public static Optional<Integer> calcola(List<String> strings){
    return strings.stream().map(String::length).reduce(Math::max);
  }
}
