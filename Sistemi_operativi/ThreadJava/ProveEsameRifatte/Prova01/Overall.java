public class Overall {
  private int corretti = 0;
  private int difetti = 0;

  public synchronized void incCorretti(){
    this.corretti++;
  }

  public synchronized void incDifetti(){
    this.difetti++;
  }

  public synchronized int getCorretti(){
    return this.corretti;
  }

  public synchronized int getDifetti(){
    return this.difetti;
  }
}