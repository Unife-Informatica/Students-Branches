import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
  public static void main(String[] args) {
    PipedInputStream pis = new PipedInputStream();
    PipedOutputStream pos = null;

    try{
      pos = new PipedOutputStream(pis);
    }catch(IOException e){
      e.printStackTrace();
    }

    Overall overall = new Overall();

    Machine m = new Machine(pos);
    Quality q = new Quality(pis, overall);

    m.start();
    q.start();

    boolean continua = true;

    while(continua){
      try{
        Thread.currentThread().sleep(1000);
        if(overall.getDifetti() > overall.getCorretti()){
          System.out.println("Oggetti difettosi > corretti");
          m.termina();
          q.termina();

          continua = false;
        }
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }
    
    try{
      m.join();
      q.join();
    }catch(InterruptedException e){
      e.printStackTrace();
    }
  }
}