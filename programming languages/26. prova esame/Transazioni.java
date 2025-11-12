import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Transazioni {

    private List<Transazione> transitions = new ArrayList<>();
    private HashMap<String, Integer> copieVendute = new HashMap<>();

    public Transazioni(String filePath) {
        getDataFromFile(filePath);
    }

    public void getDataFromFile(String filePath) {
        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine()) {
                String header = sc.nextLine().trim();

                if (header.isEmpty()) continue;

                String[] parts = header.split(" ");
                if (parts.length < 4) {
                    System.out.println(
                        "[Errore]: Intestazione non valida: " + header
                    );
                    continue;
                }

                char tipo = parts[0].charAt(0);
                int id = Integer.parseInt(parts[1]);
                String data = parts[2];
                String locationOrIp = parts[3];

                List<Libro> listaLibri = new ArrayList<>();

                while (sc.hasNextLine()) {
                    String titolo = sc.nextLine().trim();
                    if (titolo.isEmpty()) break;

                    if (!sc.hasNextLine()) break;
                    String autore = sc.nextLine().trim();

                    if (!sc.hasNextLine()) break;
                    String prezzoStr = sc.nextLine().trim();

                    int prezzo;
                    try {
                        prezzo = Integer.parseInt(prezzoStr);
                    } catch (NumberFormatException e) {
                        System.out.println(
                            "[Errore]: Prezzo non valido per libro \"" +
                                titolo +
                                "\": " +
                                prezzoStr
                        );
                        continue;
                    }

                    listaLibri.add(new Libro(titolo, autore, prezzo));
                }

                if (tipo == 'f') {
                    transitions.add(
                        new Fisica(id, data, listaLibri, locationOrIp)
                    );
                } else if (tipo == 'o') {
                    transitions.add(
                        new Online(id, data, listaLibri, locationOrIp)
                    );
                } else {
                    System.out.println(
                        "[Errore]: Tipo di transazione non riconosciuto: " +
                            tipo
                    );
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("[Errore]: File non trovato: " + filePath);
        }
    }

    public void printTable() {
        System.out.println("ID\tData\t\tCittà\tIndirizzo IP\tTotale");

        for (Transazione t : transitions) {
            System.out.println(t);
        }
    }

    public HashMap<String, Integer> stampaCopieVendute() {
        for (Transazione t : transitions) {
            for (Libro l : t.libri) {
                String key = l.getTitolo() + " - " + l.getAutore();
                copieVendute.put(key, copieVendute.getOrDefault(key, 0) + 1);
            }
        }

        return copieVendute;
    }

    public int getIncasso() {
        int totale = 0;
        for (Transazione t : transitions) {
            totale += t.getTotale();
        }
        return totale;
    }
}
