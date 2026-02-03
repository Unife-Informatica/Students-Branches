public class VerificaInput {
  private int sospette = 0;

  public synchronized void incSospette(){
    this.sospette++;
  }

  public synchronized int getSospette(){
    return this.sospette;
  }
}