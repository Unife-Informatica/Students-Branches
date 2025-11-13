public abstract class Prodotto {
  protected String tipoProdotto, titolo, autori;
  protected int codiceProdotto, prezzo;

  public Prodotto(String tipoProdotto, int codiceProdotto, String titolo, String autori, int prezzo){
    this.tipoProdotto=tipoProdotto;
    this.codiceProdotto=codiceProdotto;
    this.titolo=titolo;
    this.autori=autori;
    this.prezzo=prezzo;
  }

  public String getTipoProdotto(){
    return this.tipoProdotto;
  }

  public int getCodiceProdotto(){
    return this.codiceProdotto;
  }

  public String getTitolo(){
    return this.titolo;
  }

  public String getAutori(){
    return this.autori;
  }

  public int getPrezzo(){
    return this.prezzo;
  }

  public abstract String getDettaglio();
}
