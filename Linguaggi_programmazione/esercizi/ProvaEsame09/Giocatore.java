public class Giocatore {
  private int codiceGiocatore, eta, numeroMaglia;
  private String cognome, ruolo, isTitolare;

  public Giocatore(int codiceGiocatore, String cognome, int eta, int numeroMaglia, String ruolo, String isTitolare){
    this.codiceGiocatore=codiceGiocatore;
    this.cognome=cognome;
    this.eta=eta;
    this.numeroMaglia=numeroMaglia;
    this.ruolo=ruolo;
    this.isTitolare=isTitolare;
  }

  public int getCodiceGiocatore() {
    return codiceGiocatore;
  }

  public int getEta() {
    return eta;
  }

  public int getNumeroMaglia() {
    return numeroMaglia;
  }

  public String getCognome() {
    return cognome;
  }

  public String getRuolo() {
    return ruolo;
  }

  public String getIsTitolare() {
    return isTitolare;
  }
}
