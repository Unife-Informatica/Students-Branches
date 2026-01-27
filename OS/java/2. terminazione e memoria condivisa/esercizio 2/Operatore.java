import java.util.Random;

public class Operatore implements Runnable {
    private Magazzino magazzino;
    // (Opzionale) Random per pause casuali tra le operazioni
    private Random random = new Random();

    public Operatore(Magazzino magazzino) {
        this.magazzino = magazzino;
    }

    @Override
    public void run() {
        String prodotto = "bulloni";

        // --- SEQUENZA DI ISTRUZIONI RICHIESTA ---

        // 1. Verifica esistenza
        // Nota: Anche se qui ritorna false, un altro thread potrebbe crearlo 
        // un millisecondo dopo. La robustezza deve essere nel metodo create() del Magazzino.
        boolean esiste = magazzino.exists(prodotto);

        // 2. Creazione se non esiste
        if (!esiste) {
            magazzino.create(prodotto);
        } else {
            // (Opzionale) Log per debug
            // System.out.println(Thread.currentThread().getName() + ": prodotto già esistente.");
        }

        // Pausa opzionale per aumentare il caos (threading)
        pauseRandom();

        // 3. Aggiunta di 1000 pezzi
        magazzino.add(prodotto, 1000);

        pauseRandom();

        // 4. Eliminazione di 500 pezzi
        magazzino.remove(prodotto, 500);
    }

    // Metodo opzionale richiesto dalla traccia per pause random
    private void pauseRandom() {
        try {
            // Pausa tra 0 e 200ms
            Thread.sleep(random.nextInt(200)); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
