import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
  public static void main(String[] args) {
    PipedInputStream pis = new PipedInputStream();
    PipedOutputStream pos = null;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int sogliaCritica = 0;
    Rilevazione r = null;

    try{
      pos = new PipedOutputStream(pis);
    }catch(IOException e){
      e.printStackTrace();
    }

    GeneraRilevazioni g = new GeneraRilevazioni(pos);
    g.start();
    
    try{
      System.out.println("Inserisci valore di soglia crirtica: ");
      sogliaCritica = Integer.parseInt(br.readLine());
    }catch(IOException | NumberFormatException e){
      e.printStackTrace();
    }

    ObjectInputStream ois = null;
    try{
      ois = new ObjectInputStream(pis);
    }catch(IOException e){
      e.printStackTrace();
    }

    int count = 0;

    for(int i = 0; i <= 10; i++){
      try{
        r = (Rilevazione)ois.readObject();
      }catch(IOException | ClassNotFoundException e){
        e.printStackTrace();
      }

      if(r.getValore() <= 50){
        System.out.println("Basso");
      }else if(r.getValore() > 50 && r.getValore() < 100){
        System.out.println("Moderato");
      }else if(r.getValore() > 100){
        System.out.println("Alto");
      }

      if(r.getValore() > sogliaCritica){
        count++;
      }else{
        count = 0;
      }

      if(count == 3){
        System.out.println("Warning, superate 3 volte la soglia critica");
      }
    }

    g.termina();

    try{
      g.join();
    }catch(InterruptedException e){
      e.printStackTrace();
    }
  }
}