import java.util.*;
import java.util.stream.*;

class Book {

    private String title;
    private String author;
    private String genre;
    private double price;
    private int pages;
    private int year;

    public Book(
        String title,
        String author,
        String genre,
        double price,
        int pages,
        int year
    ) {
        this.title = title;

        this.author = author;

        this.genre = genre;

        this.price = price;
        this.pages = pages;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format(
            "% s by %s - %s - €%.2f - %d pages - %d",
            title,
            author,
            genre,
            price,
            pages,
            year
        );
    }
}

public class Books {

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book(
                "The Hobbit",
                "J.R.R. Tolkien",
                "Fantasy",
                12.5,
                310,
                1937
            ),
            new Book(
                "The Lord of the Rings",
                "J.R.R. Tolkien",
                "Fantasy",
                25.0,
                1178,
                1954
            ),
            new Book("1984", "George Orwell", "Sci-Fi", 10.0, 328, 1949),
            new Book("Animal Farm", "George Orwell", "Satire", 7.5, 112, 1945),
            new Book("Dracula", "Bram Stoker", "Horror", 8.5, 418, 1897),
            new Book("The Shining", "Stephen King", "Horror", 15.0, 447, 1977),
            new Book("It", "Stephen King", "Horror", 20.0, 1138, 1986),
            new Book("Dune", "Frank Herbert", "Sci-Fi", 18.0, 412, 1965),
            new Book("The Martian", "Andy Weir", "Sci-Fi", 14.0, 369, 2011),
            new Book(
                "Project Hail Mary",
                "Andy Weir",
                "Sci-Fi",
                22.0,
                496,
                2021
            )
        );
        // TODO (A) Raggruppa per genere e, per ogni genere, stampa il numero di libri
        books
            .stream()
            .collect(
                Collectors.groupingBy(
                    Book::getGenre,
                    Collectors.summingInt(Book::getPages)
                )
            )
            .entrySet()
            .stream()
            .forEach(System.out::println);
        System.out.println();

        // TODO (B) Considerando solo i libri con prezzo >= 15,
        // crea una Map<Autore, List<Titolo>> con i titoli per autore
        books
            .stream()
            .filter(e -> e.getPages() >= 15)
            .collect(
                Collectors.groupingBy(
                    Book::getAuthor,
                    Collectors.mapping(Book::getTitle, Collectors.toList())
                )
            )
            .entrySet()
            .stream()
            .forEach(System.out::println);
        System.out.println();

        // TODO (C) Trova l'autore che ha scritto il maggior numero di pagine totali (somma pagine di tutti i suoi libri)
        // e stampa "Autore -> totalePagine".
        books
            .stream()
            .collect(
                Collectors.groupingBy(
                    Book::getAuthor,
                    Collectors.summingInt(Book::getPages)
                )
            )
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .ifPresent(e ->
                System.out.println(e.getKey() + " -> " + e.getValue())
            );
        System.out.println();
    }
}
