import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class ScansionaInput implements Runnable{
  private PipedInputStream pis = null;
  private AtomicBoolean isRunning = new AtomicBoolean(false);
  private VerificaInput vf = null;

  public ScansionaInput(PipedInputStream pis, VerificaInput vf){
    this.pis = pis;
    this.vf = vf;
  }

  public void run(){
    isRunning.set(true);

    BufferedReader br = new BufferedReader(new InputStreamReader(pis));
    String s = null;

    while(isRunning.get()){
      try{
        s = br.readLine();
        if(s.equals("1234") || s.equals("abcde")){
          System.out.println("Stringa sospetta: " + s);
          vf.incSospette();
        }else{
          System.out.println("OK");
        }
      }catch(IOException e){
        e.printStackTrace();
      }
    }
  }

  public void termina(){
    isRunning.set(false);
  }
}