import java.io.IOException;
import java.io.OutputStream; // Usiamo la classe astratta generica
import java.util.Scanner;

public class FromInput extends Thread {
    // Variabile per mantenere il riferimento al tubo dove scrivere
    private OutputStream outputStream;

    // Costruttore: riceve il tubo dal Main
    public FromInput(OutputStream out) {
        this.outputStream = out;
    }

    @Override
    public void run() {
        // Scanner per leggere dalla tastiera
        Scanner scanner = new Scanner(System.in);
        
        try {
            while (true) {
                String messaggio = scanner.nextLine();

                // Controllo per terminare il programma
                if (messaggio.equals("fine")) {
                    break; // Esce dal ciclo
                }

                // Convertiamo la stringa in un array di byte grezzi
                byte[] dati = messaggio.getBytes();

                // Scriviamo i byte nel tubo
                outputStream.write(dati);
                
                // IMPORTANTE: flush() forza l'invio immediato dei dati
                // Senza flush, i dati potrebbero rimanere fermi in un buffer interno
                outputStream.flush();
            }
            
            // Chiudiamo il tubo quando abbiamo finito
            outputStream.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
