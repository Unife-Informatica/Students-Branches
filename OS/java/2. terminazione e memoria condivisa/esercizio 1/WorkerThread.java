public class WorkerThread extends Thread {
    private int id;
    
    // "volatile" è fondamentale: garantisce che se il Main cambia questa variabile,
    // il WorkerThread veda IMMEDIATAMENTE il cambiamento e non usi una versione "in cache".
    private volatile boolean inEsecuzione = true;

    public WorkerThread(int id) {
        this.id = id;
    }

    // --- IL METODO RUN (Il lavoro del thread) ---
    @Override
    public void run() {
        System.out.println("Thread " + id + " avviato.");
        
        // Il thread continua a lavorare finché la variabile è true
        while (inEsecuzione) {
            try {
                System.out.println("Thread " + id + ": sto lavorando...");
                
                // Mettiamo il thread in pausa per 2 secondi per rendere l'output leggibile
                Thread.sleep(2000); 
                
            } catch (InterruptedException e) {
                // Se il thread viene interrotto mentre dorme, entriamo qui.
                // È buona norma ristabilire lo stato di interruzione o uscire.
                System.out.println("Thread " + id + " interrotto durante il sonno.");
            }
        }
        
        // Quando il while finisce (inEsecuzione diventa false), arriviamo qui
        System.out.println("Thread " + id + " TERMINATO correttamente.");
    }

    // stop() di Java perché è deprecato!
    // Creiamo un nostro metodo per dire al thread di fermarsi.
    public void arresta() {
        // 1. Cambiamo il flag: al prossimo giro del while, il thread uscirà.
        this.inEsecuzione = false;
        
        // 2. (Opzionale ma consigliato) Interrompiamo il thread se sta dormendo.
        // Senza questo, il thread aspetterebbe la fine dello sleep() prima di fermarsi.
        this.interrupt();
    }
}
