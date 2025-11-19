import java.util.*;
import java.util.stream.*;

public class Esercizio4 {
  public static void main() {
    List<String> listaStringhe = new ArrayList<>();
    listaStringhe.add("Albero");
    listaStringhe.add("Cane");

    List<String> nuovaListaStringhe = listaStringhe.stream()
                                                   .filter(s -> s.toLowerCase().charAt(0) == 'a')
                                                   .map(String::toLowerCase)
                                                   .collect(Collectors.toList()); // trasforma la stream in lista
    
    nuovaListaStringhe.stream().forEach(System.out::println);
  }
}
