import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class RilevatoreAria extends Thread {

    private OutputStream out;
    private boolean isRunning = true;

    public RilevatoreAria(OutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(out);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            while (isRunning) {
                Rilevazione r = new Rilevazione(
                    (int) (Math.random() * 110),
                    System.currentTimeMillis()
                );

                oos.writeObject(r);
                oos.flush(); // forza l'invio del buffer

                Thread.sleep(12 * 1000);
            }

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
