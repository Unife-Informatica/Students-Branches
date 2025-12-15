import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    IntStream numbers = new Random(0).ints().map(Math::abs);

    List<Integer> ris = calcola(numbers);
    System.out.println(ris);
  }
  
  public static List<Integer> calcola(IntStream numbers){
    return numbers.filter(n -> n%17 == 0).limit(5).mapToObj(n -> n).collect(Collectors.toList());
  }
}
