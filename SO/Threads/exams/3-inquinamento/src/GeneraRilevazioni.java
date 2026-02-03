
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class GeneraRilevazioni extends Thread {
    private PipedOutputStream pos = null;
    private final AtomicBoolean isRunning = new AtomicBoolean();
    public GeneraRilevazioni(PipedOutputStream pos){
        this.pos=pos;
    }

    public void terminaRilevazioni(){
        isRunning.set(false);
        this.interrupt();
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
            return;
        }
        while(isRunning.get()){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException | IllegalArgumentException e) {
                System.out.println(currentThread()+" terminato");
                break;
            }
            Rilevazione r = new Rilevazione();
            r.setValore((int)(Math.random()*200));
            r.setTimestamp(System.currentTimeMillis()/1000);
            try {
                oos.writeObject(r);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
