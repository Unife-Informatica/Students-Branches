public class Prodotto {

    int codice, prezzo;
    String titolo, autore;

    public Prodotto(int codice, String titolo, String autore, int prezzo) {
        this.codice = codice;
        this.titolo = titolo;
        this.autore = autore;
        this.prezzo = prezzo;
    }

    public int getCodice() {
        return codice;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }
}
