public class Prodotto {
    String descrizione;
    int qVenduta,prezzo;
    public Prodotto(String descrizione, int qVenduta, int prezzo) {
        this.descrizione = descrizione;
        this.qVenduta = qVenduta;
        this.prezzo = prezzo;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public int getQVenduta() {
        return qVenduta;
    }
    public int getPrezzo() {
        return prezzo;
    }
    
}
