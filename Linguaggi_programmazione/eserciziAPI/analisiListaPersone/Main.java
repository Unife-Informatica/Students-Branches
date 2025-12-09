import java.io.OptionalDataException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main{
  public static void main(String[] args) {
    List<Persona> persone = Arrays.asList(
      new Persona("Alice", "Milano", 28, Genere.FEMMINA),
      new Persona("Marco", "Roma", 35, Genere.MASCHIO),
      new Persona("Giulia", "Torino", 22, Genere.FEMMINA),
      new Persona("Luca", "Bologna", 40, Genere.MASCHIO),
      new Persona("Sara", "Firenze", 31, Genere.FEMMINA),
      new Persona("Davide", "Napoli", 29, Genere.MASCHIO),
      new Persona("Elena", "Venezia", 26, Genere.FEMMINA),
      new Persona("Francesco", "Genova", 45, Genere.MASCHIO),
      new Persona("Chiara", "Verona", 33, Genere.FEMMINA),
      new Persona("Matteo", "Palermo", 38, Genere.MASCHIO)
    );

    // 1 - filtrare persone con età > 30
    List<Persona> maggiori30 = persone.stream().filter(p -> p.getEta() > 30).collect(Collectors.toList());

    // 2 - Estrarre nomi delle persone che vivono a Milano
    List<String> nomiMilano = persone.stream().filter(p -> p.getCitta().equals("Milano")).map(Persona::getNome).collect(Collectors.toList());

    // 3 - Calcolare età media delle donne
    OptionalDouble etaMediaFemmine = persone.stream().filter(p -> p.getGenere() == Genere.FEMMINA).mapToInt(Persona::getEta).average();

    // 4 - Trovare la persona più giovane
    Optional<Persona> piuGiovane = persone.stream().min(Comparator.comparingInt(Persona::getEta));

    // 5 - Raggruppare per città
    Map<String,List<Persona>> personePerCitta = persone.stream().collect(Collectors.groupingBy(Persona::getCitta));

    // 6 - Verificare se tutte le persone sono maggiorenni
    boolean tutteMaggiorenni = persone.stream().map(p -> p.getEta() >= 18).reduce(true, (a,b) -> a && b);

    // 7 - Contare quante persone vivono a Roma
    long conteggioRoma = persone.stream().filter(p -> p.getCitta().equals("Roma")).count();
  }
}