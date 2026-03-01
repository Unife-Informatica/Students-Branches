
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class InputUtente implements Runnable{
    private PipedOutputStream pos = null;
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    public InputUtente(PipedOutputStream pos){
        this.pos = pos;
    }
    public void fermaInputUtente(){
        isRunning.set(false);
    }
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run(){
        isRunning.set(true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(pos));
        System.out.println("Inserire stringa: ");
        String string = null;
        while(isRunning.get()){
            try {
            string = br.readLine();
            bw.write(string);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        
    }
}
