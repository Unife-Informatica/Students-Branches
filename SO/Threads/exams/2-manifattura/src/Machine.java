
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class Machine extends Thread{
    private PipedOutputStream pos = null;
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    private int cont = 0;
    public Machine(PipedOutputStream pos){
        this.pos=pos;
    }
    //metodo di stop thread
    public void fermaMachine(){
        isRunning.set(false);
    }
    
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run(){
        isRunning.set(true);

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(pos);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        while(isRunning.get()){
            cont++;
            Message m = new Message(cont, (float)(-1000+Math.random()*2000));
            try {
                oos.writeObject(m);
                oos.flush();
                Thread.sleep(750);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}