package es02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class Quality extends Thread{
  private PipedInputStream pis = null;
  private AtomicBoolean isRunning = new AtomicBoolean(false);
  private Overall o = null;

  public Quality(PipedInputStream pis, Overall o){
    this.pis = pis;
    this.o = o;
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
        Message m = (Message) ois.readObject();
        float fIndicator = m.getFIndicator();

        if(fIndicator > 0){
          System.out.println("OK");
          o.incrementaCorretti();
        }else{
          System.out.println("Errore, per pezzo numero " + m.getPezziProdotti());
          o.incrementaDifetti();
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
