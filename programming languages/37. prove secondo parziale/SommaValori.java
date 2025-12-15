import java.util.*;

public class SommaValori {
  public static void main() {
    List<Integer> lista = List.of(1, 2, 3, 4, 5, 6 ,7 , 8, 9, 10);

    int somma = lista.stream()
                     .reduce(0, Integer::sum);

    System.out.println("La somma è: " + somma);
  }
}
