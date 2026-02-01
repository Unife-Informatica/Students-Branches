package es02;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
  public static void main(String[] args) {
    PipedInputStream pis = new PipedInputStream();
    PipedOutputStream pos = null;
    VerificaInput vf = new VerificaInput();

    try{
      pos = new PipedOutputStream(pis);
    }catch(IOException e){
      e.printStackTrace();
    }

    InputUtente in = new InputUtente(pos);
    Thread tIn = new Thread(in);
    tIn.start();

    ScansionaInput sc = new ScansionaInput(pis, vf);
    Thread tSc = new Thread(sc);
    tSc.start();

    while(true){
      try{
        Thread.currentThread().sleep(200);
        if(vf.getSospette() > 3){
          System.out.println("Rilevate > 3 stringhe sospette, termino...");
          in.stop();
          sc.stop();
          tIn.join();
          tSc.join();
          break;
        }
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }
  }
}