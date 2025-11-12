import java.util.List;
import java.util.ArrayList;

public class Main {
  public static void main() {
    List<Persona> gruppo = new ArrayList<>();

    gruppo.add(new Persona("Marco", "Rossi", 25));

    for (Persona persona : gruppo) {
      System.out.println(persona);
    }
  }
}
