public class Libro extends Prodotto{
    String ISBN;
    public Libro(String tipoProdotto, String titolo, String autore, int codiceProdotto, double prezzo,String ISBN){
        super(tipoProdotto, titolo, autore, codiceProdotto, prezzo);
        this.ISBN=ISBN;
    }
    public String getISBN(){
        return ISBN;
    }
}