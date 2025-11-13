import java.util.List;

public abstract class Prodotto {
  protected String tipoProdotto, modello, produttore, data;
  protected int codiceProdotto, prezzo;
  protected List<Magazzino> listaMagazzino;

  public Prodotto(String tipoProdotto, int codiceProdotto, String modello, String produttore, String data, int prezzo, List<Magazzino> listaMagazzino){
    this.tipoProdotto=tipoProdotto;
    this.codiceProdotto=codiceProdotto;
    this.modello=modello;
    this.produttore=produttore;
    this.data=data;
    this.prezzo=prezzo;
    this.listaMagazzino=listaMagazzino;
  }

  public String getTipoProdotto(){
    return this.tipoProdotto;
  }

  public int getCodiceProdotto(){
    return this.codiceProdotto;
  }

  public String getModello(){
    return this.modello;
  }

  public String getProduttore(){
    return this.produttore;
  }

  public String getData(){
    return this.data;
  }

  public int getPrezzo(){
    return this.prezzo;
  }

  public List<Magazzino> getListaMagzzino(){
    return this.listaMagazzino;
  }

  public abstract String getDettaglio();
}
