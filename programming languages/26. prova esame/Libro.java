public class Libro {

    protected String titolo;
    protected String autore;
    protected int price;

    public Libro() {}

    public Libro(String titolo, String autori, int price) {
        this.titolo = titolo;
        this.autore = autori;
        this.price = price;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public String getAutore() {
        return this.autore;
    }

    public int getPrice() {
        return this.price;
    }
}
