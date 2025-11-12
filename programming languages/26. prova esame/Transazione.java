import java.util.ArrayList;
import java.util.List;

public class Transazione {

    int id;
    String date;
    List<Libro> libri = new ArrayList<>();

    public Transazione(int id, String date, List<Libro> libri) {
        this.id = id;
        this.date = date;
        this.libri = libri;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getTotale() {
        int totale = 0;
        for (Libro l : libri) {
            totale += l.getPrice();
        }
        return totale;
    }
}
