import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
      List<Match> matches = Arrays.asList(
        new Match("Lakers", "Warriors", 102, 99, "Basket", 2021),
        new Match("Juventus", "Inter", 1, 1, "Calcio", 2022),
        new Match("Barcelona", "Real Madrid", 2, 0, "Calcio", 2021),
        new Match("Nets", "Celtics", 110, 115, "Basket", 2022),
        new Match("Federer", "Nadal", 3, 2, "Tennis", 2019),
        new Match("Milan", "Napoli", 2, 2, "Calcio", 2023),
        new Match("Bulls", "Heat", 98, 101, "Basket", 2023),
        new Match("Djokovic", "Thiem", 3, 0, "Tennis", 2021)
      );

      // 1 - Raggruppa i match per sport e conta quante partite ci sono per sport
      Map<String, Long> countMatch = matches.stream().collect(Collectors.groupingBy(Match::getSport, Collectors.counting()));
      System.out.println("Numero di match per sport:");
      countMatch.forEach((sport, count) -> System.out.println(sport + " -> " + count));

      // 2 - Trova il match con il punteggio totale più alto (homeScore + awayScore)
      matches.stream().max(Comparator.comparingInt(m -> m.getHomeScore() + m.getAwayScore())).ifPresent(m -> System.out.println(m));

      // 3 - Filtra tutti i match finiti in parità e crea una lista delle squadre coinvolte
      List<String> draws = matches.stream().filter(Match::isDraw).flatMap(m -> Stream.of(m.getHomeTeam(), m.getAwayTeam())).distinct().collect(Collectors.toList());
      System.out.println("\nSquadre coinvolte in match finiti in parità:");
      draws.forEach(System.out::println);
    }
}
