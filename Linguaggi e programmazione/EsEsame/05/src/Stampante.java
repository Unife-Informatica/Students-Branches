import java.util.List;

public class Stampante extends Prodotto {
    private int peso=0;
    public Stampante(String tipoProdotto, int codiceProdotto, String modello, String marca, String data, double prezzo,int peso,List<Magazzino> listaMagazzino){
        super(tipoProdotto, codiceProdotto, modello, marca, data, prezzo,listaMagazzino);
        this.peso=peso;
    }
    public int getPeso(){
        return peso;
    }
}
