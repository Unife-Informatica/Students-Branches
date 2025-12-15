
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Book {

    private final String title;
    private final String author;
    private final int publicationYear;
    private final double price;

    public Book(String title, String author, int publicationYear, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + publicationYear + "), $" + price;
    }
}

public class Esercizio5 {

    public static void main(String[] args) {
        List<Book> listaLibri = Arrays.asList(
                new Book("La bella e la bestia", "Jeanne-Marie Leprince de Beaumont", 1756, 10),
                new Book("Il sentiero delle nuvole", "Giulia Ferri", 2019, 14.50),
                new Book("Ombre sul lago", "Lorenzo Bianchi", 2022, 18.90),
                new Book("Il giardino delle stelle", "Chiara Monti", 2020, 12.00),
                new Book("La città di vetro", "Marco Rinaldi", 2024, 16.75)
        );

        List<Book> libriDopo2010 = listaLibri.stream().filter(b -> b.getPublicationYear() > 2010).toList();
        List<Book> ordinePrezzo = listaLibri.stream().sorted(Comparator.comparing(Book::getPrice)).toList();
        String nomeLibroPrezzoMax = listaLibri.stream().max(Comparator.comparing(Book::getPrice)).map(Book::getTitle).orElse(null);
        List<String> titoliDiAutore = listaLibri.stream().filter(b -> b.getAuthor().equalsIgnoreCase("Giulia Ferri")).map(Book::getTitle).toList();

    }

}
