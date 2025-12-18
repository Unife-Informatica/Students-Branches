/* Spagna 
            Murcia
            almeria
            oviedo
            Francia
            Parigi
            montpellie
            Estonia
            tallin
        */


import java.util.*;
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
                new Book("Project Hail Mary", "Andy Weir", "Sci-Fi", 22.0, 496, 2021));

        Map<String, List<Book>> libriPerGenere = books.stream().collect(Collectors.groupingBy(n -> n.getGenre()));
        libriPerGenere.forEach((genere, libri) -> {
            System.out.println("Libri " + genere + ": " + libri.size());
        });
        System.out.println("");

        List<Book> libriHigh15 = books.stream().filter(n -> n.getPrice() >= 15.0).collect(Collectors.toList());
        Map<String, List<Book>> libriPerAutore15 = libriHigh15.stream().collect(Collectors.groupingBy(Book::getAuthor));
        libriPerAutore15.forEach((autore, libri) -> {
            System.out.println("Autore: " + autore);
            libri.forEach(l -> System.out.println("   Titolo: " + l.getTitle()));
        });

        Map.Entry<String, Integer> autoreMaxPag = books.stream().collect(Collectors.groupingBy(Book::getAuthor,Collectors.summingInt(Book::getPages)))
        .entrySet()
        .stream()
        .max(Map.Entry.comparingByValue())
        .orElseThrow();
        System.out.println(autoreMaxPag.getKey()+"->"+autoreMaxPag.getValue());
        
        System.out.println("");

        //(A) Raggruppa i libri per autore e stampa il prezzo medio dei libri di ogni autore.
        System.out.println("Raggruppa i libri per autore e stampa il prezzo medio dei libri di ogni autore.");
        Map<String,Double> prezzoMedioPerAutore = books.stream().collect(Collectors.groupingBy(Book::getAuthor,Collectors.averagingDouble(Book::getPrice)));
        prezzoMedioPerAutore.forEach((autore,media)->{
            System.out.println(autore+"->"+media);
        });
        
        System.out.println("");

        //(B) dove per ogni genere è indicato il numero di libri pubblicati dopo il 1950.
        System.out.println("Per ogni genere è indicato il numero di libri pubblicati dopo il 1950.");
        books.stream().filter(b->b.getYear()>1950).collect(Collectors.groupingBy(Book::getGenre,Collectors.counting()))
        .forEach((genere,count)->{
            System.out.println(genere+"->"+count);
        });
                                                   
        //(C) Trova il libro con il miglior rapporto pagine/prezzo e stampa
        System.out.println("\nlibro con il miglior rapporto pagine/prezzo e stampa");
        Book migliorRapport = books.stream().max(Comparator.comparingDouble(b->(double)b.getPages()/b.getPrice())).orElseThrow();
        System.out.println(migliorRapport.getTitle());

        Map<Boolean,List<Book>> libriMaggUgg15 = books.stream().collect(Collectors.partitioningBy(n->n.getPrice()>=15));
        System.out.println("Libro maggiore di 15[true]||[false]");
        libriMaggUgg15.forEach((bol,libri)->{
            libri.forEach(n->System.out.print("\n"+bol+"->"+n.getTitle()+"\n"));
        });

        System.out.println("\n Prezzo massimo per ogni genere");
        Map<String,Optional<Book>> prezzoMaxGen = books.stream().collect(Collectors.groupingBy(Book::getGenre,Collectors.maxBy(Comparator.comparingDouble(b->b.getPrice()))));
        prezzoMaxGen.forEach((genere,book)->{
            book.stream().forEach(n->System.out.println("\t"+genere+"->"+n.getPrice()));
        });

        //Conta quanti libri hanno più di 400 pagine.
        System.out.println("Conta quanti libri hanno più di 400 pagine.");
        long libMax400Pag = books.stream().filter(b->b.getPages()>400).count();
        System.out.println("Libri con piu' di 400 pagine: "+libMax400Pag);

        
    }
}