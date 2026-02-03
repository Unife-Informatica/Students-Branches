import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class SimulaConsumi implements Runnable {

    private AtomicBoolean isRunning = new AtomicBoolean(false);
    Consumi c;

    public SimulaConsumi(Consumi c) {
        this.c = c;
    }

    @Override
    public void run() {
        isRunning.set(true);
        while (isRunning.get()) {
            float val = (float) (Math.random() * 30);
            c.setVal(val);
        }
    }

    public void termina() {
        isRunning.set(false);
    }
}
