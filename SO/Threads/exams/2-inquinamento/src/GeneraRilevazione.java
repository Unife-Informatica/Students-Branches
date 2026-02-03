import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class GeneraRilevazione extends Thread{
    private PipedOutputStream pos = null;
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    public GeneraRilevazione(PipedOutputStream pos){
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
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        while(isRunning.get()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Ciclo terminato mentre era dormiente");
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
