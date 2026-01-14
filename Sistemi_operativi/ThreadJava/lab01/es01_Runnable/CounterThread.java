package es01_Runnable;

public class CounterThread implements Runnable{
  private Accumulatore acc;

  public CounterThread(Accumulatore accum){
    this.acc = accum;
  }

  @Override
  public void run(){
    double value = Math.random();
    acc.addValue(value);
    System.out.println("Thread: " + Thread.currentThread() + " accumulatore: " + acc.getValue());
  }
}
