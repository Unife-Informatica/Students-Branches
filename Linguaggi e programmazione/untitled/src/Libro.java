public class Libro {
    private String ISBN, titolo, autore, genere;
    private int anno;

    public Libro() {}

    public Libro(String ISBN, String titolo, String autore, String genere, int anno) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
        this.anno = anno;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }
}
