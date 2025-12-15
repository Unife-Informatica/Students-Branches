import java.util.*;

public class RimozioneDuplicati {
  public static void main() {
    List<String> lista = List.of("Hello", "World", "Hello", "Code");

    List<String> listaSenzaDuplicati = lista.stream()
                                            .map(String::toLowerCase)
                                            .distinct()
                                            .toList();

    for(String s : listaSenzaDuplicati) {
      System.out.println(s);
    }
  }
}
