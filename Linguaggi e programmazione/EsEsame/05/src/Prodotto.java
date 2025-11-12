import java.util.List;

public abstract class Prodotto {
    protected String tipoProdotto,modello,marca,data;
    protected int codiceProdotto;
    protected double prezzo;
    protected List<Magazzino> listaMagazzino;
    public Prodotto(String tipoProdotto, int codiceProdotto, String modello, String marca, String data, double prezzo,List<Magazzino> listaMagazzino){
        this.tipoProdotto=tipoProdotto;
        this.codiceProdotto=codiceProdotto;
        this.modello=modello;
        this.marca=marca;
        this.data=data;
        this.prezzo=prezzo;
        this.listaMagazzino=listaMagazzino;
    }
    public String getTipoProdotto(){
        return tipoProdotto;
    }
    public String getModello(){
        return modello;
    }
    public String getMarca(){
        return marca;
    }
    public String getData(){
        return data;
    }
    public int getCodiceProdotto(){
        return codiceProdotto;
    }
    public double getPrezzo(){
        return prezzo;
    }
    public List<Magazzino> getMagazzino(){
        return listaMagazzino;
    }
}