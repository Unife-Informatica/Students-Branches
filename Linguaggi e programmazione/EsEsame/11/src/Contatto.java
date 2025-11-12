import java.util.List;

public class Contatto{
    private final int codiceIscritto;
    private final List<Integer> listaCollegati;
    public Contatto(int codiceIscritto, List<Integer> listaCollegati) {
        this.codiceIscritto = codiceIscritto;
        this.listaCollegati = listaCollegati;
    }
    public int getCodiceIscritto() {
        return codiceIscritto;
    }
    public List<Integer> getListaCollegati() {
        return listaCollegati;
    }
    
    
    
}