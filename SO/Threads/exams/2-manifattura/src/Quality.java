
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class Quality extends Thread{
    private PipedInputStream pis = null;
    private Overall overall= null;
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    public Quality(PipedInputStream pis,Overall overall){
        this.pis=pis;
        this.overall=overall;
    }
    public void fermaQuality(){
        isRunning.set(false);
    }
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run(){
        isRunning.set(true);

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(pis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        while(isRunning.get()){
            try{
                Message m = (Message) ois.readObject();
                if(m.getValCasuale()<0){
                    System.out.println("Errore!: "+m.getContP());
                    overall.incrementaDifetti();
                }
                if(m.getValCasuale()>=0){
                    System.out.println("OK");
                    overall.incrementaCorretti();
                }
            }catch(IOException|ClassNotFoundException e){
                e.printStackTrace();
            }

        }
    }
}
