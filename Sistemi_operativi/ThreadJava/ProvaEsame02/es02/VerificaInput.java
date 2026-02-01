package es02;

public class VerificaInput {
  private int nSospette = 0;

  public synchronized void incSospette(){
    this.nSospette++;
  }

  public synchronized int getSospette(){
    return this.nSospette;
  }
}