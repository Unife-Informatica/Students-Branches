import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il numero di Operatori (N): ");
        int n = scanner.nextInt();

        // 1. Creiamo la risorsa condivisa (UNA SOLA istanza per tutti)
        Magazzino magazzinoCondiviso = new Magazzino();

        // Lista per tenere traccia dei thread e fare il join
        List<Thread> threadList = new ArrayList<>();

        System.out.println("--- Inizio Operazioni Magazzino ---");

        // 2. Creazione e avvio dei thread
        for (int i = 0; i < n; i++) {
            // Creiamo il task Runnable
            Operatore task = new Operatore(magazzinoCondiviso);
            // Creiamo il Thread assegnandogli un nome (es. Operatore-0)
            Thread t = new Thread(task, "Operatore-" + i);
            threadList.add(t);
            t.start();
        }

        // 3. Attesa della terminazione (Join)
        for (Thread t : threadList) {
            try {
                t.join(); // Il main aspetta che t finisca
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("--- Tutte le operazioni completate ---");

        // 4. Verifica Finale
        System.out.println(magazzinoCondiviso.toString());
        
        // Calcolo teorico per verifica
        // Ogni operatore fa +1000 e -500. Risultato netto: +500 per operatore.
        int valoreAtteso = n * 500;
        System.out.println("Valore atteso ('bulloni'): " + valoreAtteso);
        
        scanner.close();
    }
}
