
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Prodotti {

    private final List<Prodotto> listaProdotti = new ArrayList<>();
    private final HashMap<String, Integer> nOpere = new HashMap<>();

    public Prodotti(String filePath) {
        loadDataFromFile(filePath);
    }

    private void loadDataFromFile(String filePath) {
        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine()) {
                String type, titolo, autore, isbn;
                int codice, prezzo, durata;
                String[] header = sc.nextLine().split(" ");

                type = header[0];
                codice = Integer.parseInt(header[1]);

                titolo = sc.nextLine();
                autore = sc.nextLine();
                prezzo = Integer.parseInt(sc.nextLine());

                if (type.equals("libro")) {
                    isbn = sc.nextLine();
                    listaProdotti.add(
                            new Libro(codice, titolo, autore, prezzo, isbn)
                    );
                }

                if (type.equals("CD")) {
                    durata = Integer.parseInt(sc.nextLine());
                    listaProdotti.add(
                            new CD(codice, titolo, autore, prezzo, durata)
                    );
                }
            }
        } catch (IOException e) {
            System.out.println(
                    "[Errore]: errore durante la lettura di: " + filePath
            );
        }
    }

    public void printVendite() {
        System.out.println("TIPO\tCODICE\tTITOLO\tAUTORE\tPREZZO\tISBN\tDURATA");
        System.out.println(listaProdotti.size());
        for (Prodotto p : listaProdotti) {
            System.out.println(p);
        }
    }

    public HashMap<String, Integer> prodottiPerAutore() {
        for(Prodotto p : listaProdotti) {
            nOpere.put(p.getAutore(), nOpere.getOrDefault(p.getAutore(), 0) + 1);
        }
        return nOpere;
    }

    public double prezzoMedio() {
        double somma = 0.0;
        for(Prodotto p : listaProdotti) {
            somma += p.getPrezzo();
        }
        return somma / listaProdotti.size();
    }
}
