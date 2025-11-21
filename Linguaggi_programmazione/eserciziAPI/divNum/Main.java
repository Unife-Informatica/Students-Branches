import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Main {
  public static void main(String[] args) {
    List<Integer> numbers = asList(1,2,3,4,5);

    Set<Integer> risultato = divNum(numbers);
    System.out.println(risultato);
  }

  public static Set<Integer> divNum(List<Integer> numbers){
    return numbers.stream().map(n -> n/2).collect(Collectors.toSet());
  }
}
