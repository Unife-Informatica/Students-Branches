public class Macchina extends Thread {

    Produzione produzione;

    public Macchina(Produzione p) {
        produzione = p;
    }

    // le operazioni che si voglio fare in fase di creazione (dentro il costruttore)
    // vanno inserite in run() altrimenti si causa un interruzione sul main thread
    @Override
    public void run() {
        for (int i = 0; i < 35; i++) {
            produzione.incremento();
        }
    }
}
