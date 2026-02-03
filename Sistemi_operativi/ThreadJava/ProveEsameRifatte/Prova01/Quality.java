import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class Quality extends Thread{
  private PipedInputStream pis = null;
  private AtomicBoolean isRunning = new AtomicBoolean(false);
  private Overall overall = null;

  public Quality(PipedInputStream pis, Overall overall){
    this.pis = pis;
    this.overall = overall;
  }

  public void run(){
    isRunning.set(true);
    ObjectInputStream ois = null;

    try{
      ois = new ObjectInputStream(pis);
    }catch(IOException e){
      e.printStackTrace();
    }

    while(isRunning.get()){
      try{
        Message m = (Message)ois.readObject();
        if(m.getValCasuale() < 0){
          System.out.println("Errore, valore negativo: " + m.getContProd());
          overall.incDifetti();
        }else{
          System.out.println("OK");
          overall.incCorretti();
        }
      }catch(IOException | ClassNotFoundException e){
        e.printStackTrace();
      }
    }
  }

  public void termina(){
    isRunning.set(false);
  }
}