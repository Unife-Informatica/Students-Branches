package es02;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
  public static void main(String[] args) {
    PipedInputStream pis = new PipedInputStream();
    PipedOutputStream pos = null;
    boolean continua = true;

    Overall o = new Overall();

    try{
      pos = new PipedOutputStream(pis);
    }catch(IOException e){
      e.printStackTrace();
    }

    Machine m = new Machine(pos);
    Quality q = new Quality(pis, o);

    m.start();
    q.start();

    while(continua){
      try{
        Thread.currentThread().sleep(1000);
        if(o.getDifetti() > o.getCorretti()){
          System.out.println("Oggetti difettosi: " + o.getDifetti() + " > oggetti corretti " + o.getCorretti());

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
