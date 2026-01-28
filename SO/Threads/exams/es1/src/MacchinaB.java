
import java.io.IOException;
import java.io.PipedInputStream;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicBoolean;

public class MacchinaB implements Runnable {
    private PipedInputStream pis = null;
    private int lavoriFiniti = 0;

    public MacchinaB(PipedInputStream pis){
        this.pis=pis;
    }

    final AtomicBoolean isRunning=new AtomicBoolean(false);
    public void stopMacchinaB(){
        isRunning.set(false);
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run(){
        isRunning.set(true);
        
        while(isRunning.get()){
            byte[] buffer = new byte[128];
            int nread=0;
            try{
                nread=pis.read(buffer);
            }catch(IOException ie){
                ie.printStackTrace();
            }

            //interpreto stringa di byte ricevuti
            String received = new String(buffer,0,nread,Charset.forName("UTF-8"));
            System.out.println("Arrivato prodotto grezzo: "+received);

            //simulazione lavorazione prodotto grezzo
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("MacchinaB: sleep interrupted");
            }
            lavoriFiniti++;
            System.out.println("Fine lavorazione del prodotto grezzo, lavori finiti: "+lavoriFiniti);
        }
    }
}
