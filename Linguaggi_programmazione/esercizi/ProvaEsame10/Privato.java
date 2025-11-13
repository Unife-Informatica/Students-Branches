import java.util.List;

public class Privato extends Cliente{
  private String nomeCognome;

  public Privato(String tipoClienteString, int codCliente, int codFilialeAtt, List<Integer> listaExFiliali,
      float premioCorrente, String nomeCognome) {
    super(tipoClienteString, codCliente, codFilialeAtt, listaExFiliali, premioCorrente);
    this.nomeCognome = nomeCognome;
  }

  public String getNomeCognome() {
    return nomeCognome;
  }
}
