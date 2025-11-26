import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Persona p1 = new Persona("Thomas","Turbato",18,asList("Pedofilia","Necrofilia","Piedinofilia"));
        Persona p2 = new Persona("Marco","Alberti",53,asList("Pedofilia","Jazz","Cosplayer","Milf","Piedinofilia"));
        Persona p3 = new Persona("Alessandro","Caputo Nassetti",23,asList("Pedofilia","Bambini","Asili nido","Uomini","Piedinofilia"));

        List<Persona> persone = Arrays.asList(p1,p2,p3);
        
        Map<String, List<Persona>> personePerPassione = persone.stream()
            .filter(p -> p.getEta() >= 18) // Filtra i maggiorenni
            .sorted(Comparator.comparing(Persona::getEta)) // Ordina per età
            .collect(Collectors.groupingBy(p -> p.getPassioni().get(0))); // Raggruppa per la prima passione

        // Stampa i risultati
        personePerPassione.forEach((passione, personeConPassione) -> {
            System.out.println("Passione: " + passione);
            System.out.println("Numero persone: " + personeConPassione.size());
            personeConPassione.forEach(p -> System.out.println(" " + p.getNome() + " " + p.getCognome()));
        });
    }
}
