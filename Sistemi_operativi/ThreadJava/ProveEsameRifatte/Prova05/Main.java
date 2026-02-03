import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
  public static void main(String[] args) {
    PipedInputStream pis = new PipedInputStream();
    PipedOutputStream pos = null;
    BufferedReader br = new BufferedReader(new InputStreamReader(pis));

    try{
      pos = new PipedOutputStream(pis);
    }catch(IOException e){
      e.printStackTrace();
    }

    int valore = 0;
    long oldTime = 0;
    long currTime = 0;

    RilevatoreAria r = new RilevatoreAria(pos);
    r.start();

    for(int i = 0;  i < 8; i++){
      try{
        valore = Integer.parseInt(br.readLine());
        currTime = Long.parseLong(br.readLine());
      }catch(IOException e){
        e.printStackTrace();
      }

      if(valore < 20){
        System.out.println("Basso");
      }else if(valore > 20 && valore < 75){
        System.out.println("Medio");
      }else{
        System.out.println("Alto");
      }

      long newTime = currTime - oldTime;
      if(newTime > 15 && oldTime != 0){
        System.out.println("Attenzione " + newTime);
      }
      oldTime = currTime;
    }
    r.termina();

    try{
      r.join();
    }catch(InterruptedException e){
      e.printStackTrace();
    }
  }
}