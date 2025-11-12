import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ricercatori {
    List<Ricercatore> listaRicercatori = new LinkedList<>(); 
    public Ricercatori(String filePath) {
        loadDataFromFile(filePath);
    }

    private void loadDataFromFile(String filePath) {
        try(Scanner sc = new Scanner(new File(filePath))) {
            while(sc.hasNextLine()) {
                int codice = Integer.parseInt(sc.nextLine());
                String nome = sc.nextLine();
                List<RepertiConsultati> listaConsultazioni = new LinkedList<>();
                while(sc.hasNextLine()) {
                    String getLine = sc.nextLine();
                    if(getLine.isEmpty()) {
                        break;
                    }
                    String[] line = getLine.split(" ");
                    int codiceArticolo = Integer.parseInt(line[0]);
                    int consultazioni = Integer.parseInt(line[1]);
                    listaConsultazioni.add(new RepertiConsultati(codiceArticolo, consultazioni));
                }
                listaRicercatori.add(new Ricercatore(codice, nome, listaConsultazioni));
            }
        } catch (IOException e) {
            System.err.println("[Errore]: " + e.getMessage());
        }
    }

    public void printList() {
        System.out.println("Codice\tNome\tNumero consultazioni\tConsultazioni");
        for(Ricercatore r : listaRicercatori) {
            System.out.println(r);
        }
    }

    public String getNameById(int id) throws UserNotFoundException {
        for(Ricercatore r : listaRicercatori) {
            if (id == r.getCodice()) {
                return r.getNome();
            }
        }
        throw new UserNotFoundException();
    }

    public float getMediaConsulatazione(int id) throws UserNotFoundException {
        for(Ricercatore r : listaRicercatori) {
            if(r.getCodice() == id) {
                float nGiorni = 0;
                float nConsultazioni = 0;
                for(RepertiConsultati reperti : r.getRepertiConsultati()) {
                    nGiorni += reperti.getNumeroGiorni();
                    nConsultazioni++;
                }
                return nGiorni / nConsultazioni;
            }
        }
        throw new UserNotFoundException();
    }
}
