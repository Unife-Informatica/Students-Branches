import java.util.*;
import java.util.stream.*;

public class MapFilterReduce {
  public static void main() {
    List<City> cities = new ArrayList<>();
    cities.add(new City("rome", 3_000_000));
    cities.add(new City("milan", 2_000_000));
    cities.add(new City("mantua", 75_000));

    int sum = cities.stream()
                    .map(City::getPopulation)
                    .filter(population -> population > 1_000_000)
                    .mapToInt(Integer::intValue)
                    .sum();

    System.out.println(sum);
  }
}

class City {
  String name;
  int population;

  public City(String name, int population) {
    this.name = name;
    this.population = population;
  }

  public int getPopulation() {
    return population;
  }
}
