
import java.util.concurrent.atomic.AtomicBoolean;

public class RilevaConsumi implements Runnable {
    private Consumi c = null;
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    
    public RilevaConsumi(Consumi c){
        this.c=c;
    }

    public void terminaSimulazioneConsumi(){
        isRunning.set(false);
    }

    @Override
    public void run(){
        isRunning.set(true);

        while(isRunning.get()){
            c.setConsumi((float)(Math.random()*30));
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ie){
                System.out.println("Thread interrotto mentre era dormiente");
                break;
            }
        }
    }
}
