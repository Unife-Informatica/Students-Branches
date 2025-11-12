
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Campi {

    private final List<Campo> listaCampi = new ArrayList<>();

    public Campi(String filePath) {
        loadDataFromFile(filePath);
    }

    private void loadDataFromFile(String filePath) {
        try (Scanner sc = new Scanner(new File(filePath))) {

            while (sc.hasNextLine()) {
                String[] header = sc.nextLine().trim().split(" ");
                if (header.length < 2) {
                    continue;
                }
                int codice = Integer.parseInt(header[0]);
                String sport = header[1].toLowerCase();

                if (!sc.hasNextLine()) {
                    break;
                }
                String nome = sc.nextLine().trim();

                if (!sc.hasNextLine()) {
                    break;
                }
                String[] commonParams = sc.nextLine().trim().split(" ");

                float larghezza = Float.parseFloat(commonParams[0]);
                float lunghezza = Float.parseFloat(commonParams[1]);

                if (sport.equals("tennis")) {
                    float tempMedia = Float.parseFloat(commonParams[2]);

                    if (!sc.hasNextLine()) {
                        break;
                    }
                    String terreno = sc.nextLine().trim();

                    if (!sc.hasNextLine()) {
                        break;
                    }
                    float costo = Float.parseFloat(sc.nextLine().trim());

                    listaCampi.add(new Tennis(codice, nome, larghezza, lunghezza, tempMedia, costo, terreno));
                } else if (sport.equals("squash")) {
                    float altezza = Float.parseFloat(commonParams[2]);
                    int piano = Integer.parseInt(commonParams[3]);
                    float costo = Float.parseFloat(commonParams[4]);

                    listaCampi.add(new Squash(codice, nome, larghezza, lunghezza, altezza, costo, piano));
                }
            }

        } catch (IOException e) {
            System.out.println("[Errore]: " + e.getMessage());
        }
    }

    public void printList() {
        System.out.println("Sport\tNome del campo\tCodice\tLarghezza\tLunghezza\tTemperatura\tTerreno\tAltezza\tPiano\tCosto");
        for (Campo c : listaCampi) {
            System.out.println(c);
        }
    }
}
