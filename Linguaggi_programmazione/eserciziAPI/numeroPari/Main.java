import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main{
  public static void main(String[] args) {
    List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    Optional<Integer> risultato = numeri.stream().filter(n -> n%2 == 0).findFirst();

    if(risultato.isPresent()){
      System.out.println("Il primo numero pari è: " + risultato.get());
    }
  }
}