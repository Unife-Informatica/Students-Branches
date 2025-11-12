import java.util.List;

public class Toner extends Prodotto {
    String modStampante="xxx";
    public Toner(String tipoProdotto, int codiceProdotto, String modello, String marca, String data, double prezzo,String modStampante,List<Magazzino> listaMagazzino){
        super(tipoProdotto, codiceProdotto, modello, marca, data, prezzo,listaMagazzino);
        this.modStampante=modStampante;
    }
    public String getModStampante(){
        return modStampante;
    }
}
