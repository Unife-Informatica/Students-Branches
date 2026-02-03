import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class RilevatoreAria extends Thread{
  private PipedOutputStream pos = null;
  private AtomicBoolean isRunning = new AtomicBoolean(false);

  public RilevatoreAria(PipedOutputStream pos){
    this.pos = pos;
  }

  public void run(){
    isRunning.set(true);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(pos));
    
    while(isRunning.get()){
      try{
        Thread.sleep(12000);
      }catch(InterruptedException e){
        e.printStackTrace();
      }

      int random = (int)Math.random()*110;
      long timestamp = System.currentTimeMillis()/1000;

      try{
        bw.write(random+"");
        bw.newLine();
        bw.write(timestamp+"");
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