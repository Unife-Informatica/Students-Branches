import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<Prodotto> listaProdotti = Arrays.asList(
      new Prodotto("Tastiera", 50.0, "informatica"),
      new Prodotto("Pallone", 12.0, "sport"),
      new Prodotto("Quaderni", 5.0, "scuola"),
      new Prodotto("Mouse", 25.0, "informatica"),
      new Prodotto("Scarpe", 80.0, "abbigliamento")
    );

    // 1 - filtrare i prodotti di una categoria specifica e con un prezzo superiore ad una certa soglia
    List<Prodotto> prodottiFiltrati = listaProdotti.stream().filter(p -> p.getCategoria().equals("informatica") && p.getPrezzo() > 30).collect(Collectors.toList());
    System.out.println(prodottiFiltrati);

    // 2 - trovare il prodotto più caro di ogni categoria
    Map<String,Optional<Prodotto>> prodottoPiuCaroPerCategoria = listaProdotti.stream().collect(Collectors.groupingBy(Prodotto::getCategoria, Collectors.maxBy(Comparator.comparingDouble(Prodotto::getPrezzo))));
    prodottoPiuCaroPerCategoria.forEach((categoria,prodotto) -> System.out.println(categoria + ": " + prodotto.orElse(null)));

    // 3 - calcolare il prezzo medio di tutti i prodotti
    double media = listaProdotti.stream().mapToDouble(Prodotto::getPrezzo).average().orElse(0.0);
    System.out.println("Media: " + media);

    // 4 - creare una mappa dove la chiave è la categoria e il valore è una lista dei nomi dei prodotti in quella categoria
    Map<String, List<String>> prodottiPerCategoria = listaProdotti.stream().collect(Collectors.groupingBy(Prodotto::getCategoria, Collectors.mapping(Prodotto::getNome, Collectors.toList())));
    prodottiPerCategoria.forEach((categoria, nomi) -> System.out.println(categoria + ": " + nomi));
  }
}
