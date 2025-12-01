import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        //Libri dopo il 2010
        List<Book> books = Arrays.asList(
            new Book("La divina commedia", "Dante Alighieri", 1304, 40),
            new Book("I promessi sposi", "Alessandro Manzoni", 1827, 20),
            new Book("Big Brother", "George Orwell", 1984, 30),
            new Book("Infinite Jest", "David Wallace", 2011, 50),
            new Book("Computer science","John Erman",2015,55)
        );
        List<Book> recentBooks = books.stream().filter(b->b.getPublicationYear()>2010).collect(Collectors.toList());
        System.out.println(recentBooks);
        System.out.println("");
        //Ordinamento per prezzo: Ordina la lista di libri in ordine crescente di prezzo
        //Se getPrice() ritorna un double primitivo
        List<Book> sortedBooks = books.stream()
        .sorted(Comparator.comparingDouble(Book::getPrice))
        .collect(Collectors.toList());
        System.out.println(sortedBooks+"\n");
        /*Titoli di autori specifici: Crea una lista dei titoli dei libri scritti da un autore specifico (ad esempio, "J.K. Rowling"). */
        List<Book> authorBook = books.stream().filter(b->b.getAuthor().equals("George Orwell")).collect(Collectors.toList());
        System.out.println(authorBook+"\n");
        /*Media dei prezzi: Calcola la media dei prezzi di tutti i libri. */
        double media = books.stream().mapToDouble(Book::getPrice).average().orElse(0.0);
        System.out.println("Prezzo medio: "+media+"\n");
        /*Libro più costoso: Trova il libro con il prezzo più alto. */
        Optional<Book> libroPiuCostoso = books.stream().max(Comparator.comparingDouble(b->b.getPrice()));
        System.out.println("Libro piu' costoso: "+libroPiuCostoso.orElse(null)+"\n");
        /*Verifica prezzo massimo: Controlla se c'è almeno un libro che costa più di 30 euro. */
        boolean verifica = books.stream().anyMatch(b->b.getPrice()>30);
        System.out.println("Libro con costo maggiore di 30 euro: "+verifica+"\n");
        /* Stampa i libri ordinati per anno di pubblicazione in ordine decrescente.*/
        List<Book> sortedBooks2 =books.stream().sorted(Comparator.comparingDouble(Book::getPublicationYear).reversed()).collect(Collectors.toList());
        System.out.println(sortedBooks2);

    }
}
