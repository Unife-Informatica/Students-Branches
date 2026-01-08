import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // ===============================
        // CREAZIONE LISTA LIBRI
        // ===============================
        // Creo una lista di libri contenente informazioni
        // su titolo, autore, genere, prezzo, numero di pagine e anno di pubblicazione.
        // Questa struttura verrà usata per esercizi con Stream API.
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

        // ===============================
        // RAGGRUPPAMENTO PER GENERE
        // ===============================
        // Raggruppo i libri in base al genere.
        // Ottengo una mappa in cui la chiave è il genere
        // e il valore è la lista dei libri appartenenti a quel genere.
        Map<String, List<Book>> libriPerGenere =
                books.stream()
                        .collect(Collectors.groupingBy(Book::getGenre));

        // Per ogni genere stampo il numero totale di libri.
        libriPerGenere.forEach((genere, libri) -> {
            System.out.println("Libri " + genere + ": " + libri.size());
        });

        System.out.println("");

        // ===============================
        // LIBRI CON PREZZO >= 15 PER AUTORE
        // ===============================
        // Filtro i libri che hanno prezzo maggiore o uguale a 15.
        List<Book> libriHigh15 =
                books.stream()
                        .filter(b -> b.getPrice() >= 15.0)
                        .collect(Collectors.toList());

        // Raggruppo i libri filtrati per autore.
        Map<String, List<Book>> libriPerAutore15 =
                libriHigh15.stream()
                        .collect(Collectors.groupingBy(Book::getAuthor));

        // Stampo per ogni autore i titoli dei libri con prezzo >= 15.
        libriPerAutore15.forEach((autore, libri) -> {
            System.out.println("Autore: " + autore);
            libri.forEach(l -> System.out.println("   Titolo: " + l.getTitle()));
        });

        // ===============================
        // AUTORE CON PIÙ PAGINE TOTALI
        // ===============================
        // Raggruppo i libri per autore sommando il numero totale di pagine.
        // Successivamente individuo l'autore con il valore massimo.
        Map.Entry<String, Integer> autoreMaxPag =
                books.stream()
                        .collect(Collectors.groupingBy(
                                Book::getAuthor,
                                Collectors.summingInt(Book::getPages)
                        ))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .orElseThrow();

        System.out.println(autoreMaxPag.getKey() + " -> " + autoreMaxPag.getValue());

        System.out.println("");

        // ===============================
        // PREZZO MEDIO DEI LIBRI PER AUTORE
        // ===============================
        // Raggruppo i libri per autore e calcolo il prezzo medio
        // dei libri di ciascun autore.
        System.out.println("Prezzo medio dei libri per autore");

        Map<String, Double> prezzoMedioPerAutore =
                books.stream()
                        .collect(Collectors.groupingBy(
                                Book::getAuthor,
                                Collectors.averagingDouble(Book::getPrice)
                        ));

        prezzoMedioPerAutore.forEach((autore, media) -> {
            System.out.println(autore + " -> " + media);
        });

        System.out.println("");

        // ===============================
        // NUMERO DI LIBRI DOPO IL 1950 PER GENERE
        // ===============================
        // Filtro i libri pubblicati dopo il 1950,
        // poi li raggruppo per genere contando quanti ce ne sono.
        System.out.println("Libri pubblicati dopo il 1950 per genere");

        books.stream()
                .filter(b -> b.getYear() > 1950)
                .collect(Collectors.groupingBy(
                        Book::getGenre,
                        Collectors.counting()
                ))
                .forEach((genere, count) -> {
                    System.out.println(genere + " -> " + count);
                });

        // ===============================
        // MIGLIOR RAPPORTO PAGINE / PREZZO
        // ===============================
        // Individuo il libro con il miglior rapporto
        // tra numero di pagine e prezzo.
        System.out.println("\nLibro con miglior rapporto pagine/prezzo");

        Book migliorRapporto =
                books.stream()
                        .max(Comparator.comparingDouble(
                                b -> (double) b.getPages() / b.getPrice()
                        ))
                        .orElseThrow();

        System.out.println(migliorRapporto.getTitle());

        // ===============================
        // PARTIZIONAMENTO PREZZO >= 15
        // ===============================
        // Divido i libri in due gruppi:
        // true  -> prezzo >= 15
        // false -> prezzo < 15
        Map<Boolean, List<Book>> libriMaggUgg15 =
                books.stream()
                        .collect(Collectors.partitioningBy(
                                b -> b.getPrice() >= 15
                        ));

        System.out.println("Libri con prezzo >= 15 [true] / < 15 [false]");
        libriMaggUgg15.forEach((condizione, libri) -> {
            libri.forEach(b ->
                    System.out.println(condizione + " -> " + b.getTitle())
            );
        });

        // ===============================
        // PREZZO MASSIMO PER GENERE
        // ===============================
        // Raggruppo i libri per genere e per ogni genere
        // trovo il libro con il prezzo massimo.
        System.out.println("\nPrezzo massimo per ogni genere");

        Map<String, Optional<Book>> prezzoMaxGenere =
                books.stream()
                        .collect(Collectors.groupingBy(
                                Book::getGenre,
                                Collectors.maxBy(
                                        Comparator.comparingDouble(Book::getPrice)
                                )
                        ));

        prezzoMaxGenere.forEach((genere, optBook) -> {
            optBook.ifPresent(book ->
                    System.out.println(genere + " -> " + book.getPrice())
            );
        });

        // ===============================
        // CONTEGGIO LIBRI CON PIÙ DI 400 PAGINE
        // ===============================
        // Conto quanti libri hanno più di 400 pagine.
        System.out.println("\nLibri con più di 400 pagine");

        long libriMax400Pagine =
                books.stream()
                        .filter(b -> b.getPages() > 400)
                        .count();

        System.out.println("Totale: " + libriMax400Pagine);
    }
}
