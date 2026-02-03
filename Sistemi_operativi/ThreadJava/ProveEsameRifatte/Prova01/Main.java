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

    Machine m = new Machine(pos);
    m.start();

    Overall overall = new Overall();

    Quality q = new Quality(pis, overall);
    q.start();

    while(true){
      try{
        Thread.currentThread().sleep(1000);
        if(overall.getDifetti() > overall.getCorretti()){
          System.out.println("Difetti > Corretti, termina...");
          m.termina();
          q.termina();

          break;
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