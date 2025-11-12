import java.io.*;

public class Tabelline {
  public static void main(String[] args) throws IOException {
    /*
     * utilizzo l'oggetto FileWriter(a basso livello) e successivamente
     * PrintWriter(ad alto livello) per espandere le funzionalità
     * della classe precedente
     */
    FileWriter fw = new FileWriter("tabelline.txt");
    PrintWriter outFile = new PrintWriter(fw);
    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= 10; j++) {
        outFile.print((i * j) + " ");
      }
      outFile.println(); // rimanda a capo
    }
    outFile.close();
  }
}
