import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<Book> books = Arrays.asList(
      new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 12.5, 310, 1937),
      new Book("The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 25.0, 1178, 1954),
      new Book("1984", "George Orwell", "Sci-Fi", 10.0, 328, 1949),
      new Book("Animal Farm", "George Orwell", "Satire", 7.5, 112, 1945),
      new Book("Dracula", "Bram Stoker", "Horror", 8.5, 418, 1897),
      new Book("The Shining", "Stephen King", "Horror", 15.0, 447, 1977),
      new Book("It", "Stephen King", "Horror", 20.0, 1138, 1986),
      new Book("Dune", "Frank Herbert", "Sci-Fi", 18.0, 412, 1965),
      new Book("The Martian", "Andy Weir", "Sci-Fi", 14.0, 369, 2011),
      new Book("Project Hail Mary", "Andy Weir", "Sci-Fi", 22.0, 496, 2021)
    );

    //1 - raggruppa per genere e, per ogni genere, stampa il numero di libri
    Map<String, Long> booksNumber = books.stream().collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()));
    booksNumber.forEach((genre, count) -> System.out.println(genre + " -> " + count));

    //2 - considerando solo i libri con prezzo >= 15, crea una Map<Autore, List<Titolo>> con i titoli per autore
    Map<String, List<String>> authorBooks = books.stream().filter(b -> b.getPrice() >= 15).collect(Collectors.groupingBy(Book::getAuthor, Collectors.mapping(Book::getTitle, Collectors.toList())));
    authorBooks.forEach((author, titles) -> System.out.println(author + " -> " + titles));

    //3 - trova l'autore che ha scritto il maggior numero di pagine totoali (somma di tutti i suoi libri) e stampa "Autore -> totalePagine"
    books.stream().collect(Collectors.groupingBy(Book::getAuthor, Collectors.summingInt(Book::getPages))).entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(entry -> System.out.println("\nAutore con più pagine totali:\n" +
          entry.getKey() + " -> " + entry.getValue()));
  }
}
