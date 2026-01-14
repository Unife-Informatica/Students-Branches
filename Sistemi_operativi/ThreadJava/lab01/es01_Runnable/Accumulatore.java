package es01_Runnable;

public class Accumulatore{
  private double accumulatore;

  public Accumulatore(double value){
    accumulatore = value;
  }

  public void addValue(double value){
    double tmp = accumulatore;
    tmp += value;
    try{
      Thread.sleep(200);
    }catch(InterruptedException e){/*no istruzioni*/}
    accumulatore = tmp;
  }

  public double getValue(){
    return this.accumulatore;
  }
}
