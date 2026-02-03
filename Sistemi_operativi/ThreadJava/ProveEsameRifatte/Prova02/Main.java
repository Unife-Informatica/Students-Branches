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

    InputUtente in = new InputUtente(pos);
    Thread tIn = new Thread(in);
    tIn.start();

    VerificaInput vf = new VerificaInput();

    ScansionaInput sc = new ScansionaInput(pis, vf);
    Thread tSc =  new Thread(sc);
    tSc.start();

    while(true){
      try{
        Thread.sleep(200);
        if(vf.getSospette() > 3){
          System.out.println("Stringhe sosptette > 3, termina...");
          in.termina();
          sc.termina();

          break;
        }
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }

    try{
      tIn.join();
      tSc.join();
    }catch(InterruptedException e){
      e.printStackTrace();
    }
  }
}