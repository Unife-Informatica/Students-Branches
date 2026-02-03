import java.util.concurrent.atomic.AtomicBoolean;

public class SimulaConsumi implements Runnable{
  private AtomicBoolean isRunning = new AtomicBoolean(false);
  private Consumi c = null;

  public SimulaConsumi(Consumi c){
    this.c = c;
  }

  public void run(){
    isRunning.set(true);
    while(isRunning.get()){
      try{
        Thread.sleep(1000);
      }catch(InterruptedException e){  
        e.printStackTrace();
      }

      c.setConsumi((float)(Math.random()*30));
    }
  }

  public void termina(){
    isRunning.set(false);
  }
}