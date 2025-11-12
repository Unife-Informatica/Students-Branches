import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Reperti {
    private final List<Reperto> listaReperti = new LinkedList<>();

    public Reperti(String filePath) {
        loadDataFromFile(filePath);
    }

    private void loadDataFromFile(String filePath) {
        try(Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine()) {
                String getLine = sc.nextLine();
                if(getLine.isEmpty()) {
                    continue;
                }
                String[] line = getLine.split(" ");
                int codice = Integer.parseInt(line[0]);
                String tipo = line[1];
                String descrizione = sc.nextLine();
                line = sc.nextLine().split(" ");
                int anno = Integer.parseInt(line[0]);
                String collocazione = line[1];

                if (tipo.equalsIgnoreCase("geologico")) {
                    float eta = Float.parseFloat(sc.nextLine());
                    String ritrovamento = sc.nextLine();
                    int peso = Integer.parseInt(sc.nextLine());
                    listaReperti.add(new Geologico(codice, anno, collocazione, peso, tipo, descrizione, ritrovamento, eta));
                }
                if (tipo.equalsIgnoreCase("biologico")) {
                    line = sc.nextLine().split(" ");
                    char fossile = line[0].charAt(0);
                    int peso = Integer.parseInt(line[1]);
                    String specie = sc.nextLine();
                    String ritrovamento = sc.nextLine();
                    listaReperti.add(new Biologico(codice, anno, collocazione, peso, tipo, descrizione, ritrovamento, fossile, specie));
                }
            }
        } catch(IOException e) {
            System.err.println("[Errore]: " + e.getMessage());
        }
    }

    public void printList() {
        System.out.println("Tipo\tCodice\tDescrizione\tAnno\tCollocazione\tPeso\tLuogo\tEtà\tFossile\tSpecie");
        for(Reperto r : listaReperti) {
            System.out.println(r);
        }
    }
}
