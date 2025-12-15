
import java.util.List;

public class Album {

    private final String titolo;
    private final int annoUscita;
    private final List<Brano> listaBrani;

    public Album(int annoUscita, List<Brano> listaBrani, String titolo) {
        this.annoUscita = annoUscita;
        this.listaBrani = listaBrani;
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoUscita() {
        return annoUscita;
    }

    public List<Brano> getListaBrani() {
        return listaBrani;
    }

}
