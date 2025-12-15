import java.util.*;

public class Main {
  public static void main() {
    List<Prodotto> listaProdotti = new ArrayList<>();

    listaProdotti.add(new Prodotto("Laptop", 899.99, "Informatica"));
    listaProdotti.add(new Prodotto("Smartphone", 699.50, "Elettronica"));
    listaProdotti.add(new Prodotto("Mouse", 25.99, "Accessori"));
    listaProdotti.add(new Prodotto("Tastiera", 49.90, "Accessori"));
    listaProdotti.add(new Prodotto("Monitor", 199.99, "Informatica"));
    listaProdotti.add(new Prodotto("Cuffie", 79.99, "Elettronica"));
    listaProdotti.add(new Prodotto("Stampante", 149.00, "Informatica"));
    listaProdotti.add(new Prodotto("Webcam", 59.99, "Accessori"));
    listaProdotti.add(new Prodotto("Tablet", 329.90, "Elettronica"));
    listaProdotti.add(new Prodotto("Hard Disk", 89.50, "Informatica"));

    List<Prodotto> lista1 = listaProdotti.stream()
                                         .filter(p -> p.getCategoria() == "Informatica")
                                         .filter(p -> p.getPrezzo() > 150)
                                         .toList();

    for(Prodotto p : lista1) {
      System.out.println(p.getNome());
    }

    double lista2 = listaProdotti.stream()
                                 .filter(p -> "Informatica".equals(p.getCategoria()))
                                 .mapToDouble(Prodotto::getPrezzo)
                                 .max()
                                 .orElse(0.0);

    System.out.println(lista2);

    double media = listaProdotti.stream()
                                .mapToDouble(Double::doubleValue)
                                .average()
                                .orElse(0.0);

    System.out.println(media);

    Map<String, List<String>> lista3 = prodotti.stream()
                                              .collect(groupingBy( // raggruppa gli elementi di uno stream usando una chiave (Prodotto::getCategoria)
                                                Prodotto::getCategoria,
                                                mapping(Prodotto::getNome, toList())  // prende gli elementi con la stessa chiave e li trasforma in lista
                                              ));
  }
}
