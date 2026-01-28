
import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicBoolean;

public class MacchinaA implements Runnable{
    private PipedOutputStream pos = null;
    public MacchinaA(PipedOutputStream pos){
        this.pos=pos;
    }
    //controllo esecuzione (Thread-Safe)
    final AtomicBoolean isRunning = new AtomicBoolean(false);
    public void stopMacchinaA(){
        isRunning.set(false);
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run(){
        isRunning.set(true);

        while(isRunning.get()){
            System.out.println("Inizio lavorazione prodotto");
            try{
                Thread.sleep(200);
                System.out.println("Fine lavorazione prodotto");

                String pg = "prodotto-grezzo";
                byte[] message = null;
                try {
                    message=pg.getBytes("UTF-8");  
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
                //invio segnali
                try {
                    pos.write(message);
                    pos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }

}