public class Produzione extends Thread {

    private int counter = 0;

    public synchronized void incremento() {
        counter++;
        try {
            if (counter % 4 == 0) {
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void stampaProduzione() {
        System.out.println("Pezzi prodotti: " + counter);
    }
}
