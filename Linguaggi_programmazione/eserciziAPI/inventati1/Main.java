import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<Song> songs = Arrays.asList(
      new Song("Blinding Lights", "The Weeknd", "Pop", 200, 2019, 3500000),
      new Song("Bohemian Rhapsody", "Queen", "Rock", 355, 1975, 5000000),
      new Song("Imagine", "John Lennon", "Rock", 183, 1971, 2800000),
      new Song("Shape of You", "Ed Sheeran", "Pop", 240, 2017, 6000000),
      new Song("Smells Like Teen Spirit", "Nirvana", "Rock", 301, 1991, 4200000),
      new Song("Bad Guy", "Billie Eilish", "Pop", 194, 2019, 3100000),
      new Song("Lose Yourself", "Eminem", "Hip-Hop", 326, 2002, 4500000),
      new Song("HUMBLE.", "Kendrick Lamar", "Hip-Hop", 177, 2017, 3900000)
    );

    // 1 - raggruppa le canzoni per genere e, per ogni genere, calcola la durata media delle canzoni
    Map<String, Double> durata = songs.stream().collect(Collectors.groupingBy(Song::getGenre, Collectors.averagingInt(Song::getDuration)));
    System.out.println("Durata media per genere: ");
    durata.forEach((genre, avg) ->
      System.out.printf("%s -> %.2f sec%n", genre, avg)
    );

    // 2 - considerando solo le canzoni pubblicate dal 2010 in poi, crea una Map<Artista, NumeroCanzoni>
    Map<String, Long> nCanzoni = songs.stream().filter(s -> s.getYear() >= 2010).collect(Collectors.groupingBy(Song::getArtist, Collectors.counting()));
    System.out.println("\nNumero di canzoni per artista (dal 2010): ");
    nCanzoni.forEach((artist, count) ->
      System.out.println(artist + " -> " + count)
    );

    // 3 - trova la canzone con il maggior numero di streams e stampala
    songs.stream().max(Comparator.comparingInt(Song::getStreams)).ifPresent(s -> System.out.println("\nCanzone più ascoltata:\n" + s));

    // 4 - crea una lista con i titoli delle canzoni Rock, ordinata per anno di uscita crescente
    List<String> rockOrdinate = songs.stream().filter(s -> s.getGenre().equals("Rock")).sorted(Comparator.comparing(Song::getYear)).map(Song::getTitle).collect(Collectors.toList());
    System.out.println("\nCanzoni Rock ordinate per anno: ");
    rockOrdinate.forEach(System.out::println);
  }
}
