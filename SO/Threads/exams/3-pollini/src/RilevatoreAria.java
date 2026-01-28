
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PipedOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class RilevatoreAria extends Thread {
    private PipedOutputStream pos = null;
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    public RilevatoreAria(PipedOutputStream pos){
        this.pos=pos;
    }
    public void stopRilevatoreAria(){
        isRunning.set(false);
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run(){
        isRunning.set(true);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(pos));
        while(isRunning.get()){
            try {
            bw.write((int)(Math.random()*110)+"");
            bw.newLine();
            bw.write((System.currentTimeMillis()/1000)+"");
            bw.newLine();
            bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        
            //dormire per 12 secondi
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println("Il thread e' stato interrotto durante il sonno");
                break;
            }
        }
    }

    
}
