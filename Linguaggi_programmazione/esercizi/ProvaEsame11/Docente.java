public class Docente extends Iscritto{
  private String corsoPrincipale;

  public Docente(String nomeCognome, String tipoIscritto, String indirizzo, int codiceIscritto, int eta, Contatto Contatto, String corsoPrincipale) {
    super(nomeCognome, tipoIscritto, indirizzo, codiceIscritto, eta, Contatto);
    this.corsoPrincipale = corsoPrincipale;
  }

  public String getDettaglio() {
    return corsoPrincipale;
  }
}