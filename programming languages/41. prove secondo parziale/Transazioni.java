import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

class Transazione {

    private LocalDate data;
    private double importo;
    private String tipo;

    public Transazione(LocalDate data, double importo, String tipo) {
        this.data = data;
        this.importo = importo;
        this.tipo = tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public double getImporto() {
        return importo;
    }

    public String getTipo() {
        return tipo;
    }

    public String toString() {
        return data + " , " + importo + " , " + tipo;
    }
}

public class Transazioni {

    public static void main(String[] args) {
        List<Transazione> transazioni = Arrays.asList(
            new Transazione(
                LocalDate.of(2023, Month.NOVEMBER, 15),
                100.0,
                "credito"
            ),
            new Transazione(
                LocalDate.of(2023, Month.NOVEMBER, 20),
                -50.0,
                "debito"
            ),
            new Transazione(
                LocalDate.of(2023, Month.DECEMBER, 5),
                200.0,
                "credito"
            ),
            new Transazione(
                LocalDate.of(2023, Month.NOVEMBER, 25),
                -150.0,
                "debito"
            ),
            new Transazione(
                LocalDate.of(2023, Month.NOVEMBER, 30),
                75.0,
                "credito"
            )
        );

        // 1. Filtrare le transazioni di Novembre
        List<Transazione> transazioniMese = transazioni
            .stream()
            .filter(t -> t.getData().getMonthValue() == 11)
            .collect(Collectors.toList());
        System.out.println("Transazioni di Novembre:");
        transazioniMese.forEach(System.out::println);
        System.out.println();

        // 2. Calcolare importo totale dei crediti e dei debiti separatamente
        double totaleCrediti = transazioniMese
            .stream()
            .filter(t -> t.getTipo().equalsIgnoreCase("credito"))
            .mapToDouble(Transazione::getImporto)
            .sum();

        double totaleDebiti = transazioniMese
            .stream()
            .filter(t -> t.getTipo().equalsIgnoreCase("debito"))
            .mapToDouble(Transazione::getImporto)
            .sum();

        System.out.println("Totale crediti: " + totaleCrediti);
        System.out.println("Totale debiti: " + totaleDebiti);
        System.out.println();

        // 3. Trovare transazione con importo più alto in valore assoluto
        Optional<Transazione> maxCredito = transazioniMese
            .stream()
            .filter(t -> t.getTipo().equalsIgnoreCase("credito"))
            .max(Comparator.comparingDouble(Transazione::getImporto));

        Optional<Transazione> maxDebito = transazioniMese
            .stream()
            .filter(t -> t.getTipo().equalsIgnoreCase("debito"))
            .max(Comparator.comparingDouble(t -> Math.abs(t.getImporto())));

        System.out.println("Credito maggiore: " + maxCredito.orElse(null));
        System.out.println("Debito maggiore: " + maxDebito.orElse(null));
        System.out.println();

        // 4. Ordinare le transazioni per data decrescente
        List<Transazione> transazioniOrdinate = transazioniMese
            .stream()
            .sorted(Comparator.comparing(Transazione::getData).reversed())
            .collect(Collectors.toList());

        System.out.println("Transazioni ordinate (data decrescente):");
        transazioniOrdinate.forEach(System.out::println);
    }
}
