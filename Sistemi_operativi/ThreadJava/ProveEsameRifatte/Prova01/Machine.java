import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class Machine extends Thread{
  private PipedOutputStream pos = null;
  private AtomicBoolean isRunning = new AtomicBoolean(false);
  private int contProd = 0;

  public Machine(PipedOutputStream pos){
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
      contProd++;
      Message m = new Message(contProd, (float)(-1000+Math.random()*2000));
      try{
        oos.writeObject(m);
        oos.flush();
        Thread.sleep(750);
      }catch(IOException | InterruptedException e){
        e.printStackTrace();
      }
    }
  }

  public void termina(){
    isRunning.set(false);
  }
}