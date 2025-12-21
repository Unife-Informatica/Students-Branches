import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
      List<Product> products = Arrays.asList(
        new Product("Latte", "Alimentari", 1.5, 50),
        new Product("Pane", "Alimentari", 1.0, 30),
        new Product("Smartphone", "Elettronica", 399.99, 15),
        new Product("Laptop", "Elettronica", 799.99, 10),
        new Product("Jeans", "Abbigliamento", 49.99, 20),
        new Product("Maglietta", "Abbigliamento", 19.99, 40),
        new Product("Tablet", "Elettronica", 299.99, 25)
      );

      // 1 - Raggruppa i prodotti per categoria e stampa quanti prodotti ci sono in ciascuna
      Map<String, Long> totProd = products.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
      totProd.forEach((category, tot) -> System.out.println(category + tot));

      // 2 - Trova il prodotto più costoso
      products.stream().max(Comparator.comparing(Product::getPrice)).ifPresent(p -> System.out.println(p));

      // 3 - Filtra i prodotti con stock < 20 e crea una lista dei loro nomi
      List<String> nameProd = products.stream().filter(p -> p.getStock() < 20).map(Product::getName).collect(Collectors.toList());
      nameProd.forEach((name) -> System.out.println(name));
    }
}
