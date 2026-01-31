import java.io.ObjectOutputStream;

public class GeneraRilevazioni extends Thread {

    private ObjectOutputStream oos;
    private volatile boolean isRunning = true;

    public GeneraRilevazioni(ObjectOutputStream oos) {
        this.oos = oos;
    }

    @Override
    public void run() {
        while (isRunning) {
            int val = (int) (Math.random() * 201);
            long time = System.currentTimeMillis();

            Rilevazione r = new Rilevazione(val, time); // oggetto da inviare

            try {
                oos.writeObject(r); // invia l'oggetto
                oos.flush();
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void terminaRilevazione() {
        isRunning = false;
        interrupt(); // interrompe il thread
    }
}
