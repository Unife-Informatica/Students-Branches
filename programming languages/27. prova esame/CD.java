
public class CD extends Prodotto {

    private final int durata;

    public CD(
            int codice,
            String titolo,
            String autore,
            int prezzo,
            int durata
    ) {
        super(codice, titolo, autore, prezzo);
        this.durata = durata;
    }

    public int getDurata() {
        return durata;
    }

    @Override
    public String toString() {
        return "CD\t" + getCodice() + "\t" + getTitolo() + "\t" + getAutore() + "\t" + getPrezzo() + "\t-\t" + getDurata();
    }
}
