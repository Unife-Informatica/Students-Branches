import java.util.*;
import java.util.stream.*;

public class FiltraggioDiFlusso {
  public static void main() {
    List<String> strings = List.of("one", "two", "three", "four");
    long count = strings.stream()
                        .map(String::length)
                        .filter(length -> length == 3)
                        .count();

System.out.println("count = " + count);
  }
}
