import java.util.*;
import java.util.stream.*;

class Prodotto {

    private String nome, categoria;
    private double prezzo;

    public Prodotto(String nome, double prezzo, String categoria) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String toString() {
        return nome + " , " + prezzo + " , " + categoria;
    }
}

public class Prodotti {

    public static void main() {
        List<Prodotto> listaProdotti = Arrays.asList(
            new Prodotto("Prosciutto", 15, "Salumi"),
            new Prodotto("Formaggio", 12, "Latticini"),
            new Prodotto("Pane", 3, "Pane e Dolci"),
            new Prodotto("Vino", 20, "Bevande"),
            new Prodotto("Salame", 18, "Salumi"),
            new Prodotto("Mozzarella", 8, "Latticini"),
            new Prodotto("Biscotti", 5, "Pane e Dolci"),
            new Prodotto("Birra", 6, "Bevande")
        );

        listaProdotti
            .stream()
            .filter(p -> p.getCategoria().equalsIgnoreCase("salumi"))
            .filter(p -> p.getPrezzo() > 16)
            .forEach(System.out::println);

        listaProdotti
            .stream()
            .collect(
                Collectors.groupingBy(
                    Prodotto::getCategoria,
                    Collectors.maxBy(
                        Comparator.comparingDouble(Prodotto::getPrezzo),
                    )
                )
            )
            .entrySet()
            .stream()
            .forEach(e ->
                System.out.println(e.getKey() + " -> " + e.getValue())
            );
    }
}
