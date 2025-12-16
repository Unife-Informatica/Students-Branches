import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<Book> books = Arrays.asList(
      new Book("La divina commedia", "Dante Alighieri", 1304, 40),
      new Book("I promessi sposi", "Alessandro Manzoni", 1827, 20),
      new Book("Big Brother", "George Orwell", 1984, 30),
      new Book("Infinite Jest", "David Wallace", 2011, 50)
    );
    // 1 - filtrare i libri pubblicati dopo il 2010
    List<Book> recentBooks = books.stream().filter(l -> l.getPublicationYear() > 2010).collect(Collectors.toList());
    System.out.println(recentBooks);

    // 2 - ordinare la lista di libri in ordine crescente di prezzo
    List<Book> sortedBooks = books.stream().sorted(Comparator.comparingDouble(Book::getPrice)).collect(Collectors.toList());
    System.out.println(sortedBooks);

    // 3 - creare una lista dei titoli dei libri scritti da un autore specifico
    List<Book> authorBooks = books.stream().filter(l -> l.getAuthor().equals("Alessandro Manzoni")).collect(Collectors.toList());
    System.out.println(authorBooks);

    // 4 - calcolare la media dei prezzi di tutti i libri
    double averageBooks = books.stream().mapToDouble(Book::getPrice).average().orElse(0.0);
    System.out.println("Media: " + averageBooks);

    // 5 - trovare il libro con il prezzo più alto
    Optional<Book> maxBook = books.stream().max(Comparator.comparingDouble(l -> l.getPrice()));
    System.out.println(maxBook.orElse(null));

    // 6 - controllare se c'è almeno un libro che costa più di 30 euro
    boolean overBook = books.stream().anyMatch(l -> l.getPrice() > 30);
    System.out.println(overBook);

    // 7 - stampare i libri ordinati per anno di pubblicazione in ordine decrescente
    List<Book> sortedBooks2 = books.stream().sorted(Comparator.comparingDouble(Book::getPublicationYear).reversed()).collect(Collectors.toList());
    System.out.println(sortedBooks2);
  }
}
