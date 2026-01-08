import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        // ===============================
        // CREAZIONE LISTA FILM
        // ===============================
        // Creo una lista di film contenente informazioni su:
        // titolo, regista, genere, anno di uscita e durata in minuti.
        // Questa lista verrà utilizzata per esercizi con le Stream API.
        List<Movie> movies = Arrays.asList(
                new Movie("Inception", "Christopher Nolan", "Sci-Fi", 2010, 148),
                new Movie("The Godfather", "Francis Ford Coppola", "Crime", 1972, 175),
                new Movie("Interstellar", "Christopher Nolan", "Sci-Fi", 2014, 169),
                new Movie("Pulp Fiction", "Quentin Tarantino", "Crime", 1994, 154),
                new Movie("The Dark Knight", "Christopher Nolan", "Action", 2008, 152),
                new Movie("Django Unchained", "Quentin Tarantino", "Western", 2012, 165),
                new Movie("Tenet", "Christopher Nolan", "Sci-Fi", 2020, 150)
        );

        // ======================================================
        // DURATA MEDIA DEI FILM PER REGISTA
        // ======================================================
        // Raggruppo i film per regista e, per ciascun regista,
        // calcolo la durata media dei suoi film.
        // Il risultato è una Map<Regista, DurataMedia>.
        System.out.println("Durata media dei film per regista");

        movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getDirector,
                        Collectors.averagingDouble(Movie::getDuration)
                ))
                .forEach((regista, media) -> {
                    System.out.println("\t" + regista + " -> " + media + " min");
                });

        // ======================================================
        // DURATA TOTALE DEI FILM PER GENERE
        // ======================================================
        // Raggruppo i film per genere e sommo la durata totale
        // dei film appartenenti a ciascun genere.
        System.out.println("\nDurata totale dei film per genere");

        movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.summingLong(Movie::getDuration)
                ))
                .forEach((genere, totale) -> {
                    System.out.println("\t" + genere + " -> " + totale + " min");
                });

        // ======================================================
        // FILM DAL 2010 IN POI PER REGISTA
        // ======================================================
        // Seleziono solo i film usciti dal 2010 in poi,
        // li raggruppo per regista e stampo i titoli dei film.
        System.out.println("\nFilm dal 2010 in poi per regista");

        movies.stream()
                .filter(f -> f.getYear() >= 2010)
                .collect(Collectors.groupingBy(Movie::getDirector))
                .forEach((regista, film) -> {
                    System.out.println(regista);
                    film.forEach(f ->
                            System.out.println("\t" + f.getTitle())
                    );
                });

        // ======================================================
        // FILM CON DURATA MASSIMA
        // ======================================================
        // Trovo il film con la durata massima confrontando
        // la durata di tutti i film presenti nella lista.
        System.out.println("\nFilm con la durata massima");

        Movie maxTimeFilm =
                movies.stream()
                        .max(Comparator.comparingLong(Movie::getDuration))
                        .orElseThrow();

        System.out.println("\t" + maxTimeFilm.getTitle()
                + " -> " + maxTimeFilm.getDuration() + " min");

        // ======================================================
        // DURATA TOTALE DEI FILM PER REGISTA
        // ======================================================
        // Raggruppo i film per regista e sommo la durata totale
        // dei film diretti da ciascun regista.
        System.out.println("\nDurata totale dei film per regista");

        Map<String, Long> durataTotalePerRegista =
                movies.stream()
                        .collect(Collectors.groupingBy(
                                Movie::getDirector,
                                Collectors.summingLong(Movie::getDuration)
                        ));

        durataTotalePerRegista.forEach((regista, totale) -> {
            System.out.println("\t" + regista + " -> " + totale + " min");
        });

        // ======================================================
        // GENERE CON IL MAGGIOR NUMERO DI FILM
        // ======================================================
        // Raggruppo i film per genere contando quanti film
        // appartengono a ciascun genere, poi seleziono il massimo.
        System.out.println("\nGenere con il maggior numero di film");

        Map.Entry<String, Long> genereMaxFilm =
                movies.stream()
                        .collect(Collectors.groupingBy(
                                Movie::getGenre,
                                Collectors.counting()
                        ))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .orElseThrow();

        System.out.println("\t" + genereMaxFilm.getKey()
                + " -> " + genereMaxFilm.getValue());

        // ======================================================
        // REGISTA CON IL MAGGIOR NUMERO DI FILM
        // ======================================================
        // Raggruppo i film per regista contando il numero
        // di film diretti da ciascuno e trovo il massimo.
        System.out.println("\nRegista con il maggior numero di film");

        Map.Entry<String, Long> registaMaxFilm =
                movies.stream()
                        .collect(Collectors.groupingBy(
                                Movie::getDirector,
                                Collectors.counting()
                        ))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .orElseThrow();

        System.out.println("\t" + registaMaxFilm.getKey()
                + " -> " + registaMaxFilm.getValue());

        // ======================================================
        // FILM PIÙ RECENTE CON DURATA > 150 MINUTI
        // ======================================================
        // Seleziono solo i film con durata superiore a 150 minuti
        // e, tra questi, trovo quello più recente.
        System.out.println("\nFilm più recente con durata > 150 minuti");

        Movie mostRecentFilm =
                movies.stream()
                        .filter(f -> f.getDuration() > 150)
                        .max(Comparator.comparingInt(Movie::getYear))
                        .orElseThrow();

        System.out.println("\t" + mostRecentFilm.getTitle()
                + " -> " + mostRecentFilm.getYear());
    }
}
