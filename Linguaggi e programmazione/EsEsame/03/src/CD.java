public class CD extends Prodotto{
    int durata;
    public CD(String tipoProdotto, String titolo, String autore, int codiceProdotto, double prezzo,int durata){
        super(tipoProdotto, titolo, autore, codiceProdotto, prezzo);
        this.durata=durata;
    }
    public int getDurata(){
        return durata;
    }
}