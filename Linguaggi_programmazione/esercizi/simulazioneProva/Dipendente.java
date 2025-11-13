public abstract class Dipendente {
  protected int codiceDip;
  protected String tipoDip, nomeDip;
  
  public Dipendente(int codiceDip, String tipoDip, String nomeDip) {
    this.codiceDip = codiceDip;
    this.tipoDip = tipoDip;
    this.nomeDip = nomeDip;
  }

  public int getCodiceDip() {
    return codiceDip;
  }

  public String getTipoDip() {
    return tipoDip;
  }

  public String getNomeDip() {
    return nomeDip;
  }
}
