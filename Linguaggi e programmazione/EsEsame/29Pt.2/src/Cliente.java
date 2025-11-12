import java.util.List;

public class Cliente {
    private int codCliente;
    private String nomeCognome;
    private List<Servizio> listaServizi;
    public Cliente(int codCliente, String nomeCognome, List<Servizio> listaServizi) {
        this.codCliente = codCliente;
        this.nomeCognome = nomeCognome;
        this.listaServizi = listaServizi;
    }
    public int getCodCliente() {
        return codCliente;
    }
    public String getNomeCognome() {
        return nomeCognome;
    }
    public List<Servizio> getListaServizi() {
        return listaServizi;
    }
    
}
