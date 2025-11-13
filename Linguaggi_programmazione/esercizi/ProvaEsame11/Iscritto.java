public abstract class Iscritto {
  protected String nomeCognome, tipoIscritto, indirizzo;
  protected int codiceIscritto, eta;
  Contatto Contatto;

  public Iscritto(String nomeCognome, String tipoIscritto, String indirizzo, int codiceIscritto, int eta, Contatto Contatto) {
    this.nomeCognome = nomeCognome;
    this.tipoIscritto = tipoIscritto;
    this.indirizzo = indirizzo;
    this.codiceIscritto = codiceIscritto;
    this.eta = eta;
    this.Contatto = Contatto;
  }

  public String getNomeCognome() {
    return nomeCognome;
  }

  public String getTipoIscritto() {
    return tipoIscritto;
  }

  public String getIndirizzo() {
    return indirizzo;
  }

  public int getCodiceIscritto() {
    return codiceIscritto;
  }

  public int getEta() {
    return eta;
  }

  public Contatto getContatto() {
    return Contatto;
  }

  public abstract String getDettaglio();
}
