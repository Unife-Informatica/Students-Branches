
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Dipendenti {
    private final List<Dipendente> listaDipendenti = new LinkedList<>();

    public Dipendenti(String filePath) {
        loadDataFromFile(filePath);
    }

    private void loadDataFromFile(String filePath) {
        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(" ");
                int id = Integer.parseInt(line[0]);
                String tipo = line[1];
                String nome = sc.nextLine();
                if (tipo.equalsIgnoreCase("trainer")) {
                    line = sc.nextLine().split(" ");
                    int ore = Integer.parseInt(line[0]);
                    double costo = Double.parseDouble(line[1]);
                    String specialita = sc.nextLine();
                    listaDipendenti.add(new Trainer(id, nome, ore, costo, specialita));
                }
                if (tipo.equalsIgnoreCase("nutrizionista")) {
                    line = sc.nextLine().split(" ");
                    int telefono = Integer.parseInt(line[0]);
                    boolean medico = Boolean.parseBoolean(line[1]);
                    int appuntamenti = Integer.parseInt(line[2]);
                    double costo = Double.parseDouble(line[3]);
                    listaDipendenti.add(new Nutrizionista(id, nome, telefono, appuntamenti, medico, costo));
                }
            }
        } catch (IOException e) {
            System.out.println("[Errore]: " + e.getMessage());
        }
    }

    public double getCostoDipendente(int id) {
        for(Dipendente d : listaDipendenti) {
            if(d.getCodice() == id) {
                return d.getCosto();
            }
        }
        return 0.0;
    }

    public void printList() {
        System.out.println("Nome\tCodice\tTipo\tOre\tSpecialità\tTelefono\tMedico\tApp.Set.\tCosto");
        for(Dipendente p : listaDipendenti) {
            System.out.println(p);
        }
    }

    public String getNameById(int id) {
        for(Dipendente d : listaDipendenti) {
            if(id == d.getCodice()) {
                return d.getNome();
            }
        }
        return "";
    }

    public void printMigliore(List<Cliente> list) {
        Map<Integer, Integer> listaServizi = new HashMap<>();
        for(Cliente c : list) {
            for (Integer servizi : c.getServizi().keySet()) {
                listaServizi.put(servizi, listaServizi.getOrDefault(servizi, 0) + 1);
            }
        }

        int max = 0, iMax = -1;
        for(Integer i : listaServizi.keySet()) {
            if(max < listaServizi.get(i)) {
                max = listaServizi.get(i);
                iMax = i;
            }
        }
        
        System.out.println("Il migliore è " + getNameById(iMax) + " con " + max + " servizi");
    }
}
