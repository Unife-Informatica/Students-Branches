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

    InputUtente inp = new InputUtente(pos);
    Thread tInp = new Thread(inp);
    tInp.start();

    VerificaInput vf = new VerificaInput();

    ScansionaInput sInp = new ScansionaInput(pis, vf);
    Thread tSinp = new Thread();
    tSinp.start();

    while(true){
      try{
        Thread.currentThread().sleep(200);
        if(vf.getStringheSosp() > 3){
          System.out.println("Rilevate > 3 stringhe sospette, termino...");
          inp.termina();
          sInp.termina();

          tInp.join();
          tSinp.join();
          break;
        }
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }
  }
}