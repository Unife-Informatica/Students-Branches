import java.util.*;

public class Main {
  public static void main() {
    List<Integer> list = new ArrayList<>();

    list.add(21);
    System.out.println("Primo elemento: " + list.get(0));  // passo l'indice dell'elemento

    for(Integer i : list) {
      System.out.println(i);
    }
    // Equivalenti
    for (Iterator i = list.iterator(); i.hasNext(); ) {
      System.out.println(i.next());
    }
  }
}
