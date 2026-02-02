import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class GeneraRilevazioni extends Thread{
  private PipedOutputStream pos = null;
  private AtomicBoolean isRunning = new AtomicBoolean(false);

  public GeneraRilevazioni(PipedOutputStream pos){
    this.pos = pos;
  }

  public void run(){
    isRunning.set(true);

    ObjectOutputStream oos = null;
    try{
      oos = new ObjectOutputStream(pos);
    }catch(IOException e){
      e.printStackTrace();
    }

    while(isRunning.get()){
      Rilevazione r = new Rilevazione((int) (200 * Math.random()), System.currentTimeMillis());

      try{
        oos.writeObject(r);
        oos.flush();
      }catch(IOException e){
        e.printStackTrace();
      }

      try{
        Thread.sleep(3000);
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }
  }

  public void terminaRilevazioni(){
    isRunning.set(false);
    Thread.currentThread().interrupt();
  }
}