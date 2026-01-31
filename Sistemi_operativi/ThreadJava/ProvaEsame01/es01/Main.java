package es01;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
  public static void main(String[] args) {
    PipedInputStream pis = new PipedInputStream();
    PipedOutputStream pos = null;

    try{
      pos = new PipedOutputStream(pis);
    }catch(Exception e){
      e.printStackTrace();
    }

    Machine m = new Machine(pos);
    Quality q = new Quality(pis);

    m.start();
    q.start();

    try{
      Thread.currentThread().sleep(15000);
    }catch(InterruptedException e){
      e.printStackTrace();
    }

    m.termina();
    q.termina();

    try{
      m.join();
      q.join();
    }catch(InterruptedException e){
      e.printStackTrace();
    }
  }
}