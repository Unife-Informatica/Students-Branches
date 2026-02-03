import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class Machine extends Thread {

    private OutputStream out = null;
    private int counter;
    private AtomicBoolean isRunning = new AtomicBoolean(false);

    public Machine(OutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(out);
            isRunning.set(true);
            while (isRunning.get()) {
                int val = (int) (Math.random() * 2000 - 1000);
                oos.writeObject(new Message(val));
                counter++;
                Thread.sleep(750);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void termina() {
        System.out.println("Counter: " + counter);
        isRunning.set(false);
    }
}
