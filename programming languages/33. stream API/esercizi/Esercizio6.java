import java.util.*;

public class Esercizio6 {
  public static void main() {
    List<Integer> lista = new ArrayList<>();
    int limit = 100;

    lista.add(1);
    lista.add(9);
    lista.add(101);

    System.out.println(lista.stream().anyMatch(n -> n > limit));
  }
}
