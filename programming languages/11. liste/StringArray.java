import java.util.List;
import java.util.ArrayList;
public class Main {
  public static void main() {
    /*
     * List<String> definisce una variabile di tipo lista
     *              e che ogni elemento è di tipo stringa
     * ArrayList<>  definisce un oggetto lista e <> stanno
     *              a significare che mantiene il tipo stringa
     */
    List<String> nomi = new ArrayList<>();
    nomi.add("Hello ");
    nomi.add("World");
    nomi.add("!");
    for (String var : nomi) {
      System.out.print(var);
    }
  }
}
