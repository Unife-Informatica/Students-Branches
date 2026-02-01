package es02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class ScansionaInput implements Runnable{
  private PipedInputStream pis = null;
  private VerificaInput vf = null;
  private AtomicBoolean isRunning = new AtomicBoolean(false);

  public ScansionaInput(PipedInputStream pis, VerificaInput vf){
    this.pis = pis;
    this.vf = vf;
  }

  public void run(){
    isRunning.set(true);
    BufferedReader br = new BufferedReader(new InputStreamReader(pis));

    while(isRunning.get()){
      String line = null;
      try{
        line = br.readLine();
      }catch(IOException e){
        e.printStackTrace();
      }

      if(line.equals("1234") || line.equals("abcde")){
        vf.incSospette();
        System.out.println("pericolo");
      }else{
        System.out.println("ok");
      }
    }
  }

  public void stop(){
    isRunning.set(false);
  }
}
