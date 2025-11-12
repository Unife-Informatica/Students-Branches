public class Prodotto{
    private String tipoProdotto,titolo, autore;
    private int codiceProdotto;
    private double prezzo;
    public Prodotto(String tipoProdotto, String titolo, String autore, int codiceProdotto, double prezzo){
        this.tipoProdotto=tipoProdotto;
        this.titolo=titolo;
        this.autore=autore;
        this.codiceProdotto=codiceProdotto;
        this.prezzo=prezzo;
    }
    public String getTipoProdotto(){
        return tipoProdotto;
    }
    public String getTitolo(){
        return titolo;
    }
    public String getAutore(){
        return autore;
    }
    public int getCodiceProdotto(){
        return codiceProdotto;
    }
    public double getPrezzo(){
        return prezzo;
    }


}
