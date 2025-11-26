import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<Prodotto> listaProdotti = Arrays.asList(
            new Prodotto("Tastiera", "informatica", 50.0),
            new Prodotto("Maglietta", "Vestiti", 20.0),
            new Prodotto("Pallone", "sport", 15.0),
            new Prodotto("Mouse", "informatica", 20.0)
        );
        //P1
        List<Prodotto> prodottiFiltrati = listaProdotti.stream().filter(p->p.getCategoria().equals("informatica")&&p.getPrezzo()>30).collect(Collectors.toList());
        System.out.println(prodottiFiltrati);
        //P2
        Map<String,Optional<Prodotto>> prodPiuCaroCatg = listaProdotti.stream().collect(Collectors.groupingBy(Prodotto::getCategoria,Collectors.maxBy(Comparator.comparingDouble(Prodotto::getPrezzo))));
        prodPiuCaroCatg.forEach((categoria,prodotto)->System.out.println(categoria+": "+prodotto.orElse(null)));
        //P3
        double media = listaProdotti.stream().mapToDouble(Prodotto::getPrezzo).average().orElse(0.0);
        System.out.println("Prezzo medio: "+media);
        //Creare una mappa dove la chiave è la categoria e il valore è una lista dei
        //nomi dei prodotti in quella categoria.
        Map<String, List<String>> prodottiPerCategorie =listaProdotti.stream(). collect(
                                Collectors.groupingBy(Prodotto::getCategoria,
                                Collectors.mapping(Prodotto::getNome, Collectors.toList())
        ));
        prodottiPerCategorie.forEach((categoria,nomi)->System.out.println(categoria + ": "+nomi));
        
       
    }
}
