import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. CREAZIONE DELLE PIPE
            // Creiamo l'estremità di uscita (da cui ToOutput leggerà)
            PipedInputStream pipeIn = new PipedInputStream();
            
            // Creiamo l'estremità di entrata (dove FromInput scriverà)
            PipedOutputStream pipeOut = new PipedOutputStream();

            // 2. CONNESSIONE (Passaggio Logico Fondamentale)
            // Dobbiamo collegare l'entrata all'uscita, altrimenti non comunicano.
            // Se dimentichi questo passaggio, otterrai un'eccezione.
            pipeOut.connect(pipeIn);

            System.out.println("--- Avvio del sistema (Digita 'fine' per terminare) ---");

            // 3. CREAZIONE DEI THREAD
            // Passiamo a ciascun thread l'estremità del tubo che gli compete.
            FromInput threadScrittore = new FromInput(pipeOut);
            ToOutput threadLettore = new ToOutput(pipeIn);

            // 4. AVVIO
            threadScrittore.start();
            threadLettore.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
