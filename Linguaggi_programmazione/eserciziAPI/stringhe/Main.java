import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    String array[] = {"Mela", "Pera", "Arancia", "Fragola", "Kiwi", "Arancia"};
    Arrays.stream(array).distinct().forEach(s -> System.out.println());
  }
}
