import java.util.*;

public class FiltraInizio {
  public static void main() {
    List<String> lista = List.of("Avocado", "Apple", "Ananas", "Banana", "Tomato");
    String inizio = "A";

    List<String> listaFiltrata = lista.stream()
                                      .filter(s -> s.startsWith(inizio))
                                      .map(String::toUpperCase)
                                      .toList();
    for(String s : listaFiltrata) {
      System.out.println(s);
    }
  }
}
