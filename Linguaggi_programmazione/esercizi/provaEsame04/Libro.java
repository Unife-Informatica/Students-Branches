public class Libro extends Prodotto{
  private String ISBN;

  public Libro(String tipoProdotto, int codiceProdotto, String titolo, String autori, int prezzo, String ISBN){
    super(tipoProdotto, codiceProdotto, titolo, autori, prezzo);
    this.ISBN=ISBN;
  }

  @Override
  public String getDettaglio(){
    return this.ISBN;
  }
}
