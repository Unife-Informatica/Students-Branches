import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<Persona> persone = Arrays.asList(
                new Persona("Marco", 20, Genere.MASCHIO, "Roma"),
                new Persona("Giulia", 25, Genere.FEMMINA, "Milano"),
                new Persona("Mario", 38, Genere.MASCHIO, "Milano"),
                new Persona("Luca", 18, Genere.MASCHIO, "Torino"),
                new Persona("Sara", 30, Genere.FEMMINA, "Napoli"));
        /* Filtrare le persone che hanno più di 30 anni. */
        List<Persona> sortedYearList = persone.stream().filter(p -> p.getEta() > 30).collect(Collectors.toList());
        System.out.println(sortedYearList + "\n");
        /*
         * Estrarre i nomi delle persone che vivono in una città specifica
         * (es."Milano").
         */
        List<String> sortedCityList = persone.stream()
                .filter(p -> p.getCitta().equals("Milano"))
                .map(Persona::getNome)
                .collect(Collectors.toList());
        System.out.println(sortedCityList + "\n");
        // Calcolare eta media delle donne
        double media = persone.stream()
                .filter(p -> p.getGenere().equals(Genere.FEMMINA))
                .mapToDouble(Persona::getEta).average().orElse(0.0);
        System.out.println("La media di eta della persone femmine e' di: " + media + "anni\n");
        // Trovare la persona più giovane nella lista.
        Optional<Persona> personaPiuGiovane = persone.stream()
                .min(Comparator.comparingInt(Persona::getEta));
        System.out.println(personaPiuGiovane + "\n");
        // Raggruppare le persone per città e stampare il risultato.
        Map<String, List<Persona>> personePerCitta = persone.stream()
                .collect(Collectors.groupingBy(Persona::getCitta));
        personePerCitta.forEach((citta, listaPersone) -> {
            System.out.println("Città: " + citta);
            listaPersone.forEach(persona -> System.out.println("  " + persona));
        });
        System.out.println();
        // Verificare se tutte le persone sono maggiorenni
        boolean verifica = persone.stream()
                .allMatch(p -> p.getEta() >= 18);
        System.out.println("Tutte le persone sono maggiorenni: " + verifica + "\n");

        //Contare quante persone vivono in una città specifica.
        long conteggioMilano = persone.stream()
            .filter(p->p.getCitta().equals("Milano")).count();
        System.out.println("Persone che vivono a Milano: "+conteggioMilano);
    }
}
