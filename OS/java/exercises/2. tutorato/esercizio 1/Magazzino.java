import java.util.HashMap;
import java.util.Map;

public class Magazzino {
    // La memoria del magazzino: Nome Prodotto -> Quantità
    private Map<String, Integer> prodotti;

    public Magazzino() {
        this.prodotti = new HashMap<>();
    }

    // 1) Verifica se esiste un tipo di oggetto
    // synchronized: impedisce letture sporche mentre altri scrivono
    public synchronized boolean exists(String nomeProdotto) {
        simulaAttesa(); // Richiesto dalla traccia (500ms)
        return prodotti.containsKey(nomeProdotto);
    }

    // 2) Crea un nuovo tipo di oggetto (quantità 0)
    public synchronized void create(String nomeProdotto) {
        simulaAttesa();
        // Controllo di sicurezza: creo solo se non esiste già.
        // Se due thread provano a creare contemporaneamente, il secondo
        // troverà la chiave già presente grazie al synchronized e a questo check.
        if (!prodotti.containsKey(nomeProdotto)) {
            prodotti.put(nomeProdotto, 0);
            System.out.println(Thread.currentThread().getName() + " ha creato il prodotto: " + nomeProdotto);
        }
    }

    // 3a) Aggiungere quantità
    public synchronized void add(String nomeProdotto, int quantita) {
        simulaAttesa();
        // getOrDefault evita NullPointerException se il prodotto non esistesse (caso limite)
        int attuale = prodotti.getOrDefault(nomeProdotto, 0);
        prodotti.put(nomeProdotto, attuale + quantita);
        
        System.out.println(Thread.currentThread().getName() + " ha aggiunto " + quantita + " a " + nomeProdotto);
    }

    // 3b) Rimuovere quantità
    public synchronized void remove(String nomeProdotto, int quantita) {
        simulaAttesa();
        if (prodotti.containsKey(nomeProdotto)) {
            int attuale = prodotti.get(nomeProdotto);
            prodotti.put(nomeProdotto, attuale - quantita);
            System.out.println(Thread.currentThread().getName() + " ha rimosso " + quantita + " da " + nomeProdotto);
        }
    }

    // Helper per la pausa richiesta di 500ms
    private void simulaAttesa() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Override toString per stampare lo stato finale
    @Override
    public synchronized String toString() {
        return "Stato Magazzino: " + prodotti.toString();
    }
}
