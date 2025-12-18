import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Inception", "Christopher Nolan", "Sci-Fi", 2010, 148),
                new Movie("The Godfather", "Francis Ford Coppola", "Crime", 1972, 175),
                new Movie("Interstellar", "Christopher Nolan", "Sci-Fi", 2014, 169),
                new Movie("Pulp Fiction", "Quentin Tarantino", "Crime", 1994, 154),
                new Movie("The Dark Knight", "Christopher Nolan", "Action", 2008, 152),
                new Movie("Django Unchained", "Quentin Tarantino", "Western", 2012, 165),
                new Movie("Tenet", "Christopher Nolan", "Sci-Fi", 2020, 150));

        //Raggruppa i film per regista e stampa la durata media dei film di ciascun regista.
        System.out.println("Raggruppa i film per regista e stampa la durata media dei film di ciascun regista.");
        movies.stream().collect(Collectors.groupingBy(Movie::getDirector,Collectors.averagingDouble(Movie::getDuration))).forEach((regista,tempo)->{
            System.out.println("\t"+regista+" -> "+tempo+"min");
        });
        
        //Raggruppa i film per genere e stampa, per ogni genere, la durata totale dei film.
        System.out.println("Raggruppa i film per genere e stampa, per ogni genere, la durata totale dei film");
        movies.stream().collect(Collectors.groupingBy(Movie::getGenre,Collectors.summingLong(Movie::getDuration))).forEach((genere,tempo)->{
            System.out.println("\t"+genere+" -> "+tempo+"min");
        });

        //Considera solo i film usciti dal 2010 in poi, raggruppali per regista e stampa i titoli dei film.
        System.out.println("Film usciti dal 2010 in poi, raggruppati per regista e stampa i titoli dei film");
        movies.stream().filter(n->n.getYear()>2010).collect(Collectors.groupingBy(Movie::getDirector)).forEach((regista,film)->{
            System.out.println(regista);
            film.forEach(n->System.out.println("\t"+n.getTitle()));
        });

        //Trova il film con la durata massima e stampa
        System.out.println("\nFilm con la durata massima");
        Movie maxTimeFilm = movies.stream().max(Comparator.comparingLong(Movie::getDuration)).orElseThrow();
        System.out.println("\t"+maxTimeFilm.getTitle()+"->"+maxTimeFilm.getDuration());

        //Raggruppa i film per regista e stampa la durata totale dei suoi film
        System.out.println("Film per regista e stampa la durata totale dei suoi film");
        Map<String,Long> mDirTimeTot = movies.stream().collect(Collectors.groupingBy(Movie::getDirector,Collectors.summingLong(Movie::getDuration)));
        mDirTimeTot.forEach((regista,tempo)->{
            System.out.println("\t"+regista+"->"+tempo);
        });

        //Trova il genere con il maggior numero di film e stampa
        Map.Entry<String,Long> genMaxFilm = movies.stream().collect(Collectors.groupingBy(Movie::getGenre,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();
    }
}
