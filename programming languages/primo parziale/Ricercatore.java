import java.util.LinkedList;
import java.util.List;

public class Ricercatore {
    private final int codice;
    private final String nome;
    List<RepertiConsultati> repertiConsultati = new LinkedList<>();

    public Ricercatore(int codice, String nome, List<RepertiConsultati> repertiConsultati) {
        this.codice = codice;
        this.nome = nome;
        this.repertiConsultati = repertiConsultati;
    }

    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public List<RepertiConsultati> getRepertiConsultati() {
        return repertiConsultati;
    }

    @Override
    public String toString() {
        String listaRicerche = (repertiConsultati.size() > 0) ? "[" : "";
        for(RepertiConsultati r : repertiConsultati) {
            listaRicerche += r.toString() + ",";
        }
        listaRicerche += (repertiConsultati.size() > 0) ? "]" : "";
        return getCodice() + "\t" + getNome() + "\t" + repertiConsultati.size() + "\t" + listaRicerche;
    }
}
