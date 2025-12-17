
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Inception", "Christopher Nolan", "Sci-Fi", 2010, 148)
        );

        movies.stream()
                .collect(Collectors.groupingBy( // raggruppa in base al nome del director
                        Movie::getDirector, // imposta come chiave director
                        Collectors.averagingInt(Movie::getDuration) // calcola la durata media dei suoi film
                ))
                .entrySet() // restituisce le coppie chiave valore
                .stream()
                .forEach(e
                        -> System.out.println(e.getKey() + " -> " + e.getValue())
                );

    }
}
