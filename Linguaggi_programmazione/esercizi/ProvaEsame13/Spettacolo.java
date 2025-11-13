import java.util.List;

public abstract class Spettacolo {
  protected String titolo, tipo, produttore;
  protected int codice, anno;

  public Spettacolo(String titolo, String tipo, String produttore, int codice, int anno) {
    this.titolo = titolo;
    this.tipo = tipo;
    this.produttore = produttore;
    this.codice = codice;
    this.anno = anno;
  }

  public String getTitolo() {
    return titolo;
  }

  public String getTipo() {
    return tipo;
  }

  public String getProduttore() {
    return produttore;
  }

  public int getCodice() {
    return codice;
  }

  public int getAnno() {
    return anno;
  }
}
