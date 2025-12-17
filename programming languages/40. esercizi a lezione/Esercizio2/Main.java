
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Book> lista = Arrays.asList(
                new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 12.5, 310, 1937),
                new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 16, 310, 1937)
        );

        lista.stream().collect(Collectors.groupingBy(
                Book::getGenre,
                Collectors.counting()
        ))
                .entrySet()
                .stream()
                .forEach((entry) -> {
                    System.out.println(entry.getKey() + " -> " + entry.getValue());
                });

        lista.stream()
                .filter(l -> l.getPrice() >= 15)
                .collect(Collectors.groupingBy(
                        Book::getAuthor,
                        Collectors.mapping(Book::getTitle, Collectors.toList())
                ))
                .entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

        lista.stream()
                .collect(Collectors.groupingBy(
                        Book::getAuthor,
                        Collectors.summarizingInt(Book::getPages)
                ))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(
                        e -> e.getValue().getSum()
                ))
                .ifPresent(e
                        -> System.out.println(
                        e.getKey() + " -> " + e.getValue().getSum()
                )
                );

    }
}
