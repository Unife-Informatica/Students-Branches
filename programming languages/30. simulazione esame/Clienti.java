
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Clienti {

    List<Cliente> listaClienti = new LinkedList<>();

    public Clienti(String filePath) {
        loadDataFromFile(filePath);
    }

    public List<Cliente> getList() {
        return listaClienti;
    }

    private void loadDataFromFile(String filePath) {
        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine()) {
                int codice = Integer.parseInt(sc.nextLine());
                String nome = sc.nextLine();
                Map<Integer, Double> servizi = new HashMap<>();
                while (sc.hasNextLine()) {
                    String getLine = sc.nextLine();
                    if(getLine.isEmpty()) break;
                    String[] line = getLine.split(" ");
                    int codiceDipendente = Integer.parseInt(line[0]);
                    double ore = Double.parseDouble(line[1]);
                    servizi.put(codiceDipendente, ore);
                }
                listaClienti.add(new Cliente(codice, nome, servizi));
            }
        } catch (IOException e) {
            System.out.println("[Errore]: " + e.getMessage());
        }
    }

    public void printList() {
        for (Cliente c : listaClienti) {
            System.out.println(c);
        }
    }
}
