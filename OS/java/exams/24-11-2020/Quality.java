import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class Quality extends Thread {

    InputStream in = null;
    private AtomicBoolean isRunning = new AtomicBoolean(false);

    public Quality(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        isRunning.set(true);
        try {
            ObjectInputStream ois = new ObjectInputStream(in);
            while (isRunning.get()) {
                Message msg = (Message) ois.readObject();
                if (msg.getVal() < 0) {
                    System.out.println("Errore");
                } else {
                    System.out.println("OK");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void termina() {
        isRunning.set(false);
    }
}
