import java.io.FileWriter;
import java.io.IOException;

public class ScritturaFile {
  public static void main() {
    String path = "prova.txt";
    try {
      FileWriter writer = new FileWriter(path);
      // nel caso il file non esista viene creato
      writer.write("Ciao, come va?\nContenuto su nuova riga");
      writer.append("\nRiga appesa");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
