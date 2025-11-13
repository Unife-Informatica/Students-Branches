import java.util.List;

public class Stampante extends Prodotto{
  private int peso;

  public Stampante(String tipoProdotto, int codiceProdotto, String modello, String produttore, String data, int prezzo, int peso, List<Magazzino> listaMagazzino){
    super(tipoProdotto, codiceProdotto, modello, produttore, data, prezzo, listaMagazzino);
    this.peso=peso;
  }

  public String getDettaglio(){
    return Integer.toString(this.peso);
  }
}
