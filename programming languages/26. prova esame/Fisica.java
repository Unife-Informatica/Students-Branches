import java.util.List;

public class Fisica extends Transazione {

    String city;

    public Fisica(int id, String date, List<Libro> libri, String city) {
        super(id, date, libri);
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String toString() {
        return (
            getId() +
            "\t" +
            getDate() +
            "\t" +
            getCity() +
            "\t" +
            "-" +
            "\t" +
            getTotale()
        );
    }
}
