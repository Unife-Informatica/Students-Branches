import java.util.function.Consumer;
import java.util.*;

public class Liste {
  public static void main() {
    /*
     * La lista immutableStrings non puo essere modificata perche
     * viene memorizzata all'interno di un array
     */
    List<String> immutableStrings = List.of("one", "two", "three", "four");
    List<String> strings = new ArrayList<>(immutableStrings);

    Consumer<String> stampa = s -> System.out.println(s);

    // Il metodo forEach cicla tutti gli elementi della lista
    strings.forEach(stampa);
  }
}
