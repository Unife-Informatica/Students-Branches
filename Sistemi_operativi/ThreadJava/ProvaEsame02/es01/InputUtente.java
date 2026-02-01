package es01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class InputUtente implements Runnable{
  private PipedOutputStream pos = null;
  private AtomicBoolean isRunning = new AtomicBoolean(false);

  public InputUtente(final PipedOutputStream pos){
    this.pos = pos;
  }

  public void run(){
    isRunning.set(true);

    final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(pos));
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    while(isRunning.get()){
      System.out.println("Inserisci una stringa: ");
      try{
        String line = stdin.readLine();
        bw.write(line);
        bw.newLine();
        bw.flush();
      }catch(IOException e){
        e.printStackTrace();
      }
    }
  }

  public void stop(){
    isRunning.set(false);
  }
}