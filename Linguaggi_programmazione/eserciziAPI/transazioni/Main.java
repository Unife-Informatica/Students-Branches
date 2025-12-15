import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        List<Transazione> transazioni = Arrays.asList(
            new Transazione("Credito", LocalDate.of(2024, Month.APRIL, 10), 1000.0),
            new Transazione("Debito", LocalDate.of(2024, Month.MARCH, 5), 250.0),
            new Transazione("Credito", LocalDate.of(2024, Month.JANUARY, 20), 1800.0),
            new Transazione("Debito", LocalDate.of(2024, Month.JUNE, 2), 600.0),
            new Transazione("Credito", LocalDate.of(2024, Month.DECEMBER, 15), 4500.0)
        );

        // 1 - Filtrare le transazioni effettuate in un determinato mese dell'anno
        List<Transazione> transazioniNovembre = transazioni.stream().filter(t -> t.getData().getMonth() == Month.NOVEMBER).collect(Collectors.toList());
        System.out.println(transazioniNovembre);

        // 2 - Calcolare l'importo totale dei crediti e dei debiti separatamente
        double crediti = transazioni.stream().filter(t -> t.getTipo().equals("credito")).map(t -> t.getImporto()).reduce(0.0, (a,b) -> a+b);
        double debiti = transazioni.stream().filter(t -> t.getTipo().equals("debito")).map(t -> t.getImporto()).reduce(0.0, (a,b) -> a+b);
        System.out.println("Totale crediti: " + crediti);
        System.out.println("Totale debiti: " + debiti);

        // 3 - Trovare la transazione con l'importo più alto in valore assoluto (crediti e debiti)
        Optional<Transazione> maxCredito = transazioni.stream().filter(t -> t.getTipo().equals("credito")).max(Comparator.comparingDouble(t -> t.getImporto()));
        Optional<Transazione> maxDebito = transazioni.stream().filter(t -> t.getTipo().equals("debito")).max(Comparator.comparingDouble(t -> t.getImporto()));
        System.out.println("Transazione massimo in credito: " + maxCredito.orElse(null));
        System.out.println("Transazione massimo in debito: " + maxDebito.orElse(null));

        // 4 - Ordinare le transazioni in base alla data in ordine cronologico
        List<Transazione> transazioniOrdinate = transazioni.stream().sorted((t1,t2) -> t1.getData().compareTo(t2.getData())).collect(Collectors.toList());
        System.out.println(transazioniOrdinate);
    }
}
