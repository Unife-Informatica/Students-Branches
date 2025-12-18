import java.util.*;
import java.util.stream.*;

class Movie {

    private String title;
    private String director;
    private String genre;
    private int year;
    private int duration; // in minuti

    public Movie(
        String title,
        String director,
        String genre,
        int year,
        int duration
    ) {
        this.title = title;

        this.director = director;
        this.genre = genre;

        this.year = year;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return String.format(
            "%s (%d)-%s-%s- %d min",
            title,
            year,
            director,
            genre,
            duration
        );
    }
}

public class Movies {

    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Inception", "Christopher Nolan", "Sci-Fi", 2010, 148),
            new Movie(
                "The Godfather",
                "Francis Ford Coppola",
                "Crime",
                1972,
                175
            ),
            new Movie("Interstellar", "Christopher Nolan", "Sci-Fi", 2014, 169),
            new Movie("Pulp Fiction", "Quentin Tarantino", "Crime", 1994, 154),
            new Movie(
                "The Dark Knight",
                "Christopher Nolan",
                "Action",
                2008,
                152
            ),
            new Movie(
                "Django Unchained",
                "Quentin Tarantino",
                "Western",
                2012,
                165
            ),
            new Movie("Tenet", "Christopher Nolan", "Sci-Fi", 2020, 150)
        );

        // TODO: Calcola e stampa la durata media dei film per regista
        movies
            .stream()
            .collect(
                Collectors.groupingBy(
                    Movie::getDirector,
                    Collectors.averagingInt(Movie::getDuration)
                )
            )
            .entrySet()
            .stream()
            .forEach(System.out::println);
    }
}
