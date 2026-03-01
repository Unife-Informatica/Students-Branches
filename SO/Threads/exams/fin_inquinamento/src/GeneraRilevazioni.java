
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class GeneraRilevazioni extends Thread {
    private PipedOutputStream pos = null;
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    public GeneraRilevazioni(PipedOutputStream pos){
        this.pos = pos;
    }
    public void fermaGeneraRilevazioni(){
        isRunning.set(false);
    }
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run(){
        isRunning.set(true);

        Rilevazione r;
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(pos);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        while(isRunning.get()){
            r = new Rilevazione((int)(Math.random()*200), (long)(System.currentTimeMillis()/1000));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                oos.writeObject(r);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
