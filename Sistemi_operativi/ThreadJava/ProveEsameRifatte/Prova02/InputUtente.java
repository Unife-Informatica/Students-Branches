import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class InputUtente implements Runnable{
  private PipedOutputStream pos = null;
  private AtomicBoolean isRunning = new AtomicBoolean(false);

  public InputUtente(PipedOutputStream pos){
   this.pos = pos;
  }

  public void run(){
    isRunning.set(true);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(pos));

    while(isRunning.get()){
      System.out.println("Inserisci una stringa: ");
      String s = null;
      try{
        s = br.readLine();
        bw.write(s);
        bw.newLine();
        bw.flush();
      }catch(IOException e){
        e.printStackTrace();
      }
    }
  }

  public void termina(){
    isRunning.set(false);
  }
}