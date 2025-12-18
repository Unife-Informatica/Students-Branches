import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Transazione> transazioni = Arrays.asList(
        new Transazione(LocalDate.of(2023, Month.NOVEMBER, 15), 100.0, "credito"),
        new Transazione(LocalDate.of(2023, Month.APRIL, 11), 200.0, "debito"),
        new Transazione(LocalDate.of(2023, Month.AUGUST, 9), 300.0, "credito"),
        new Transazione(LocalDate.of(2023, Month.OCTOBER, 2), 400.0, "debito"),
        new Transazione(LocalDate.of(2023, Month.NOVEMBER, 8), 500.0, "credito")
        );
        
        //1) 
        transazioni.stream().filter(n->n.getData().getMonth()==Month.NOVEMBER).forEach(System.out::println);

        //2)
        double crediti = transazioni.stream().filter(n->n.getTipo().equals("credito")).map(n->n.getImporto()).reduce(0.0,(a,b)->a+b);
        System.out.println("Crediti: "+crediti);
        double debito = transazioni.stream().filter(n->n.getTipo().equals("debito")).map(n->n.getImporto()).reduce(0.0, (a,b)->a+b);
        System.out.println(debito);
    }
}
