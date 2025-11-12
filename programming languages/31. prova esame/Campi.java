
import java.util.*;
import java.io.*;

public class Campi {

    private final List<Campo> listaCampi = new ArrayList<>();

    public Campi(String filePath) {
        loadDataFromFile(filePath);
    }

    private void loadDataFromFile(String filePath) {
        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(" ");
                int codice = Integer.parseInt(line[0]);
                String tipo = line[1];
                String nome = sc.nextLine();
                line = sc.nextLine().split(" ");
                float lunghezza = Float.parseFloat(line[0]);
                float larghezza = Float.parseFloat(line[1]);
                if (tipo.equalsIgnoreCase("tennis")) {
                    float tempMedia = Float.parseFloat(line[2]);
                    String terreno = sc.nextLine();
                    float costo = Float.parseFloat(sc.nextLine());
                    listaCampi.add(new Tennis(codice, costo, larghezza, lunghezza, nome, tempMedia, terreno));
                }
                if (tipo.equalsIgnoreCase("squash")) {
                    float altezza = Float.parseFloat(line[2]);
                    int piano = Integer.parseInt(line[3]);
                    float costo = Float.parseFloat(line[4]);
                    listaCampi.add(new Squash(codice, costo, larghezza, lunghezza, nome, altezza, piano));
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

    private float getCostoCampo(int id) throws Exception {
        for (Campo c : listaCampi) {
            if (c.getCodice() == id) {
                return c.getCosto();
            }
        }
        throw new Exception("il campo " + id + " non esiste");
    }

    public float incassoTotale(int id, List<Socio> listaSoci) throws Exception {
        int count = 0;

        for (Socio s : listaSoci) {
            for (Prenotazione p : s.getListaPrenotazioni()) {
                if (p.getCodice() == id) {
                    count++;
                }
            }
        }

        float costo = getCostoCampo(id);
        return count * costo;
    }

}
