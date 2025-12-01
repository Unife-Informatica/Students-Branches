
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<Transazione> transazioni = Arrays.asList(
            new Transazione(LocalDate.of(2023, Month.NOVEMBER, 15), 100.0, "credito"),
            new Transazione(LocalDate.of(2023, Month.APRIL, 11), 200.0, "debito"),
            new Transazione(LocalDate.of(2023, Month.AUGUST, 9), 300.0, "credito"),
            new Transazione(LocalDate.of(2023, Month.OCTOBER, 2), 400.0, "debito"),
            new Transazione(LocalDate.of(2023, Month.NOVEMBER, 8), 500.0, "credito")
        );
        //1) Filtrare le transazioni in un determinato mese dell'anno
        List<Transazione> transazioniNovembre = transazioni.stream().filter(t->t.getData().getMonth()==Month.NOVEMBER).collect(Collectors.toList());
        System.out.println(transazioniNovembre);

        //2)
        double crediti=transazioni.stream().filter(t->t.getTipo().equals("credito")).map(t->t.getImporto()).reduce(0.0,(a,b)->a+b);
        double debiti=transazioni.stream().filter(t->t.getTipo().equals("debito")).map(t->t.getImporto()).reduce(0.0,(a,b)->a+b);
        System.out.printf("Totale crediti: "+crediti+"\n");
        System.out.printf("Totale debiti: "+debiti+"\n");

        //3)
        Optional<Transazione> maxCredito = transazioni.stream().filter(t->t.getTipo().equals("credito")).max(Comparator.comparingDouble(t->t.getImporto()));
        Optional<Transazione> maxDebito = transazioni.stream().filter(t->t.getTipo().equals("debito")).max(Comparator.comparingDouble(t->t.getImporto()));
        System.out.println("Max credit transaction: "+maxCredito.orElse(null));
        System.out.println("Max debit transaction: "+maxDebito.orElse(null));

        //4)
        List<Transazione> transazioni_ordinate = transazioni.stream().sorted((t1,t2)->t1.getData().compareTo(t2.getData())).collect(Collectors.toList());
        System.out.println(transazioni_ordinate);
        


    }
}
