import java.util.*;

public class Esercizio3 {
  public static void main() {
    List<Integer> lista = new ArrayList<>();
    lista.add(3);
    lista.add(4);
    lista.add(6);
    lista.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
  }
}
