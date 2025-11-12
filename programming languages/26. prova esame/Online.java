import java.util.List;

public class Online extends Transazione {

    String ip;

    public Online(int id, String date, List<Libro> libri, String ip) {
        super(id, date, libri);
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public String toString() {
        return (
            getId() +
            "\t" +
            getDate() +
            "\t" +
            "-" +
            "\t" +
            getIp() +
            "\t" +
            getTotale()
        );
    }
}
