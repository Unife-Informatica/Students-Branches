public class VerificaInput {
  private int stringheSospette = 0;

  public synchronized void incStringheSosp(){
    this.stringheSospette++;
  }

  public synchronized int getStringheSosp(){
    return this.stringheSospette;
  }
}