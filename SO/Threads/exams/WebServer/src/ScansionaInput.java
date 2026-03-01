
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class ScansionaInput implements Runnable{
    private PipedInputStream pis = null;
    private final AtomicBoolean isRunning = new
    AtomicBoolean(false);
    VerificaInput vi = null;
    public ScansionaInput(PipedInputStream pis,VerificaInput vi){
        this.pis=pis;
        this.vi=vi;
    }
    public void fermaScansionaInput(){
        isRunning.set(false);
    }
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run(){
        isRunning.set(true);
        String s = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(pis));
        while(isRunning.get()){
            try{
                s = br.readLine();
                if(s.equals("abcde")||s.equals("1234")){
                    System.out.println("Pericolo!");
                    vi.incrementaStringheSospette();
                }else{
                    System.out.println("ok");
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    
}
