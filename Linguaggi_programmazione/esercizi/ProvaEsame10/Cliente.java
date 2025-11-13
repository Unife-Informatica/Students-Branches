import java.util.List;

public abstract class Cliente {
  protected String tipoClienteString;
  protected int codCliente, codFilialeAtt;
  protected List<Integer> listaExFiliali;
  protected float premioCorrente;
  
  public Cliente(String tipoClienteString, int codCliente, int codFilialeAtt, List<Integer> listaExFiliali,
      float premioCorrente) {
    this.tipoClienteString = tipoClienteString;
    this.codCliente = codCliente;
    this.codFilialeAtt = codFilialeAtt;
    this.listaExFiliali = listaExFiliali;
    this.premioCorrente = premioCorrente;
  }

  public String getTipoClienteString() {
    return tipoClienteString;
  }

  public int getCodCliente() {
    return codCliente;
  }

  public int getCodFilialeAtt() {
    return codFilialeAtt;
  }

  public List<Integer> getListaExFiliali() {
    return listaExFiliali;
  }

  public float getPremioCorrente() {
    return premioCorrente;
  }
}
