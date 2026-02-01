package es01;

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

    ScansionaInput sc = new ScansionaInput(pis);
    Thread tSc = new Thread(sc);
    tSc.start();

    try{
      Thread.currentThread().sleep(30*1000);
      in.stop();
      sc.stop();
    }catch(InterruptedException e){
      e.printStackTrace();
    }

    try{
      tIn.join();
      tSc.join();
    }catch(InterruptedException e){
      e.printStackTrace();
    }
  }
}