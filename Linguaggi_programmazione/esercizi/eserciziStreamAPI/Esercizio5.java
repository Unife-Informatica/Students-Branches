import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Esercizio5 {
  public static void main(String[] args) {
    List<Integer> numeri = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
    List<Integer> numeroDistinti = numeri.stream()
                                         .distinct()
                                         .collect(Collectors.toList());

    System.out.println(numeroDistinti);
  }
}
