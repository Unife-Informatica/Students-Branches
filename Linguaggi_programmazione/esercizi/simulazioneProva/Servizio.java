public class Servizio {
  private int codiceDip;
  private double nOreServizio;
  
  public Servizio(int codiceDip, double nOreServizio) {
    this.codiceDip = codiceDip;
    this.nOreServizio = nOreServizio;
  }

  public int getCodiceDip() {
    return codiceDip;
  }

  public double getnOreServizio() {
    return nOreServizio;
  }
}
