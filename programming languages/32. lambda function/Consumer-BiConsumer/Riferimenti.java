import java.util.function.Consumer;
import java.util.*;

public class Riferimenti {
  public static void main() {
    List<String> immutableStrings = List.of("one", "two", "three", "four");
    List<String> strings = new ArrayList<>(immutableStrings);

    /*
     * Con questa sintassi passo il riferimento alla funzione println
     */
    Consumer<String> stampa = System.out::println;

    strings.forEach(stampa);
  }
}
