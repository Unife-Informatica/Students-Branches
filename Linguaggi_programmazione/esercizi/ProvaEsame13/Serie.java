public class Serie extends Spettacolo{
  private int stagione, nPuntate;

  public Serie(String titolo, String tipo, String produttore, int codice, int anno, int stagione, int nPuntate) {
    super(titolo, tipo, produttore, codice, anno);
    this.stagione = stagione;
    this.nPuntate = nPuntate;
  }

  public int getStagione() {
    return stagione;
  }

  public int getnPuntate() {
    return nPuntate;
  }
}
