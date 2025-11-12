import java.io.File;
import java.io.IOException;

public class CreazioneFile {
  public static void main() {
    String path = "./prova.txt";
    try {
      /*
       * la creazione di un'istanza di File non genera la creazione 
       * fisica del file sul disco fisso
       */
      File file = new File(path);

      if (file.exists()) {
        System.out.println("Il file " + path + " non esiste.");
      } else if (file.createNewFile()) {
        System.out.println("Il file " + path + " è stato creato.");
      } else {
        System.out.println("Il file " + path + " è già esistente.");
      }
    } catch (IOException e) {
      System.out.println("Errore durante la creazione di " + path);
      e.printStackTrace();
    }
  }
}
