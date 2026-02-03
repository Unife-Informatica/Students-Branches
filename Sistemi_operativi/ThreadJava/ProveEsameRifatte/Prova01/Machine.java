import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PipedOutputStream;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Machine extends Thread{
  private PipedOutputStream pos = null;
  private AtomicBoolean isRunning = new AtomicBoolean(false);
  private int nProdotti = 0;

  public Machine(PipedOutputStream pos){
    this.pos = pos;
  }

  public void run(){
    isRunning.set(true);
    Random random = new Random();

    ObjectOutputStream oos = null;

    try{
      oos = new ObjectOutputStream(pos);
    }catch(IOException e){
      e.printStackTrace();
    }

    while(isRunning.get()){
      float num = -1000 + random.nextFloat() * 2000;
      nProdotti++;

      Message m = new Message(nProdotti, num);

      try{
        oos.writeObject(m);
        oos.flush();
      }catch(IOException e){
        e.printStackTrace();
      }

      try{
        Thread.currentThread().sleep(750);
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }
  }

  public void termina(){
    isRunning.set(false);
  }
}