import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class LetturaFile {
  public static void main() {
    String path = "prova.txt";
    try {
      FileReader reader = new FileReader(path);
      int data = reader.read();

      while (data != -1) {
        System.out.print((char)data);
        data = reader.read();
      }

      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Il file " + path + " non esiste.");
    }catch (IOException e) {
      System.out.println("Si è verificato un errore durante la lettura del file " + path);
    }
  }
}
