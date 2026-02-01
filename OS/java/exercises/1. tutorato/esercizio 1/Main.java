import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// --- 1. CLASSE ACCUMULATORE ---
// Questa è la classe che detiene il dato condiviso (il totale).
class Accumulatore {

    private double contatore;

    // Costruttore: inizializza il contatore con un valore di partenza
    public Accumulatore(double valoreIniziale) {
        this.contatore = valoreIniziale;
    }

    // Metodo per aggiungere un valore (richiesto dalla traccia)
    // NOTA: In un caso reale, qui servirebbe la parola chiave 'synchronized'
    // per evitare conflitti, ma la traccia dice di ignorare il problema.
    public void addValue(double value) {
        this.contatore = this.contatore + value;
    }

    // Metodo per leggere il valore attuale
    public double getValue() {
        return this.contatore;
    }
}

// --- 2. MODO A: IMPLEMENTARE RUNNABLE (Consigliato) ---
// Definiamo un compito che accetta l'accumulatore e vi aggiunge un numero.
class CounterRunnable implements Runnable {

    private Accumulatore accumulatore;

    // Costruttore: dobbiamo passare il riferimento all'accumulatore condiviso
    public CounterRunnable(Accumulatore acc) {
        this.accumulatore = acc;
    }

    @Override
    public void run() {
        // Generiamo un numero casuale
        double randomValue = Math.random();

        // Lo aggiungiamo all'accumulatore
        System.out.println(
            "Thread (Runnable) aggiunge: " + String.format("%.2f", randomValue)
        );
        accumulatore.addValue(randomValue);
    }
}

// --- 3. CLASSE MAIN ---
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Chiediamo all'utente il numero N di thread
        System.out.print("Inserisci il numero di thread (N): ");
        int n = scanner.nextInt();

        // 2. Creiamo l'oggetto Accumulatore (inizializzato a 0.0)
        Accumulatore acc = new Accumulatore(0.0);

        // Creiamo una lista per ricordarci tutti i thread creati.
        // Ci serve per poter chiamare 'join' su tutti loro dopo averli avviati.
        List<Thread> listaThread = new ArrayList<>();

        System.out.println("--- Avvio dei Thread ---");

        // 3. Ciclo per creare e lanciare N thread
        for (int i = 0; i < n; i++) {
            Thread t;

            // Creiamo l'istanza del compito (CounterRunnable)
            // Poi creiamo un oggetto Thread passandogli il compito
            Runnable compito = new CounterRunnable(acc);
            t = new Thread(compito);

            // Aggiungiamo il thread alla lista per gestirlo dopo
            listaThread.add(t);

            // FONDAMENTALE: start() avvia il thread. Se chiami run(), il codice è sequenziale!
            t.start();
        }

        // 4. Aspettiamo la terminazione dei thread
        // Il main deve fermarsi finché TUTTI gli aiutanti non hanno finito.
        for (Thread t : listaThread) {
            try {
                // join() dice: "Main, dormi finché 't' non muore (finisce)"
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 5. Stampa finale
        System.out.println("--- Tutti i thread hanno finito ---");
        System.out.println(
            "Valore finale nell'accumulatore: " + acc.getValue()
        );

        scanner.close();
    }
}
