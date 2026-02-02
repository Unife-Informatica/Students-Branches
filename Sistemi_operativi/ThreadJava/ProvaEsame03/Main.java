import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
  public static void main(String[] args) {
    Consumi c = new Consumi();
    SimulaConsumi simula = new SimulaConsumi(c);
    Thread tSimula = new Thread(simula);
    tSimula.start();

    int count = 0;
    float prec = 0.0F;
    float attuale = 0.0F;

    while(true){
      try{
        Thread.sleep(900);
      }catch(InterruptedException e){
        e.printStackTrace();
      }

      attuale = c.getConsumi();
      System.out.println("Consumo rilevato: " + attuale);

      if(attuale > prec){
        if((attuale - prec) > (prec * 30) / 100){
          System.out.println("Warning: superato il 30% della rilevazione precedente");
        }
      }

      if(attuale > 20){
        count++;
      }else{
        count = 0;
      }

      if(count == 3){
        System.out.println("Rilevati 3 valori consecutivi maggiori di 20, termino SimulazioneConsumi");
        simula.terminaSimulazioneConsumi();
        break;
      }

      prec = attuale;
    }
    System.out.println("Attendo la terminazione di SimulazioneConsumi");
    try{
      tSimula.join();
    }catch(InterruptedException e){
      e.printStackTrace();
    }
  }
}