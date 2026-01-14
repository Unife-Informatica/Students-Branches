package es01_Extends;
public class CounterThread extends Thread{
  private Accumulatore acc;

  public CounterThread(Accumulatore accum){
    this.acc = accum;
  }

  @Override
  public void run(){
    double value = Math.random();
    this.acc.addValue(value);
    System.out.println("Thread: " + Thread.currentThread() + " accumulatore: " + acc.getValue());
  }
}