import java.util.*;

public class NumeriPari {
  public static void main() {
    List<Integer> lista = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    List<Integer> numeriPari = lista.stream()
                                    .filter(n -> n % 2 == 0)
                                    .toList();
    
    for(Integer n : numeriPari) {
      System.out.println(n);
    }
  }
}
