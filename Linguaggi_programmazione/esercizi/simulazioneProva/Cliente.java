import java.util.List;

public class Cliente {
  private int codiceCliente;
  private String nomeCliente;
  private List<Servizio> listaServizi;
  
  public Cliente(int codiceCliente, String nomeCliente, List<Servizio> listaServizi) {
    this.codiceCliente = codiceCliente;
    this.nomeCliente = nomeCliente;
    this.listaServizi = listaServizi;
  }

  public int getCodiceCliente() {
    return codiceCliente;
  }

  public String getNomeCliente() {
    return nomeCliente;
  }

  public List<Servizio> getListaServizi() {
    return listaServizi;
  }
}
