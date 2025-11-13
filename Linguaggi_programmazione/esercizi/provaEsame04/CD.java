public class CD extends Prodotto{
  int durata;

  public CD(String tipoProdotto, int codiceProdotto, String titolo, String autori, int prezzo, int durata){
    super(tipoProdotto, codiceProdotto, titolo, autori, prezzo);
    this.durata=durata;
  }

  @Override
  public String getDettaglio(){
    return Integer.toString(durata);
  }
}
