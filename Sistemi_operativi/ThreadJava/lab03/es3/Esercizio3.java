package es3;

public class Esercizio3 {

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String args[]) {
        System.out.println("Esercizio3");

        int n = 10;

        // Creiamo un numero n di macchine
        Macchina macchine[] = new Macchina[n];

        // Creiamo l'oggetto produzione
        Produzione produzione = new Produzione();

        for (int i = 0; i < n; i++) {
            macchine[i] = new Macchina(produzione);
            macchine[i].start();
        }

        // Let's join our macchines
        for (int i = 0; i < n; i++) {
            try {
                macchine[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // produzione finale dovrebbe essere n * 35 = ...
        System.out.println("Produzione corretta: " + (n * 35));
        System.out.println("Produzione effettiva: ");
        produzione.stampaProduzione();
    }
}