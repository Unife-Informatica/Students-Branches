import java.util.*;

public class LunghezzaStringhe {
  public static void main() {
    List<String> lista = List.of("Hello", "World", "!");
    int limit = 2;
    int nMaggiori = (int)lista.stream()
                         .map(String::length)
                         .filter(s -> s > limit)
                         .count();

    System.out.println("Ci sono " + nMaggiori + " stringhe maggiori di " + limit);
  }
}
