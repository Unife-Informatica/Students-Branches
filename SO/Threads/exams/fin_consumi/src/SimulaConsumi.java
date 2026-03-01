
import java.util.concurrent.atomic.AtomicBoolean;

public class SimulaConsumi implements Runnable {
    private Consumi c = null;
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    public SimulaConsumi (Consumi c ){
        this.c = c;
    }
    public void terminaSimulazioneConsumi(){
        isRunning.set(false);
    }
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run(){
        isRunning.set(true);
        while(isRunning.get()){
            c.setConsumi((float)(Math.random()*30));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}   
