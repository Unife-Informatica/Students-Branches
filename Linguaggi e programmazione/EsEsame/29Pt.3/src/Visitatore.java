import java.util.List;

public class Visitatore {
    private int codVisistatore;
    private String nomeCognome;
    List<Servizio> listaServizi;
    public Visitatore(int codVisistatore, String nomeCognome, List<Servizio> listaServizi) {
        this.codVisistatore = codVisistatore;
        this.nomeCognome = nomeCognome;
        this.listaServizi = listaServizi;
    }
    public int getCodVisistatore() {
        return codVisistatore;
    }
    public String getNomeCognome() {
        return nomeCognome;
    }
    public List<Servizio> getListaServizi() {
        return listaServizi;
    }
    
}
