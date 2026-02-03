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
    ObjectOutputStream ois = null;

    try{
      ois = new ObjectOutputStream(pos);
    }catch(IOException e){
      e.printStackTrace();
    }

    while(isRunning.get()){
      try{
        Thread.sleep(3000);
      }catch(InterruptedException e){
        e.printStackTrace();
      }

      Rilevazione r = new Rilevazione((int)Math.random()*200, System.currentTimeMillis());

      try{
        ois.writeObject(r);
        ois.flush();
      }catch(IOException e){
        e.printStackTrace();
      }
    }
  }

  public void termina(){
    isRunning.set(false);
    Thread.interrupted();
  }
}