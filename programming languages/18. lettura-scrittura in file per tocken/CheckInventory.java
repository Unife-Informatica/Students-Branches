import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class CheckInventory {
    public static void main(String[] args) {
        String name;
        int units, count = 0;
        float price;
        String file = "inventory.dat";

        InventoryItem[] items = new InventoryItem[100];

        try {
            Scanner sc = new Scanner(new File(file));
            // Imposta il formato numerico su US (per leggere numeri con il punto)
            sc.useLocale(Locale.US);
            
            // Ciclo che legge i dati dal file finché ci sono parole disponibili
            while (sc.hasNext()) {
                name = sc.next();

                // Controlla se il prossimo dato è un intero
                if (sc.hasNextInt()) {
                    units = sc.nextInt(); // Se si lo legge
                } else {
                    // se no stampa un errore e passa alla riga successiva
                    System.out.println("Errore: unità non valida dopo " + name);
                    sc.nextLine();
                    continue;
                }

                if (sc.hasNextFloat()) {
                    price = sc.nextFloat();
                } else {
                    System.out.println("Errore: prezzo non valido dopo " + name + " " + units);
                    sc.nextLine();
                    continue;
                }

                // Se i dati sono validi, crea un nuovo oggetto InventoryItem e lo inserisce nell'array
                items[count++] = new InventoryItem(name, units, price);
            }

            sc.close();

            for (int i = 0; i < count; i++) {
                System.out.println(items[i]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File " + file + " non trovato.");
        }
    }
}
