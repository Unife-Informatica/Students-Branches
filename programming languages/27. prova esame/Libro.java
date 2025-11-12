
public class Libro extends Prodotto {

    private final String isbn;

    public Libro(
            int codice,
            String titolo,
            String autore,
            int prezzo,
            String isbn
    ) {
        super(codice, titolo, autore, prezzo);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Libro\t" + getCodice() + "\t" + getTitolo() + "\t" + getAutore() + "\t" + getPrezzo() + "\t" + getIsbn() + "\t-";
    }
}
