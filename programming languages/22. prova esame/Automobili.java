
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Automobili {

    List<Automobile> listaAutomobili = new ArrayList<>();

    public Automobili(String filePath) {
        getDataFromFile(filePath);
    }

    private void getDataFromFile(String filePath) {
        try {
            try (Scanner sc = new Scanner(new File(filePath))) {
                while (sc.hasNext()) {
                    Automobile tmp = new Automobile();
                    // Type
                    if (sc.hasNext()) {
                        tmp.setTipo(sc.next().charAt(0));
                    }
                    // Modello
                    if (sc.hasNext()) {
                        tmp.setNome(sc.next());
                    }
                    // Produttore
                    if (sc.hasNext()) {
                        tmp.setProduttore(sc.next());
                    }
                    if (tmp.getTipo() == 'b') {
                        // Bagagliaio
                        if (sc.hasNextDouble()) {
                            tmp.setBagagliaio(sc.nextDouble());
                        }
                        // Peso
                        if (sc.hasNextInt()) {
                            tmp.setPeso(sc.nextInt());
                        }
                        // Codice
                        if (sc.hasNextInt()) {
                            tmp.setCodice(sc.nextInt());
                        }
                    }
                    if (tmp.getTipo() == 'f') {
                        // Marce
                        if (sc.hasNextInt()) {
                            tmp.setMarce(sc.nextInt());
                        }
                        // Peso
                        if (sc.hasNextInt()) {
                            tmp.setPeso(sc.nextInt());
                        }
                    }
                    // Codice
                    if (sc.hasNextInt()) {
                        tmp.setCodice(sc.nextInt());
                    }
                    listaAutomobili.add(tmp);
                }
            }
        } catch (IOException e) {
            System.out.println("[Errore]: " + e.getMessage());
        }
    }

    public void stampa() {
        System.out.println("Codice\tMarca\t\tModello\tBagagliaio\tMarce");
        for (Automobile a : listaAutomobili) {
            System.out.print(a.getCodice());
            System.out.print("\t" + a.getProduttore());
            System.out.print("\t\t" + a.getNome());
            System.out.print("\t" + a.getBagagliaio());
            System.out.print("\t" + a.getMarce() + "\n");
        }
    }

    public void printByCarContructor(String produttore) {
        for (Automobile a : listaAutomobili) {
            if (produttore.equalsIgnoreCase(a.getProduttore())) {
                System.out.print(a.getCodice());
                System.out.print("\t" + a.getProduttore());
                System.out.print("\t\t" + a.getNome());
                System.out.print("\t" + a.getBagagliaio());
                System.out.print("\t" + a.getMarce() + "\n");
            }
        }
    }
}
