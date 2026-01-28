
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class GeneraRilevazioni extends Thread {
    private PipedOutputStream pos = null;
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    public GeneraRilevazioni(PipedOutputStream pos){
        this.pos=pos;
    }

    public void stopGeneraRilevazioni(){
        isRunning.set(false);
        Thread.currentThread().interrupt();
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run(){
        isRunning.set(true);

        ObjectOutputStream oos = null;
        try {
            oos=new ObjectOutputStream(pos);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        while(isRunning.get()){
            Rilevazione r = new Rilevazione((int)(Math.random()*200), System.currentTimeMillis());
            try {
                oos.writeObject(r);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
