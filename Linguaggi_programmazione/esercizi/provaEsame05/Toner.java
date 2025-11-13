import java.util.List;

public class Toner extends Prodotto{
  private String modelloStampante;

  public Toner(String tipoProdotto, int codiceProdotto, String modello, String produttore, String data, int prezzo, String modelloStampante, List<Magazzino> listaMagazzino){
    super(tipoProdotto, codiceProdotto, modello, produttore, data, prezzo, listaMagazzino);
    this.modelloStampante=modelloStampante;
  }

  public String getDettaglio(){
    return this.modelloStampante;
  }
}
