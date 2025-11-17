import java.util.Objects;

public class Libro {
    private String titolo;
    private Autore autore;
    private int anno;

    // Costruttore
    public Libro(String titolo, Autore autore, int anno) {
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
    }

    public String getTitolo() {
        return titolo;
    }

    public Autore getAutore() {
        return autore;
    }

    public int getAnno() {
        return anno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titolo, autore, anno);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Libro other = (Libro) obj;
        return anno == other.anno &&
               Objects.equals(titolo, other.titolo) &&
               Objects.equals(autore, other.autore);
    }

    @Override
    public String toString() {
        return titolo + " - " + autore + " (" + anno + ")";
    }
}

