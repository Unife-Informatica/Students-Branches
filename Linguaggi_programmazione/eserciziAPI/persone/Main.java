import static java.util.Arrays.asList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Persona p1 = new Persona("Thomas", "Turbato", 17, asList("Scopare", "Stuprare", "Cagare")); 
    Persona p2 = new Persona("Marco", "Alberti", 53, asList("Studiare", "Rasarsi", "Cosplayer"));
    Persona p3 = new Persona("Michael", "Pitolano", 34, asList("Leccare", "Mangiare", "Cosplayer"));
    List<Persona> listaPersone = Arrays.asList(p1,p2,p3);

    // Soluzione con Stream
      Map<String, List<Persona>> personePerPassione = listaPersone.stream()
          .filter(p -> p.getEta() >= 18)                     // Filtra i maggiorenni
          .sorted(Comparator.comparing(Persona::getEta))     // Ordina per età
          .collect(Collectors.groupingBy(                    // Raggruppa per prima passione
              p -> p.getPassioni().isEmpty() ? 
                   "Senza passione" : p.getPassioni().get(0)
          ));
      // Stampa i risultati
      personePerPassione.forEach((passione, personeConPassione) -> {
          System.out.println("Passione: " + passione);
          System.out.println("Numero persone: " + personeConPassione.size());
          personeConPassione.forEach(p -> 
              System.out.println("   " + p.getNome() + " " + p.getCognome() +
                                 " (Età: " + p.getEta() + ")")
          );
          System.out.println();
      });
    }
}
