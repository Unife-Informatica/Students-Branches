
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Soci {
    List<Socio> listaSoci = new ArrayList<>();

    public Soci(String filePath) {
        loadDataFromFile(filePath);
    }

    private void loadDataFromFile(String filePath) {
        try(Scanner sc = new Scanner(new File(filePath))) {
            while(sc.hasNextLine()) {
                List<Prenotazione> listaPrenotazioni = new ArrayList<>();
                String[] line = sc.nextLine().split(" ");
                int codice = Integer.parseInt(line[0]);
                String nome = sc.nextLine();
                line = sc.nextLine().split(" ");
                int eta = Integer.parseInt(line[0]);
                int categoria = Integer.parseInt(line[1]);
                line = sc.nextLine().split(" ");
                for (int i = 0; i + 1 < line.length; i += 2) {
                    int codiceCampo = Integer.parseInt(line[i]);
                    int oraInizio = Integer.parseInt(line[i + 1]);
                    listaPrenotazioni.add(new Prenotazione(codiceCampo, oraInizio));
                }
                listaSoci.add(new Socio(codice, nome, eta, categoria, listaPrenotazioni));
            }
        } catch(IOException e) {
            System.out.println("[Errore]: " + e.getMessage());
        }
    }

    public void printList() {
        System.out.println("Codice\tNome\tEtà\tCategoria\tPrenotazioni");
        for(Socio s : listaSoci) {
            System.out.println(s);
        }
    }
    
    public List<Socio> getList() {
        return listaSoci;
    }
}
