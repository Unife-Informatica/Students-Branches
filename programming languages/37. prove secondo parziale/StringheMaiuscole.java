import java.util.*;

public class StringheMaiuscole {
  public static void main() {
    List<String> lista = List.of("Hello", "World");
    
    List<String> stringheMaiuscole = lista.stream()
                                          .map(String::toUpperCase)
                                          .toList();

    for(String s : stringheMaiuscole) {
      System.out.println(s);
    }
  }
}
