import java.io.IOException;
import java.io.InputStream; // Usiamo la classe astratta generica

public class ToOutput extends Thread {
    // Variabile per mantenere il riferimento al tubo da cui leggere
    private InputStream inputStream;

    // Costruttore: riceve il tubo dal Main
    public ToOutput(InputStream in) {
        this.inputStream = in;
    }

    @Override
    public void run() {
        // Creiamo un buffer (un contenitore) per i byte in arrivo.
        // 1024 è una dimensione arbitraria sufficiente per piccoli messaggi.
        byte[] buffer = new byte[1024];
        int byteLetti;

        try {
            // Il metodo read() è BLOCCANTE.
            // Il thread si ferma qui e aspetta che arrivino dati nel tubo.
            // Restituisce il numero di byte effettivamente letti, oppure -1 se il tubo è chiuso.
            while ((byteLetti = inputStream.read(buffer)) != -1) {
                
                // Convertiamo i byte ricevuti di nuovo in Stringa
                // Usiamo il costruttore: new String(array, offset, lunghezza)
                // Per convertire solo i byte validi appena letti
                String messaggioRicevuto = new String(buffer, 0, byteLetti);

                // Stampiamo su Standard Output
                System.out.println("[ToOutput] Ricevuto: " + messaggioRicevuto);
            }
            
            System.out.println("[ToOutput] Comunicazione chiusa.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
