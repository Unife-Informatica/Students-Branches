public class Prodotto {
    private String descrizione;
    private int quantita;
    private double prezzo;
    public Prodotto(String descrizione, int quantita, double prezzo){
        this.descrizione=descrizione;
        this.quantita=quantita;
        this.prezzo=prezzo;
    }
    public String getDescrizione(){
        return descrizione;
    }
    public int getQuantita(){
        return quantita;
    }
    public double getPrezzo(){
        return prezzo;
    }
}
