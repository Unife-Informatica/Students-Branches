public class Main {
  public static void main(String[] args) {
    Consumi c = new Consumi();

    SimulaConsumi s = new SimulaConsumi(c);
    Thread Ts = new Thread(s);
    Ts.start();

    float corrente = 0.0F;
    float precedente = 0.0F;
    int count = 0;

    while(true){
      try{
        Thread.sleep(900);
      }catch(InterruptedException e){
        e.printStackTrace();
      }
      
      corrente = c.getConsumi();
      System.out.println("Corrente: " + corrente);
      if(corrente > precedente){
        if(corrente - precedente > (precedente/30)*100){
          System.out.println("Attenzione, guida meglio");
        }

        if(corrente > 20){
          count++;
        }else{
          count = 0;
        }
        
        if(count == 3){
          s.termina();
          break;
        }

        precedente = corrente;
      }
    }

    try{
      Ts.join();
    }catch(InterruptedException e){
      e.printStackTrace();
    }
  }
}
